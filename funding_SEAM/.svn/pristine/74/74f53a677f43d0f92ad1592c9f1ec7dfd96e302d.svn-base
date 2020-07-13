package com.funding.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.FaqDAO;
import com.funding.dto.FaqVO;
import com.funding.dto.Project_ProposeVO;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class FaqServiceImpl implements FaqService{

	private FaqDAO faqDAO;
	public void setFaqDAO(FaqDAO faqDAO) {
		this.faqDAO = faqDAO;
	}
	
	@Override
	public Map<String, Object> selectFaqList(SearchCriteria cri) throws SQLException {
		List<FaqVO> list = faqDAO.selectFaqList(cri);
		Map<String,Object> dataMap = new HashMap<String, Object>();
		
		int totalCount = faqDAO.selectFaqListCount(cri);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("FAQ", list);
		dataMap.put("pageMaker", pageMaker);
		
		
		return dataMap;
	}

	@Override
	public FaqVO selectFaqListByFaqNum(int faq_num) throws SQLException {
		faqDAO.increaseViewCnt(faq_num);
		FaqVO faq = faqDAO.selectFaqListByFaqNum(faq_num);
		return faq;
	}
	
	@Override
	public FaqVO selectFaqRead(int faq_num) throws SQLException {
		FaqVO faq = faqDAO.selectFaqListByFaqNum(faq_num);
		return faq;
	}


	@Override
	public void insertFAQ(FaqVO faq) throws SQLException {
		int faq_num = faqDAO.selectFaqSeqNext();
		faq.setFaq_num(faq_num);
		faqDAO.insertFAQ(faq);
	}

	@Override
	public void modifyFAQ(FaqVO faq) throws SQLException {
		faqDAO.modifyFAQ(faq);
	}

	@Override
	public void deleteFAQ(int faq_num) throws SQLException {
		faqDAO.deleteFAQ(faq_num);
	}





}
