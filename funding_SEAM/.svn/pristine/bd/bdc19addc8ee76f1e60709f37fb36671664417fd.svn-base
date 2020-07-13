package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.funding.dto.QnAVO;
import com.funding.request.SearchCriteria;

public class QnADAOImpl implements QnADAO{
	
	@Autowired
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}


	@Override
	public List<QnAVO> selectQnAList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnAVO> qnaList = sqlSession.selectList("QA-Mapper.selectQnAList",cri, rowBounds);
		return qnaList;
	}
	

	@Override
	public List<QnAVO> selectQnAListExptDisabled(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		List<QnAVO> qnaList = sqlSession.selectList("QA-Mapper.selectQnAListExptDisabled",cri, rowBounds);
		return qnaList;
	}
	

	@Override
	public int selectSearchQnAListTotalCount(SearchCriteria cri) throws SQLException {
		// 검색결과의 개수
		int count = sqlSession.selectOne("QA-Mapper.selectSearchQnAListTotalCount",cri);
		return count;
	}

	@Override
	public int selectSearchQnAListTotalCountExptDisabled(SearchCriteria cri) throws SQLException {
		// 검색결과의 개수
		int count = sqlSession.selectOne("QA-Mapper.selectSearchQnAListTotalCountExptDisabled",cri);
		return count;
	}


	@Override
	public QnAVO selectQnAByqna_Num(int qna_num) throws SQLException {
		QnAVO qna = sqlSession.selectOne("QA-Mapper.selectQnAByqna_Num",qna_num);
		return qna;
	}


	@Override
	public void registQnA(QnAVO qna) throws SQLException {
		sqlSession.update("QA-Mapper.registQnA",qna);
		
	}

	@Override
	public void registQnAnone(QnAVO qna) throws SQLException {
		sqlSession.update("QA-Mapper.registQnAnone",qna);
		
	}

	@Override
	public void modifyQnA(QnAVO qna) throws SQLException {
		sqlSession.update("QA-Mapper.modifyQnA",qna);
		
	}


	@Override
	public void removeQnA(int qna_num) throws SQLException {
		sqlSession.update("QA-Mapper.removeQnA",qna_num);
		
	}


	@Override
	public void increaseQnAViewCnt(int qna_num) throws SQLException {
		sqlSession.update("QA-Mapper.increaseQnAViewCnt",qna_num);
		
	}


	@Override
	public int selectQnASeqNext() throws SQLException {
		int seq_num = sqlSession.selectOne("QA-Mapper.selectQnASeqNext");
		return seq_num;
	}


	@Override
	public void registCmts(QnAVO qna) throws SQLException {
		System.out.println(qna);
		sqlSession.update("QA-Mapper.registCmts",qna);
		
	}
	
	@Override
	public List<QnAVO> selectQnACmtsList(int qna_num) throws SQLException {
		List<QnAVO> qnaCmtsList = sqlSession.selectList("QA-Mapper.selectQnACmtsList",qna_num);
		return qnaCmtsList;
	}


	@Override
	public void modifyCmts(QnAVO qna) throws SQLException {
		sqlSession.update("QA-Mapper.modifyCmts", qna);
		
	}

	@Override
	public void removeCmts(int qna_cmts_num) throws SQLException {
		sqlSession.update("QA-Mapper.removeCmts",qna_cmts_num);
		
	}


	@Override
	public QnAVO countQnACmts(int qna_cmts_num) throws SQLException {
		QnAVO cmts = sqlSession.selectOne("QA-Mapper.countQnACmts",qna_cmts_num);
		return cmts;
	}


	@Override
	public void checkQnAEnabled(int qna_num) throws SQLException {
		sqlSession.update("QA-Mapper.checkQnAEnabled", qna_num);
		
	}


	@Override
	public void checkQnADisabled(int qna_num) throws SQLException {
		sqlSession.update("QA-Mapper.checkQnADisabled", qna_num);
		
		
	}





}
