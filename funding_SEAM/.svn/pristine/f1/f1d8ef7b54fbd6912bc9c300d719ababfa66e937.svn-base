package com.funding.controller.mypage.paylist;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.MemberVO;
import com.funding.dto.ProjectVO;
import com.funding.request.PaylistSearchCriteria;
import com.funding.request.SearchCriteria;
import com.funding.service.project.Pjt_bank_sum_attachService;
import com.funding.service.project.Pjt_pay_detailService;
import com.funding.service.project.ProjectService;

@Controller
@RequestMapping("/mypage/paylist")
public class MypagePaylistController {

	@Autowired
	public ProjectService projectService;
	
	@Autowired
	public Pjt_pay_detailService pjt_pay_detailService;

	@Autowired
	public Pjt_bank_sum_attachService pjt_bank_sum_attachService;
	
	@RequestMapping("/list")
	public ModelAndView showPaylist(PaylistSearchCriteria cri, ModelAndView mav, int mem_num) throws SQLException {
		String url = "mypage/paylist/list.mypage";
		
		Map<String, Object> dataMap = null;
		dataMap = pjt_pay_detailService.getPjtAllPayListByMemNum(cri, mem_num);
		
		mav.addAllObjects(dataMap);
		mav.setViewName(url);
		return mav;
	}
	
	@RequestMapping("/askRefundList")
	public ModelAndView showPaylistForRefund(SearchCriteria cri, ModelAndView mav, int mem_num) throws SQLException {
		String url = "mypage/askRefund/list.mypage";
		
		Map<String, Object> dataMap = null;
		dataMap = pjt_pay_detailService.getPjtPayListByMemNum(cri, mem_num);
		
		mav.addAllObjects(dataMap);
		mav.setViewName(url);
		return mav;
	}
	
//	@RequestMapping(value = "/askRefund", method = RequestMethod.GET)
//	public void askRefundByGet(HttpServletRequest request,
//						  HttpServletResponse response,
//		 				  int pjt_pay_num) throws Exception {
//	}
	
	@RequestMapping("/askRefund")
	@ResponseBody
	public ResponseEntity<Map<String, Boolean>> askRefund(int pjt_pay_num) throws Exception {
		ResponseEntity<Map<String, Boolean>> entity = null;
		
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		result.put("result", false);
		
		try {
			pjt_pay_detailService.updateAskRefundStateToOne(pjt_pay_num);
			result.put("result", true);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Map<String, Boolean>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		entity = new ResponseEntity<Map<String, Boolean>>(result, HttpStatus.OK);
		return entity;
	}
	
	
//	@RequestMapping("/payType")
//	public ModelAndView payType(SearchCriteria cri, ModelAndView mav, int mem_num) throws SQLException {
//		String url = "mypage/paylist/list.mypage";
//
//		Map<String, Object> dataMap = null;
//		dataMap = pjt_pay_detailService.getPjtPayTypePayListByMemNum(cri, mem_num);
//		
//		mav.addAllObjects(dataMap);
//		mav.setViewName(url);
//		
//		return mav;
//	}

	@RequestMapping(value = "/payType", method = RequestMethod.POST)
	public String payType(Model model, PaylistSearchCriteria cri, ModelAndView mav, HttpSession session) throws SQLException {
		String url = "mypage/paylist/list.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		int mem_num = member.getMem_num();

		Map<String, Object> dataMap = null;
		dataMap = pjt_pay_detailService.getPjtPayTypePayListByMemNum(cri, mem_num);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	
	@RequestMapping(value = "/refundState", method = RequestMethod.POST)
	public String refundState(Model model, PaylistSearchCriteria cri, ModelAndView mav, HttpSession session) throws SQLException {
		String url = "mypage/paylist/list.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		int mem_num = member.getMem_num();

		Map<String, Object> dataMap = null;
		dataMap = pjt_pay_detailService.getPjtPayTypePayListByMemNum(cri, mem_num);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping(value = "/keyword", method = RequestMethod.POST)
	public String searchKeyword(Model model, PaylistSearchCriteria cri, ModelAndView mav, HttpSession session) throws SQLException {
		String url = "mypage/paylist/list.mypage";
		
		MemberVO member = (MemberVO)session.getAttribute("loginUser");
		
		int mem_num = member.getMem_num();

		Map<String, Object> dataMap = null;
		dataMap = pjt_pay_detailService.getPjtPayTypePayListByMemNum(cri, mem_num);
		model.addAllAttributes(dataMap);
		
		return url;
	}
	
	@RequestMapping("/detail")
	public ModelAndView projectDetail(ModelAndView mav, int pjt_num) throws SQLException{
		String url="project/project_detail.page";
		
		ProjectVO project = projectService.getProject(pjt_num);
		
		mav.addObject("project",project);
		
		String sumnail=pjt_bank_sum_attachService.getSumnail(pjt_num);
		mav.addObject("sumnail",sumnail);
		mav.setViewName(url);
		
		return mav;
	}

}









