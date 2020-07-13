package com.funding.service.admin;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.Mem_state_codeVO;
import com.funding.dto.MemberVO;
import com.funding.dto.Pjt_pay_detailVO;
import com.funding.dto.ProjectVO;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminMemberSearchCriteria;
import com.funding.request.SearchCriteria;

public interface AdminMemberManageService {
	
	//회원 상태 string 값 조회
	List<Mem_state_codeVO> getMemStateCode() throws SQLException;
	
	//일반 회원 목록
	List<MemberVO> selectSearchMemberListForDownload(AdminMemberSearchCriteria cri) throws SQLException;
	
	//일반 회원 목록 조회 + 검색
	Map<String, Object> getMemberList(AdminMemberSearchCriteria cri) throws SQLException;

	//상태별 일반 회원 목록
	Map<String, Object> getMemberStateList(SearchCriteria cri) throws SQLException;	
	
	//일반 회원 상세 정보 조회
	MemberVO getMemberByMemNum(int mem_num) throws SQLException;
	
	//일반 회원 상세 정보 조회 (+결제 내역, 프로젝트, 프로젝트 타입, 프로젝트 통장-섬네일 첨부 파일)
	List<AdminMemberDetailRequest> getMemberDetailForProjectPay(AdminDetailPageMaker pageMaker, int mem_num) throws SQLException;
	
	//일반 회원 결제 내역 상세 정보 총 개수
	int selectMemberDetailForProjectPayTotalCount(int mem_num) throws SQLException;
		
	//일반 회원 결제 내역 조회
	List<Pjt_pay_detailVO> getProjectPayDetailByMemNum(int mem_num) throws SQLException;
	
	//프로젝트 조회 (+프로젝트 타입 string 데이터)
	ProjectVO getProjectByPjtNum(int pjt_num) throws SQLException;
	
	//회원 상태 코드 수정
	void modifyMemStateCode(MemberVO member) throws SQLException;
	
}
