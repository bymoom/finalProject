package com.funding.controller;

import java.io.File;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resources;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;

import com.funding.dao.Notice_atcDAO;
import com.funding.dto.FreeBoardCmtsVO;
import com.funding.dto.MemberVO;
import com.funding.dto.NoticeVO;
import com.funding.dto.Notice_atcVO;
import com.funding.request.SearchCriteria;
import com.funding.service.MemberService;
import com.funding.service.NoticeService;
import com.funding.util.MediaUtils;
import com.funding.util.Summernote;

@Controller
@RequestMapping("/board/notice")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}
	
	@Autowired
	private Notice_atcDAO attachDAO;
	
	@Autowired
	private String summernoteImgPath;
	
	@Autowired
	private String uploadPath;
	
	@Autowired
	private MemberService memService;
	
	@RequestMapping("notice_list")
	public ModelAndView noticeList(SearchCriteria cri,ModelAndView mnv)throws Exception{
		String url="board/notice/notice_list.page";
		
		Map<String, Object> dataMap = noticeService.getNoticeList(cri);
		
		List<ColName> colNames = new ArrayList<ColName>();
		
		String[] colNameArr = {"","번&nbsp;호","제&nbsp;목","작성일","작성자","첨&nbsp;부","조회수"};
		String[] colWidthArr = {"3","6","45","20","10","6","9"};
		for(int i=0;i<colNameArr.length;i++) {
			colNames.add(new ColName(colNameArr[i], colWidthArr[i]));
		}
		
		dataMap.put("colNames", colNames);
		
		mnv.addAllObjects(dataMap);
		System.out.println(dataMap);
		mnv.setViewName(url);
		
		return mnv;		
	}
	
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public ModelAndView registForm(ModelAndView mnv)throws Exception{
		String url="board/notice/regist.page";

		/**
		 * summernote_js.jsp로 어느 게시판인지 보내기 용도
		 * 해당 게시판의 url 입력할 것.
		 */
		String where = "board/notice";
		mnv.addObject("where", where);
		//
		
		mnv.setViewName(url);
		return mnv;
		
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public void regist(NoticeVO notice, HttpServletResponse response)throws Exception{
		
		noticeService.regist(notice);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('게시물이 등록되었습니다');");
		out.println("location.href='notice_list.page';");
		out.println("</script>");
		
	}
	
	@RequestMapping(value="uploadImg", produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadImg(MultipartFile file, HttpServletRequest request) throws Exception {
		
		ResponseEntity<String> result = null;

		System.out.println("upload.getOriginalFilename() : " + file.getOriginalFilename());
		
		/**
		 * summernote 이미지 업로드 용도
		 */
		String savePath = this.summernoteImgPath;
		String where = "notice"; //새로 생성될 폴더명
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
		String where = "notice"; //이미지가 저장되어있는 폴더명
		
		Summernote summernote = new Summernote();
		result = summernote.deleteImg(request, fileName, savePath, where);
		
		return result;
	}
	
	@RequestMapping(value="detail",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView detail(int notice_num,ModelAndView mnv)throws Exception{
		String url="board/notice/detail.page";
		
		NoticeVO notice = noticeService.getNotice(notice_num);
		MemberVO member = memService.getMember(notice.getMem_num());
		
		mnv.addObject("notice",notice);
		mnv.addObject("member", member );
		mnv.setViewName(url);
		return mnv;
	}
	
	@RequestMapping(value="notice_modify",method=RequestMethod.GET)
	public ModelAndView modifyForm(int notice_num, ModelAndView mnv)throws Exception{
		String url="board/notice/notice_modify.page";
		NoticeVO notice=noticeService.getNotice(notice_num);
		
		mnv.addObject("notice",notice);
		mnv.setViewName(url);
		String where = "board/notice";
		mnv.addObject("where", where);
	
		return mnv;
	
		
	}
	//, String oldAttach, HttpSession session, HttpServletResponse response
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public void modify(NoticeVO notice,MultipartFile file, 
						String oldAttach,
						int[] deleteAttach,
						HttpSession session, HttpServletResponse response)throws Exception{
//		System.out.println(file);
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		int loginUser_length=("/"+loginUser.getMem_num()).length();
			
		
		if(oldAttach!=null && !oldAttach.isEmpty()) {
			String[] fileNames = oldAttach.split(",");
			for(String ntc_atc_fileName : fileNames) {
				String formatName = ntc_atc_fileName.substring(ntc_atc_fileName.lastIndexOf(".")+1);
				MediaType media = MediaUtils.getMediaType(formatName);
				System.out.println("olddddddddddddddddddddddddddd" +ntc_atc_fileName);
				
				if(media !=null) {
					String front = ntc_atc_fileName.substring(0,12+loginUser_length);
					String end = ntc_atc_fileName.substring(14+loginUser_length);
					
					System.out.println("------->>>>>> " + uploadPath + (front + end).replace('/',File.separatorChar));
					new File(uploadPath + (front + end).replace('/',File.separatorChar)).delete();
					
				}
				new File(uploadPath + ntc_atc_fileName.replace('/', File.separatorChar)).delete();
				System.out.println("<<<<<<<------->>>>>> " + uploadPath + ntc_atc_fileName.replace('/',File.separatorChar));
				System.out.println("^^^^^^^^^^^^^^^^^ : "+uploadPath);
			}
			
			for(int num:deleteAttach) {
				attachDAO.deleteAttach(num); //전부삭제 x 선택 delete ->하고 남은 기존파일 그대로 가져가야지! 
				
			}
		}
		
		
		noticeService.modify(notice);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%" +notice);  //xxxxxxxxxxxxx
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('게시물이 수정되었습니다');");
		//out.println("window.opener.location.reload();");
		out.println("location.href='detail?notice_num="+notice.getNotice_num()+"';");
		out.println("</script>");
		
	}
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public void remove(int notice_num,HttpServletResponse response)throws Exception{
		
		noticeService.remove(notice_num);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('게시물이 삭제되었습니다');");
		out.println("location.href='notice_list.page';");
		out.println("</script>");
	}
	
/*	@RequestMapping(value="getAttach/{notice_num}",method=RequestMethod.GET)
	@ResponseBody
	public List<Notice_atcVO>getAttach(@PathVariable("notice_num")int notice_num)throws Exception{
		System.out.println("12321");
		
		NoticeVO notice=noticeService.getNotice(notice_num);
		List<Notice_atcVO> attachList=notice.getAttachList();
		for(Notice_atcVO attach : attachList) {
			System.out.println("attach.toString() : " + attach.toString());
		}
		return attachList;
		
	}*/
	
	@RequestMapping(value="addPoint", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> addPoint(int notice_num) throws Exception {
		ResponseEntity<String> result = null;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!"+notice_num);
		
		NoticeVO notice = new NoticeVO();
		notice.setNotice_num(notice_num);
		notice.setNotice_point(1);
		
		try {
			
			noticeService.updatePoint(notice);
			result = new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			result=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;

	}
	@RequestMapping(value="delPoint", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> delPoint(int notice_num) throws Exception {
		ResponseEntity<String> result = null;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!"+notice_num);
		
		NoticeVO notice = new NoticeVO();
		notice.setNotice_num(notice_num);  //받은 노티스 넘을
		notice.setNotice_point(0);		   //0(일반)으로 set
		
		try {
			
			noticeService.updatePoint(notice);
			result = new ResponseEntity<>(HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			result=new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return result;
		
	}
	

	
	
	
	
	
	
	
	

}
