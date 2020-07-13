package com.funding.dao.admin;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.Mem_state_codeVO;
import com.funding.dto.MemberVO;
import com.funding.dto.Pjt_pay_detailVO;
import com.funding.dto.ProjectVO;
import com.funding.request.AdminDetailPageMaker;
import com.funding.request.AdminMemberDetailRequest;
import com.funding.request.AdminMemberSearchCriteria;
import com.funding.request.SearchCriteria;

public class AdminMemberManageDAOImpl implements AdminMemberManageDAO {

	private SqlSession sqlSession;
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public List<Mem_state_codeVO> selectMemStateCode() throws SQLException {
		List<Mem_state_codeVO> memStateCodeList = sqlSession.selectList("Admin-Mapper.selectMemStateCode");
		return memStateCodeList;
	}
	
	@Override
	public List<MemberVO> selectSearchMemberList(AdminMemberSearchCriteria cri) throws SQLException {
		int offset=cri.getPageStartRowNum();
		int limit=cri.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		List<MemberVO> memberList = sqlSession.selectList("Admin-Mapper.selectSearchMemberList", cri, rowBounds);
		return memberList;
	}
	
	@Override
	public List<MemberVO> selectSearchMemberListForDownload(AdminMemberSearchCriteria cri) throws SQLException {
		List<MemberVO> memberList = sqlSession.selectList("Admin-Mapper.selectSearchMemberList", cri);
		return memberList;
	}

	@Override
	public int selectSearchMemberListTotalCount(AdminMemberSearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectSearchMemberListTotalCount", cri);
		return count;
	}

	@Override
	public List<MemberVO> selectMemberStateList(SearchCriteria cri) throws SQLException {
		List<MemberVO> memberStateList = sqlSession.selectList("Admin-Mapper.selectMemberStateList", cri);
		return memberStateList;
	}

	@Override
	public int selectMemberStateListTotalCount(SearchCriteria cri) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectMemberStateListTotalCount", cri);
		return count;
	}

	@Override
	public List<MemberVO> selectSearchMemberListByRegDate(Date[] mem_regdate) throws SQLException {
		List<MemberVO> memberList = sqlSession.selectList("Admin-Mapper.selectSearchMemberListByRegDate", mem_regdate);
		return memberList;
	}

	@Override
	public MemberVO selectMemberByMemNum(int mem_num) throws SQLException {
		MemberVO member = sqlSession.selectOne("Admin-Mapper.selectMemberByMemNum", mem_num);
		return member;
	}

	@Override
	public List<AdminMemberDetailRequest> selectMemberDetailForProjectPay(AdminDetailPageMaker pageMaker, int mem_num) throws SQLException {
		int offset=pageMaker.getPageStartRowNum();
		int limit=pageMaker.getPerPageNum();
		RowBounds rowBounds= new RowBounds(offset,limit);
		
		List<AdminMemberDetailRequest> memberDetailList = sqlSession.selectList("Admin-Mapper.selectMemberDetailForProjectPay", mem_num, rowBounds);
		return memberDetailList;
	}
	
	@Override
	public int selectMemberDetailForProjectPayTotalCount(int mem_num) throws SQLException {
		int count = sqlSession.selectOne("Admin-Mapper.selectMemberDetailForProjectPayTotalCount", mem_num);
		return count;
	}
	
	@Override
	public List<Pjt_pay_detailVO> selectProjectPayDetailByMemNum(int mem_num) throws SQLException {
		List<Pjt_pay_detailVO> pjtPayDetail = sqlSession.selectList("Admin-Mapper.selectProjectPayDetailByMemNum", mem_num);
		return pjtPayDetail;
	}

	@Override
	public ProjectVO selectProjectByPjtNum(int pjt_num) throws SQLException {
		ProjectVO project = sqlSession.selectOne("Admin-Mapper.selectProjectByPjtNum", pjt_num);
		return project;
	}

	@Override
	public void modifyMemStateCode(MemberVO member) throws SQLException {
		sqlSession.update("Admin-Mapper.modifyMemStateCode", member);
	}


}
