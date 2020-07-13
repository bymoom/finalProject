package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.Pjt_pay_detailVO;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminProjectPaySearchCriteria;

public interface AdminProjectPayManageDAO {

	//결제 내역 리스트 조회 + 검색
	List<AdminMemberDetailRequest> selectProjectPayList(AdminProjectPaySearchCriteria cri) throws SQLException;
	
	//결제 내역 리스트 총 개수
	int selectProjectPayListTotalCount(AdminProjectPaySearchCriteria cri) throws SQLException;
	
	//다운로드 용 결제 내역 리스트 조회 + 검색
	List<AdminMemberDetailRequest> selectProjectPayListForDownload(AdminProjectPaySearchCriteria cri) throws SQLException;
	
	//환불 대기자 리스트
	List<Pjt_pay_detailVO> selectStandByToRefundList() throws SQLException;
	
	//결제 내역 상세 조회
	AdminMemberDetailRequest selectProjectPayDetail(int pjt_pay_num) throws SQLException;
	
	//결제 내역 조회
	Pjt_pay_detailVO selectPjtPayDetailByPjtPayNum(int pjt_pay_num) throws SQLException;
	
	//환불 완료 처리
	void updateRefund(int pjt_pay_num) throws SQLException;
	
}
