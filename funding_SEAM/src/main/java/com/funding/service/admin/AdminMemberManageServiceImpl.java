package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.admin.AdminMemberManageDAO;
import com.funding.dto.Mem_state_codeVO;
import com.funding.dto.MemberVO;
import com.funding.dto.Pjt_pay_detailVO;
import com.funding.dto.ProjectVO;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminMemberPageMaker;
import com.funding.request.AdminMemberSearchCriteria;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class AdminMemberManageServiceImpl implements AdminMemberManageService {

	@Autowired
	private AdminMemberManageDAO adminMemberManageDAO;
	public void setAdminMemberManageDAO(AdminMemberManageDAO adminMemberManageDAO) {
		this.adminMemberManageDAO = adminMemberManageDAO;
	}
	
	@Override
	public List<Mem_state_codeVO> getMemStateCode() throws SQLException {
  		List<Mem_state_codeVO> memStateCodeList = adminMemberManageDAO.selectMemStateCode();
		return memStateCodeList;
	}

	@Override
	public List<MemberVO> selectSearchMemberListForDownload(AdminMemberSearchCriteria cri) throws SQLException {
		List<MemberVO> memberListForDownload = adminMemberManageDAO.selectSearchMemberListForDownload(cri);
		return memberListForDownload;
	}
	
	@Override
	public Map<String, Object> getMemberList(AdminMemberSearchCriteria cri) throws SQLException {
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<MemberVO> memberList = adminMemberManageDAO.selectSearchMemberList(cri);
		
		//전체 글 개수
		int totalCount = adminMemberManageDAO.selectSearchMemberListTotalCount(cri);

		//PageMaker 생성.
		AdminMemberPageMaker pageMaker = new AdminMemberPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	
	}
	
	@Override
	public Map<String, Object> getMemberStateList(SearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<MemberVO> memberList = adminMemberManageDAO.selectMemberStateList(cri);
		
		//상태별 일반 회원 총 개수
		int totalCount = adminMemberManageDAO.selectMemberStateListTotalCount(cri);
				
		//PageMaker 생성.
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);
		
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}

	@Override
	public MemberVO getMemberByMemNum(int mem_num) throws SQLException {
		MemberVO member = adminMemberManageDAO.selectMemberByMemNum(mem_num);
		return member;
	}

	@Override
	public List<AdminMemberDetailRequest> getMemberDetailForProjectPay(AdminDetailPageMaker pageMaker, int mem_num) throws SQLException {
		List<AdminMemberDetailRequest> memberDetailList = adminMemberManageDAO.selectMemberDetailForProjectPay(pageMaker, mem_num);
		return memberDetailList;
	}
	
	@Override
	public int selectMemberDetailForProjectPayTotalCount(int mem_num) throws SQLException {
		int count = adminMemberManageDAO.selectMemberDetailForProjectPayTotalCount(mem_num);
		return count;
	}

	@Override
	public List<Pjt_pay_detailVO> getProjectPayDetailByMemNum(int mem_num) throws SQLException {
		List<Pjt_pay_detailVO> pjtPayDetail = adminMemberManageDAO.selectProjectPayDetailByMemNum(mem_num);
		return pjtPayDetail;
	}

	@Override
	public ProjectVO getProjectByPjtNum(int pjt_num) throws SQLException {
		ProjectVO project = adminMemberManageDAO.selectProjectByPjtNum(pjt_num);
		return project;
	}

	@Override
	public void modifyMemStateCode(MemberVO member) throws SQLException {
		adminMemberManageDAO.modifyMemStateCode(member);
	}



}
