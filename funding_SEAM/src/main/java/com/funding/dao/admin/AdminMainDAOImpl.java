package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.funding.request.AdminMemberDetailRequest;

public class AdminMainDAOImpl implements AdminMainDAO {
	
	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int selectMemberTotalCount() throws SQLException {
		int memberTotalCount = sqlSession.selectOne("Admin-Mapper.selectMemberTotalCount");
		return memberTotalCount;
	}

	@Override
	public int selectTotalPayAmountThisWeek() throws SQLException {
		int totalPayAmountThisWeek = sqlSession.selectOne("Admin-Mapper.selectTotalPayAmountThisWeek");
		return totalPayAmountThisWeek;
	}
	
	@Override
	public List<Integer> selectJoinMemDataList() throws SQLException {
		List<Integer> joinMemDataList = sqlSession.selectList("Admin-Mapper.selectJoinMemDataList");
		return joinMemDataList;
	}

	@Override
	public List<Integer> selectJoinComMemDataList() throws SQLException {
		List<Integer> joinComMemDataList = sqlSession.selectList("Admin-Mapper.selectJoinComMemDataList");
		return joinComMemDataList;
	}

	@Override
	public List<Integer> selectDonationPaySumList() throws SQLException {
		List<Integer> donationPaySumList = sqlSession.selectList("Admin-Mapper.selectDonationPaySumList");
		return donationPaySumList;
	}

	@Override
	public List<Integer> selectRepaymentSumList() throws SQLException {
		List<Integer> repaymentSumList = sqlSession.selectList("Admin-Mapper.selectRepaymentSumList");
		return repaymentSumList;
	}

}
