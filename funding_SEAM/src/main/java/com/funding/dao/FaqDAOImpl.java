package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.FaqVO;
import com.funding.request.SearchCriteria;

public class FaqDAOImpl implements FaqDAO{

	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<FaqVO> selectFaqList(SearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<FaqVO> list = sqlSession.selectList("Faq-Mapper.selectFaqList",cri,rowBounds);
		return list;
	}

	@Override
	public FaqVO selectFaqListByFaqNum(int faq_num) throws SQLException {
		FaqVO faq = sqlSession.selectOne("Faq-Mapper.selectFaqListByFaqNum",faq_num);
		return faq;
	}

	@Override
	public int selectFaqListCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Faq-Mapper.selectFaqListCount",cri);
		return count;
	}

	@Override
	public int selectFaqSeqNext() throws SQLException {
		int seq = sqlSession.selectOne("Faq-Mapper.selectFaqSeqNext");
		return seq;
	}

	@Override
	public void insertFAQ(FaqVO faq) throws SQLException {
		sqlSession.update("Faq-Mapper.insertFAQ",faq);
		
	}

	@Override
	public void modifyFAQ(FaqVO faq) throws SQLException {
		sqlSession.update("Faq-Mapper.modifyFAQ",faq);
		
	}

	@Override
	public void deleteFAQ(int faq_num) throws SQLException {
		sqlSession.update("Faq-Mapper.deleteFAQ",faq_num);
		
	}

	@Override
	public void increaseViewCnt(int faq_num) throws SQLException {
		sqlSession.update("Faq-Mapper.increaseViewCnt",faq_num);
	}

}
