package com.funding.dao.project;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

public class Project_state_codeDAOImpl implements Project_state_codeDAO {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String selectGetPjtStateCodeVal(int pjt_state_code) throws SQLException {
		String state = sqlSession.selectOne("Project_state_code-Mapper.selectGetPjtStateCodeVal",pjt_state_code);
		return state;
	}

}
