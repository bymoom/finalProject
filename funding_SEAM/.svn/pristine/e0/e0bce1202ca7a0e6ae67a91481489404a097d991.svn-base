package com.funding.service.myinfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.funding.dto.CalendarVO;

public interface CalendarService {
	void insertDailyCheck(CalendarVO cal) throws SQLException;
	
	List<String> getAttendanceList(int mem_num)throws SQLException;	

	int selectTodayCheck(int mem_num) throws SQLException;
}
