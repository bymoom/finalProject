package com.funding.controller.faq;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.funding.dto.FaqVO;
import com.funding.request.SearchCriteria;
import com.funding.service.FaqService;


@Controller
@RequestMapping("/FAQ/*")
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@RequestMapping("list")
	public ModelAndView FAQList(ModelAndView model,SearchCriteria cri)throws Exception{
		String url="FAQ/list.page";
		
		model.addAllObjects(faqService.selectFaqList(cri));
		model.setViewName(url);
		return model;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.GET)
	public String FAQRegistGET()throws Exception{
		String url="FAQ/regist.open";
		
		return url;
	}
	
	@RequestMapping(value="regist",method=RequestMethod.POST)
	public String FAQRegistPOST(FaqVO faq)throws Exception{
		String url="FAQ/regist_success";
		
		try {
			faqService.insertFAQ(faq);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@RequestMapping(value="modify",method=RequestMethod.GET)
	public ModelAndView FAQModifyGET(int faq_num,ModelAndView model)throws Exception{
		String url="FAQ/modify.open";
		
		FaqVO faq = faqService.selectFaqRead(faq_num);
		
		model.addObject("faq",faq);
		model.setViewName(url);
		
		return model;
	}
	
	@RequestMapping(value="modify",method=RequestMethod.POST)
	public String FAQModifyPOST(FaqVO faq)throws Exception{
		String url="FAQ/modify_success";
		
		try {
			faqService.modifyFAQ(faq);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	@RequestMapping("delete")
	public String FAQDelete(int faq_num)throws Exception{
		String url="FAQ/delete_success";
		try {
			faqService.deleteFAQ(faq_num);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return url;
	}
}
