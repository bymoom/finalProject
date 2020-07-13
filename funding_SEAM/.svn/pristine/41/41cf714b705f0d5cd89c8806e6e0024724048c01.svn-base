package com.funding.dao.myinfo;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.CalendarVO;

public class CalendarDAOImpl implements CalendarDAO {
	
	private SqlSession session;
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}
	
	@Override
	public void insertDailyCheck(CalendarVO cal) throws SQLException {
		session.update("Calendar-Mapper.insertDailyCheck", cal);
	}

	@Override
	public List<String> selectAllAttendanceDateByNum(int mem_num) throws SQLException {
		List<String> dateList = session.selectList("Calendar-Mapper.selectAllAttendanceDateByNum", mem_num);
		return dateList;
	}

	@Override
	public int selectTodayCheck(int mem_num) throws SQLException {
		int cnt = session.selectOne("Calendar-Mapper.selectTodayCheck", mem_num);
		return cnt;
	}

}
