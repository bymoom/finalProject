package com.funding.dao.project;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

public class Project_type_codeDAOImpl implements Project_type_codeDAO {
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public String selectGetPjtTypeCodeVal(int pjt_type_code) throws SQLException {
		String type=sqlSession.selectOne("Project_type_code-Mapper.selectGetPjtTypeCodeVal",pjt_type_code);
		return type;
	}

}
