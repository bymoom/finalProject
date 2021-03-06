package com.funding.controller.freeboard;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dao.freeboard.FreeBoardCmtsDAO;
import com.funding.dao.freeboard.FreeBoardDAO;
import com.funding.dto.FreeBoardCmtsVO;
import com.funding.dto.FreeBoardVO;
import com.funding.dto.MemberVO;
import com.funding.dto.Thumb_upVO;
import com.funding.request.PreOrNextForBoardRequest;
import com.funding.request.SearchCriteria;
import com.funding.security.User;
import com.funding.service.MemberService;
import com.funding.service.ThumbUpService;
import com.funding.service.freeboard.FreeBoardCmtsService;
import com.funding.service.freeboard.FreeBoardService;
import com.funding.util.Summernote;

@Controller
@RequestMapping("/board/free/*")
public class FreeBoardController {

	@Autowired
	private FreeBoardService freeBoardService;

	@Autowired
	private FreeBoardDAO freeBoardDAO;
	
	@Autowired
	private FreeBoardCmtsService freeBoardCmtsService;
	
	@Autowired
	private FreeBoardCmtsDAO freeBoardCmtsDAO;
	
	@Autowired
	private ThumbUpService thumbUpService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private String summernoteImgPath;
	
	@RequestMapping(value="list")
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv, HttpServletRequest request) throws Exception {
		String url = "board/free/list.page";
		
		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		//System.out.println("session.getId() : " + loginUser.getCode_num() + "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		
		Map<String, Object> dataMap = null;
		
		try {
			if(loginUser != null && loginUser.getCode_num() == 0) { //관리자인 경우
				dataMap = freeBoardService.getFreeBoardList(cri);
			}else if(loginUser == null || loginUser != null) { //그 외
				dataMap = freeBoardService.getSearchFreeBoardListForEnabled(cri);
			}
			
			mnv.addAllObjects(dataMap);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="registForm")
	public ModelAndView registForm(ModelAndView mnv) throws Exception {
		String url = "board/free/regist.page";
		
		/**
		 * summernote_js.jsp로 어느 게시판인지 보내기 용도
		 * 해당 게시판의 url 입력할 것.
		 */
		String where = "board/free";
		mnv.addObject("where", where);
		//
		
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="uploadImg", produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadImg(MultipartFile file, HttpServletRequest request) throws Exception {
		
		ResponseEntity<String> result = null;

		//System.out.println("upload.getOriginalFilename() : " + file.getOriginalFilename());
		
		/**
		 * summernote 이미지 업로드 용도
		 */
		String savePath = this.summernoteImgPath;
		String where = "freeboard"; //새로 생성될 폴더명
		Summernote summernote = new Summernote();
		result = summernote.uploadImg(file, request, savePath, where);
		//
		
		return result;
	}

	@RequestMapping(value="deleteImg", produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> deleteImg(String fileName, HttpServletRequest request) throws Exception {
		ResponseEntity<String> result = null;
		String savePath = this.summernoteImgPath;
		String where = "freeboard"; //이미지가 저장되어있는 폴더명
		
		Summernote summernote = new Summernote();
		result = summernote.deleteImg(request, fileName, savePath, where);
		
		return result;
	}
	
	@RequestMapping(value="regist", method=RequestMethod.POST)
	public void regist(FreeBoardVO freeBoard, HttpServletResponse response) throws Exception {

/*		String mem_name = freeBoard.getMem_name();
		MemberVO member = memberService.getMemberByName(mem_name);
		
		freeBoard.setMem_num(member.getMem_num());*/
		
		freeBoardService.regist(freeBoard);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('글이 등록되었습니다!');");
		out.println("location.href='/board/free/list.page';");
		out.println("</script>");
		
	}
	
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public ModelAndView detail(int free_num, ModelAndView mnv) throws Exception {

		String url = "board/free/detail.page";
		
		try {
			FreeBoardVO freeBoard = freeBoardService.getFreeBoard(free_num);
			List<FreeBoardCmtsVO> freeBoardCmtsList = freeBoardCmtsService.getFreeBoardCmtsList(free_num);
			MemberVO member = memberService.getMember(freeBoard.getMem_num());
			
			mnv.addObject("freeBoard", freeBoard);
			mnv.addObject("freeBoardCmtsList", freeBoardCmtsList);
			mnv.addObject("member", member);
			
			int freeCmtsCount = freeBoardCmtsDAO.countFreeBoardCmts(free_num);
			mnv.addObject("freeCmtsCount", freeCmtsCount);
			
			/**
			 * 이전글 다음글(일반회원용)
			 */
			PreOrNextForBoardRequest preOrNextForMember = freeBoardDAO.selectPreOrNext(free_num);
			mnv.addObject("preOrNextForMember", preOrNextForMember);
			/**
			 * 이전글 다음글(관리자용)
			 */
			PreOrNextForBoardRequest preOrNextForAdmin = freeBoardDAO.selectPreOrNextForAdmin(free_num);
			mnv.addObject("preOrNextForAdmin", preOrNextForAdmin);
			
			System.out.println(preOrNextForMember.getFree_num());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="modifyForm/{free_num}", method=RequestMethod.GET)
	public ModelAndView modifyForm(@PathVariable("free_num") int free_num, ModelAndView mnv) throws Exception {
		String url = "board/free/modify.page";
		
		/**
		 * summernote_js.jsp로 어느 게시판인지 보내기 용도
		 * 해당 게시판의 url 입력할 것.
		 */
		String where = "board/free";
		mnv.addObject("where", where);
		//
		
		try {
			FreeBoardVO freeBoard = freeBoardService.getFreeBoard(free_num);
			mnv.addObject("freeBoard", freeBoard);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mnv.setViewName(url);
		
		return mnv;
	}
	
	@RequestMapping(value="modify", method=RequestMethod.POST)
	public void modify(FreeBoardVO freeBoard, HttpServletResponse response) throws Exception {
		
		freeBoardService.modify(freeBoard);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("location.href='detail?free_num=" + freeBoard.getFree_num() + "';");
		out.println("</script>");
		
	}
	
	@RequestMapping(value="remove")
	public ResponseEntity<String> remove(int free_num) throws Exception {
		ResponseEntity<String> result = null;
		
		try {
			freeBoardService.remove(free_num);
			result = new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

	@RequestMapping(value="enabled", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> enabled(@RequestBody Map<String, int[]> json) throws Exception {
		ResponseEntity<String> result = null;
		
		int[] checkedTrueArr = json.get("checkedTrueList");
		int[] checkedFalseArr = json.get("checkedFalseList");
		
		FreeBoardVO freeBoard = new FreeBoardVO();

		/*for(int i = 0; i < checkedTrueArr.length; i++) {
			System.out.println(i + "번쨰 checkedTrue : " + checkedTrueArr[i]);
		}
		for(int i = 0; i < checkedFalseArr.length; i++) {
			System.out.println(i + "번째 checkedFalse : " + checkedFalseArr[i]);
		}*/
		
		try {
			for(int enabledTrueFreeNum : checkedTrueArr) {
				freeBoard.setFree_num(enabledTrueFreeNum);
				freeBoard.setFree_enabled(0); //비활성화
				freeBoardService.modifyEnabled(freeBoard);
				//System.out.println("비활성화 체크된 글 수정 성공!");
			}
			
			for(int enabledFalseFreeNum : checkedFalseArr) {
				freeBoard.setFree_num(enabledFalseFreeNum);
				freeBoard.setFree_enabled(1); //활성화
				freeBoardService.modifyEnabled(freeBoard);
				//System.out.println("비활성화 체크 안된 글 수정 성공!");
			}
			
			result = new ResponseEntity<>(HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return result;
	}
	
	@RequestMapping("thumbUpSelect")
	@ResponseBody
	public ResponseEntity<String> thumbUpSelect(Thumb_upVO thumbUp) throws Exception {
		ResponseEntity<String> result = null;
		
		try {
			thumbUp = thumbUpService.selectThumbUpForFreeBoard(thumbUp);
			
			if(thumbUp != null) {
				//thumb_up 테이블에 데이터가 있는 경우 like 리턴
				result = new ResponseEntity<>("like", HttpStatus.OK);
			}else if(thumbUp == null) {
				result = new ResponseEntity<>("likeYet", HttpStatus.OK);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			//thumb_up 테이블에 데이터가 없는 경우 error로 내보내기
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping("thumbUpRegist")
	public ResponseEntity<Integer> thumbUpRegist(Thumb_upVO thumbUp) throws Exception {
		ResponseEntity<Integer> result = null;
		
		try {
			thumbUpService.registThumbUpForFreeBoard(thumbUp);
			
			freeBoardService.modifyFreeLike(thumbUp.getFree_num(), "add");
			
			FreeBoardVO freeBoard = freeBoardService.getFreeBoard(thumbUp.getFree_num());
			int free_like = freeBoard.getFree_like();
			
			result = new ResponseEntity<>(free_like, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
	}
	
	@RequestMapping("thumbUpRemove")
	public ResponseEntity<Integer> thumbUpRemove(Thumb_upVO thumbUp) throws Exception {
		ResponseEntity<Integer> result = null;
		
		try {
			//free_num과 mem_name으로 조회하여 해당 좋아요 번호 찾기
			thumbUp = thumbUpService.selectThumbUpForFreeBoard(thumbUp);
			int thumbup_num = thumbUp.getThumbup_num();
		
			thumbUpService.removeThumbUp(thumbup_num);
			
			freeBoardService.modifyFreeLike(thumbUp.getFree_num(), "sub");
			
			FreeBoardVO freeBoard = freeBoardService.getFreeBoard(thumbUp.getFree_num());
			int free_like = freeBoard.getFree_like();
			
			result = new ResponseEntity<>(free_like, HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			result = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return result;
	}

}
