package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import com.funding.request.AdminMemberDetailRequest;

public interface AdminMainDAO {

	//전체 회원 수
	int selectMemberTotalCount() throws SQLException;
	
	//이번 주 총 결제 금액
	int selectTotalPayAmountThisWeek() throws SQLException;
	
	//일반 회원 가입 수
	List<Integer> selectJoinMemDataList() throws SQLException;
	
	//소상공인 회원 가입 수
	List<Integer> selectJoinComMemDataList() throws SQLException;

	//기부 결제 금액
	List<Integer> selectDonationPaySumList() throws SQLException;

	//대출 결제 금액
	List<Integer> selectRepaymentSumList() throws SQLException;
	
}
