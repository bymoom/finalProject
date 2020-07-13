package com.funding.service.myinfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.funding.dao.myinfo.CalendarDAO;
import com.funding.dto.CalendarVO;

public class CalendarServiceImpl implements CalendarService {

	//CalendarDAO
	private CalendarDAO calendarDAO;
	public void setCalendarDAO(CalendarDAO calendarDAO) {
		this.calendarDAO = calendarDAO;
	}
	
	@Override
	public void insertDailyCheck(CalendarVO cal) throws SQLException {
		calendarDAO.insertDailyCheck(cal);
	}

	@Override
	public List<String> getAttendanceList(int mem_num) throws SQLException {
		List<String> dateList = calendarDAO.selectAllAttendanceDateByNum(mem_num);
		return dateList;
	}

	@Override
	public int selectTodayCheck(int mem_num) throws SQLException {
		int cnt = calendarDAO.selectTodayCheck(mem_num);
		return cnt;
	}

}
