package com.funding.dao.myinfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.funding.dto.CalendarVO;

public interface CalendarDAO {
	
	int selectTodayCheck(int mem_num) throws SQLException;
	
	void insertDailyCheck(CalendarVO cal) throws SQLException;
	
	List<String> selectAllAttendanceDateByNum(int mem_num) throws SQLException;

}
