package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.FaqVO;
import com.funding.request.SearchCriteria;

public interface FaqDAO {
	//FAQ 전제리스트
	List<FaqVO> selectFaqList(SearchCriteria cri)throws SQLException;

	// FAQ 하나 조회
	FaqVO selectFaqListByFaqNum(int faq_num)throws SQLException;
	
	//FAQ 총 갯수
	int selectFaqListCount(SearchCriteria cri)throws SQLException;
	
	//FAQ 시퀀스(글번호 받기)
	int selectFaqSeqNext()throws SQLException;
	
	//FAQ 등록
	void insertFAQ(FaqVO faq)throws SQLException;
	
	//FAQ 수정
	void modifyFAQ(FaqVO faq)throws SQLException;
	
	//FAQ 삭제
	void deleteFAQ(int faq_num)throws SQLException;
	
	//조회수 증가
	void increaseViewCnt(int faq_num)throws SQLException;
}
