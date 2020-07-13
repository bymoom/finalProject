package com.funding.dao.member;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.ComMemberVO;

public class ComMemberDAOImpl implements ComMemberDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public ComMemberVO selectComMemberByMemNum(int mem_num) throws SQLException {
		ComMemberVO comMember = sqlSession.selectOne("ComMember-Mapper.selectComMemberByMemNum",mem_num);
		return comMember;
	}

}
