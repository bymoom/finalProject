package com.funding.service.admin;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.admin.AdminComMemberManageDAO;
import com.funding.dto.ComMemberVO;
import com.funding.dto.ComMember_State_CodeVO;
import com.funding.dto.MemberVO;
import com.funding.request.AdminComMemberDetailRequest;
import com.funding.request.AdminDetailForProjectPageMaker;
import com.funding.request.AdminMemberPageMaker;
import com.funding.request.AdminMemberSearchCriteria;

public class AdminComMemberManageServiceImpl implements AdminComMemberManageService {

	@Autowired
	private AdminComMemberManageDAO adminComMemberManageDAO;
	public void setAdminComMemberManageDAO(AdminComMemberManageDAO adminComMemberManageDAO) {
		this.adminComMemberManageDAO = adminComMemberManageDAO;
	}
	
	@Override
	public List<ComMember_State_CodeVO> getComStateCode() throws SQLException {
		List<ComMember_State_CodeVO> comStateCodeList = adminComMemberManageDAO.selectComStateCode();
		return comStateCodeList;
	}
	
	@Override
	public Map<String, Object> getSearchComMemberList(AdminMemberSearchCriteria cri) throws SQLException {
		Map<String, Object> dataMap = new HashMap<String, Object>();
		
		//현재 page 번호에 맞는 리스트를 perPageNum 개수 만큼 가져오기.
		List<AdminComMemberDetailRequest> comMemberList = adminComMemberManageDAO.selectSearchComMemberList(cri);
		
		//전체 글 개수
		int totalCount = adminComMemberManageDAO.selectSearchComMemberListTotalCount(cri);

		//소상공인 회원 가입 승인 코드
		List<ComMember_State_CodeVO> comStateList = adminComMemberManageDAO.selectComStateCode();
		
		//PageMaker 생성.
		AdminMemberPageMaker pageMaker = new AdminMemberPageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(totalCount);

		System.out.println(pageMaker.toString());
		
		dataMap.put("comMemberList", comMemberList);
		dataMap.put("comStateList", comStateList);
		dataMap.put("pageMaker", pageMaker);
		
		return dataMap;
	}
	
	@Override
	public List<AdminComMemberDetailRequest> selectSearchComMemberListForDownload(AdminMemberSearchCriteria cri)
			throws SQLException {
		List<AdminComMemberDetailRequest> comMemberListForDownload = adminComMemberManageDAO.selectSearchComMemberListForDownload(cri);
		return comMemberListForDownload;
	}

	@Override
	public int getRoleComHoldTotalCount() throws SQLException {
		int count = adminComMemberManageDAO.selectRoleComHoldTotalCount();
		return count;
	}

	@Override
	public AdminComMemberDetailRequest getComMemberByMemNum(int mem_num) throws SQLException {
		AdminComMemberDetailRequest comMember = adminComMemberManageDAO.selectComMemberByMemNum(mem_num);
		return comMember;
	}

	@Override
	public List<AdminComMemberDetailRequest> getMemberDetailForProject(AdminDetailForProjectPageMaker detailForProjectPageMaker, int mem_num) throws SQLException {
		List<AdminComMemberDetailRequest> comMemberProjectList = adminComMemberManageDAO.selectMemberDetailForProject(detailForProjectPageMaker, mem_num);
		return comMemberProjectList;
	}

	@Override
	public int selectMemberDetailForProjectTotalCount(int mem_num) throws Exception {
		int count = adminComMemberManageDAO.selectMemberDetailForProjectTotalCount(mem_num);
		return count;
	}

	@Override
	public void modifyComStateCode(ComMemberVO comMember) throws SQLException {
		adminComMemberManageDAO.modifyComStateCode(comMember);
	}

	@Override
	public void modifyMemStateCodeForComMem(MemberVO member) throws SQLException {
		adminComMemberManageDAO.modifyMemStateCodeForComMem(member);
	}
	
}
