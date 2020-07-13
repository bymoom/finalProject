package com.funding.service.admin;

import java.sql.SQLException;

import com.funding.dao.admin.AdminPointManageDAO;
import com.funding.dto.PointManageVO;

public class AdminPointManageServiceImpl implements AdminPointManageService{

	private AdminPointManageDAO adminPointDAO;
	public void setAdminPointDAO(AdminPointManageDAO adminPointDAO) {
		this.adminPointDAO = adminPointDAO;
	}
	
	@Override
	public PointManageVO checkJoinPoint() throws SQLException {
		PointManageVO joinPoint =adminPointDAO.checkJoinPoint(); 
		return joinPoint;
	}

	@Override
	public PointManageVO checkAttendPoint() throws SQLException {
		PointManageVO AttendPoint =adminPointDAO.checkAttendPoint();
		return AttendPoint;
	}

	@Override
	public void joinGiveDisabled() throws SQLException {
		adminPointDAO.joinGiveDisabled();
		
	}

	@Override
	public void joinGiveEnabled() throws SQLException {
		adminPointDAO.joinGiveEnabled();
		
	}

	@Override
	public void AttendGiveEnabled() throws SQLException {
		adminPointDAO.AttendGiveEnabled();
		
	}

	@Override
	public void AttendGiveDisabled() throws SQLException {
		adminPointDAO.AttendGiveDisabled();
		
	}

	@Override
	public void updateJoinPoint(int point) throws SQLException {
		adminPointDAO.updateJoinPoint(point);
		
	}

	@Override
	public void updateAttendPoint(int point) throws SQLException {
		adminPointDAO.updateAttendPoint(point);
	}

}
