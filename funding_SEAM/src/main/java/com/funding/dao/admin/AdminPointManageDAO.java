package com.funding.dao.admin;

import java.sql.SQLException;

import com.funding.dto.PointManageVO;

public interface AdminPointManageDAO {
	
	PointManageVO checkJoinPoint()throws SQLException;
	
	PointManageVO checkAttendPoint()throws SQLException;
	
	void joinGiveDisabled()throws SQLException;
	
	void joinGiveEnabled()throws SQLException;
	
	void AttendGiveEnabled()throws SQLException;
	
	void AttendGiveDisabled()throws SQLException;
	
	void updateJoinPoint(int point)throws SQLException;
	
	void updateAttendPoint(int point)throws SQLException;
	
}
