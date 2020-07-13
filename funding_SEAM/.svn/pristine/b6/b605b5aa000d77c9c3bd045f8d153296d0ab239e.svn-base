package com.funding.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Notice_atcVO;

public class Notice_atcDAOImpl implements Notice_atcDAO{
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Notice_atcVO> selectAttachByNotice_num(int notice_num) throws SQLException {
		List<Notice_atcVO> attachList = sqlSession.selectList("ntc-atc-mapper.selectAttachByNotice_num",notice_num);
		return attachList;
	}

	@Override
	public Notice_atcVO selectAttachByNtc_atc_num(int ntc_atc_num) throws SQLException {
		Notice_atcVO attach= sqlSession.selectOne("ntc-atc-mapper.selectAttachByNtc_atc_num",ntc_atc_num);
		return attach;
	}

	@Override
	public void insertAttach(Notice_atcVO attach) throws SQLException {
		sqlSession.update("ntc-atc-mapper.insertAttach",attach);
		
	}

	@Override
	public void deleteAttach(int ntc_atc_num) throws SQLException {
		sqlSession.update("ntc-atc-mapper.deleteAttach",ntc_atc_num);
		
	}

	@Override
	public void deleteAllAttach(int notice_num) throws SQLException {
		sqlSession.update("ntc-atc-mapper.deleteAllAttach", notice_num);
		
	}


}
