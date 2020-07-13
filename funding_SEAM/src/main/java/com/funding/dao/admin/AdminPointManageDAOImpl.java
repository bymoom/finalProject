package com.funding.dao.admin;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.PointManageVO;

public class AdminPointManageDAOImpl implements AdminPointManageDAO{

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public PointManageVO checkJoinPoint() throws SQLException {
		PointManageVO joinPoint = sqlSession.selectOne("PointManage-Mapper.checkJoinPoint"); 
		return joinPoint;
	}

	@Override
	public PointManageVO checkAttendPoint() throws SQLException {
		PointManageVO attendPoint = sqlSession.selectOne("PointManage-Mapper.checkAttendPoint");
		return attendPoint;
	}

	@Override
	public void joinGiveDisabled() throws SQLException {
		sqlSession.update("PointManage-Mapper.joinGiveDisabled");
		
	}

	@Override
	public void joinGiveEnabled() throws SQLException {
		sqlSession.update("PointManage-Mapper.joinGiveEnabled");
		
	}

	@Override
	public void AttendGiveEnabled() throws SQLException {
		sqlSession.update("PointManage-Mapper.AttendGiveEnabled");
		
	}

	@Override
	public void AttendGiveDisabled() throws SQLException {
		sqlSession.update("PointManage-Mapper.AttendGiveDisabled");
		
	}

	@Override
	public void updateJoinPoint(int point) throws SQLException {
		sqlSession.update("PointManage-Mapper.updateJoinPoint",point);
		
	}

	@Override
	public void updateAttendPoint(int point) throws SQLException {
		sqlSession.update("PointManage-Mapper.updateAttendPoint",point);
		
	}

}
