package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.admin.AdminMainDAO;
import com.funding.request.AdminMemberDetailRequest;

public class AdminMainServiceImpl implements AdminMainService{

	@Autowired
	private AdminMainDAO adminMainDAO;
	public void setAdminMainDAO(AdminMainDAO adminMainDAO) {
		this.adminMainDAO = adminMainDAO; 
	}
	@Override
	public Map<String, Object> getMainData() throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//전체 회원 수
		int memberTotalCount = adminMainDAO.selectMemberTotalCount();
		dataMap.put("memberTotalCount", memberTotalCount);
		
		//이번주 총 결제금액
		int totalPayAmountThisWeek = adminMainDAO.selectTotalPayAmountThisWeek();
		dataMap.put("totalPayAmountThisWeek", totalPayAmountThisWeek);
		
		//회원 가입 데이터
		List<Integer> joinMemDataList = adminMainDAO.selectJoinMemDataList();
		List<Integer> joinComMemDataList = adminMainDAO.selectJoinComMemDataList();
		dataMap.put("joinMemDataList", joinMemDataList);
		dataMap.put("joinComMemDataList", joinComMemDataList);

		//결제 내역 데이터
		List<Integer> donationPaySumList = adminMainDAO.selectDonationPaySumList();
		List<Integer> repaymentSumList = adminMainDAO.selectRepaymentSumList();
		dataMap.put("donationPaySumList", donationPaySumList);
		dataMap.put("repaymentSumList", repaymentSumList);
		
		return dataMap;
	}
	

}
