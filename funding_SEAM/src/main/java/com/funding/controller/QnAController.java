package com.funding.controller;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.MemberVO;
import com.funding.dto.QnAVO;
import com.funding.request.SearchCriteria;
import com.funding.service.MemberService;
import com.funding.service.QnAService;
import com.funding.util.Summernote;

@Controller
@RequestMapping("/qna/")
public class QnAController {
	@Autowired
	private QnAService qnaService;
	public void setQnaService(QnAService qnaService) {
		this.qnaService = qnaService;
	}
	
	@Autowired
	private String summernoteImgPath;
	
	@Autowired
	private String uploadPath;
	
	@Autowired
	private MemberService memService;

	
	@RequestMapping("list")
	public ModelAndView qnaList(ModelAndView model,SearchCriteria cri,HttpServletRequest reqest)throws Exception{
		String url="qna/list.page";
		
		HttpSession session = reqest.getSession();
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		
		Map<String, Object> dataMap = null;
		
		try {
			if(loginUser !=null && loginUser.getCode_num() == 0) {  //관리자
				dataMap = qnaService.getAllQnAList(cri);
			}else {													//그 외 유저
				dataMap = qnaService.getAllQnAListExptDisabled(cri);
			}
			model.addAllObjects(dataMap);
			
		}catch (Exception e) {
			e.printStackTrace();
		}

		model.setViewName(url);
		
		return model;
		
	} 
	@RequestMapping("detail")
	public ModelAndView qnaDetail(ModelAndView mnv,int qna_num,QnAVO qna)throws Exception{
		String url="qna/detail.page";
		
		qna = qnaService.getDetail(qna_num);
		MemberVO member = memService.getMember(qna.getMem_num());
		mnv.addObject("qna",qna);
		mnv.addObject("member", member);
		mnv.setViewName(url);
		
		return mnv;
	}
	@RequestMapping("pwdChk")
	public ModelAndView pwdChk(ModelAndView mnv,int qna_num,String qna_pwd,QnAVO qna)throws Exception{
		String url="qna/pwdChk.page";
		qna = qnaService.getDetail(qna_num);
		mnv.addObject("qna",qna);
		mnv.setViewName(url);
		return mnv;
		
		
	}
	@RequestMapping(value="registForm",method=RequestMethod.GET)
	public ModelAndView registForm(ModelAndView mnv,HttpSession session)throws Exception{
		String url="qna/registForm.page";
		
		mnv.setViewName(url);
		String where = "qna";
		mnv.addObject("where",where);
		
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
		String where = "qna"; //새로 생성될 폴더명
		Summernote summernote = new Summernote();
		result = summernote.uploadImg(file, request, savePath, where);
		
		return result;
	}
	@RequestMapping(value="deleteImg", produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> deleteImg(String fileName, HttpServletRequest request) throws Exception {
		ResponseEntity<String> result = null;
		String savePath = this.summernoteImgPath;
		String where = "qna"; //이미지가 저장되어있는 폴더명
		
		Summernote summernote = new Summernote();
		result = summernote.deleteImg(request, fileName, savePath, where);
		
		return result;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String regist(QnAVO qna)throws Exception{
		String url="qna/regist";
		
		qnaService.regist(qna);
		
		return url;
	
	}
	@RequestMapping(value="remove",method=RequestMethod.POST)
	public void remove(int qna_num,HttpSession session, HttpServletResponse res)throws Exception{
		qnaService.remove(qna_num);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('게시물이 삭제되었습니다');");
		out.println("location.href='list.page';");
		out.println("</script>");
		
	}
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public ModelAndView modify(int qna_num,HttpSession session, ModelAndView mnv)throws Exception{
		String url="qna/modify.page";
		QnAVO qna = qnaService.getDetail(qna_num);
		
		mnv.addObject("qna",qna);
		mnv.setViewName(url);
		String where = "qna";
		mnv.addObject("where",where);
		
		return mnv;
	}
	
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public void modify(QnAVO qna,HttpServletResponse res)throws Exception{
		qnaService.modify(qna);
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('게시물이 수정되었습니다');");
//		out.println("window.opener.location.reload();");
		out.println("location.href='detail?qna_num="+qna.getQna_num()+"';");
		out.println("</script>");
	}
	
	@RequestMapping(value="registCmts",method=RequestMethod.GET)
	public ModelAndView registCmts(int qna_num,ModelAndView mnv)throws Exception{
		String url="qna/registCmts.page";
		QnAVO qna = qnaService.getDetail(qna_num);
//		qna.setQna_cmts_num(qna_num);
		
		mnv.addObject("qna",qna);
		mnv.setViewName(url);
		String where = "qna";
		mnv.addObject("where",where);
		
		return mnv;
	}
	
	@RequestMapping(value="registCmts",method=RequestMethod.POST)
	public void registCmts(QnAVO qna, HttpServletResponse res)throws Exception{
		qnaService.registCmts(qna);
		System.out.println("gggggggggggggggggggggggggggg"+qna.getQna_pwd());
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<script>");
		out.println("alert('답변완료');");
//		out.println("window.opener.location.reload();");
		out.println("location.href='detail?qna_num="+qna.getQna_num()+"';");
		out.println("</script>");
	}
	
	@RequestMapping(value="enabled",method=RequestMethod.POST)
	public ResponseEntity<String> enabled(@RequestBody Map<String,List<Integer>> json)throws Exception{
		ResponseEntity<String> entity=null;
		
		List<Integer> num = json.get("falseChecked");
		//체크된 갯수만큼 반복
		try {
			for(int i=0;i<num.size();i++) {
				int qna_num = num.get(i);
				qnaService.enabled(qna_num);
				entity = new ResponseEntity<>(HttpStatus.OK);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			entity =new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return entity;
		
	}
	@RequestMapping(value="disabled",method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> disabled(@RequestBody Map<String, List<Integer>> json)throws Exception{
		ResponseEntity<String> entity=null;
		List<Integer>num =json.get("trueChecked");
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+num);
		
		try {
			for (int i = 0; i < num.size(); i++) {
				int qna_num = num.get(i);
				qnaService.disabled(qna_num);
				entity = new ResponseEntity<>(HttpStatus.OK);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return entity;
	}
	
	

}
