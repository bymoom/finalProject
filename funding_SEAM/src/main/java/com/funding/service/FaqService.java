package com.funding.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.FaqVO;
import com.funding.request.SearchCriteria;

public interface FaqService {
	//FAQ 전제리스트
	Map<String,Object> selectFaqList(SearchCriteria cri)throws SQLException;

	// FAQ 하나 조회(조회수 증가)
	FaqVO selectFaqListByFaqNum(int faq_num)throws SQLException;
	
	// 조회수 미증가
	FaqVO selectFaqRead(int faq_num)throws SQLException;
	
	//FAQ 등록
	void insertFAQ(FaqVO faq)throws SQLException;
	
	//FAQ 수정
	void modifyFAQ(FaqVO faq)throws SQLException;
	
	//FAQ 삭제
	void deleteFAQ(int faq_num)throws SQLException;
}
