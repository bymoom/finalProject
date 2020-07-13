package com.funding.dao.member;

import java.sql.SQLException;

import com.funding.dto.PointVO;

public interface PointDAO {

	public int getPoint(int mem_num)throws SQLException;
	public void usePoint(PointVO point)throws SQLException;
	
	public void savePoint(PointVO point)throws SQLException;
	public void deletePoint(int mem_num) throws SQLException;
}
