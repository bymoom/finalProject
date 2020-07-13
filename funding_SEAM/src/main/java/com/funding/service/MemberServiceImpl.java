package com.funding.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.MemberDAO;
import com.funding.dao.member.ComMemberDAO;
import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.exception.InvalidPasswordException;
import com.funding.exception.NotFoundIDException;
import com.funding.request.MemberRegistRequest;
import com.funding.request.PageMaker;
import com.funding.request.SearchCriteria;

public class MemberServiceImpl implements MemberService {

	//MemberDAO
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	private ComMemberDAO commemberDAO;
	
	@Override
	public void login(String id, String pwd) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberById(id);
		if (member == null)
			throw new NotFoundIDException();
		if (!pwd.equals(member.getMem_pw()))
			throw new InvalidPasswordException();
	}

	@Override
	public List<MemberVO> getMemberList() throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public Map<String, Object> getMemberList(SearchCriteria cri) throws SQLException {
		List<MemberVO> memberList = memberDAO.selectMemberList(cri);

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(memberDAO.selectMemberListCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("memberList", memberList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}
	
	@Override
	public List<MemberVO> getDormantMemberList() throws SQLException {
		List<MemberVO> dormantList = memberDAO.selectDormantMemberList();
		return dormantList;
	}
	
	@Override
	public String getDormantMember(String mem_email) throws SQLException {
		String strRet = memberDAO.selectDormantMember(mem_email);
		return strRet;
	}

	@Override
	public void regist(MemberVO member) throws SQLException {
		memberDAO.insertMember(member);
	}

	@Override
	public void registComMember(MemberVO member) throws SQLException {
		int mem_num = memberDAO.selectSeqMemNumNextval();
		System.out.println("registComMember >>>" + mem_num);
		member.setMem_num(mem_num);
		
		memberDAO.insertMember(member);
		memberDAO.insertComMember(member);
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
	}

	@Override
	public void modifyComMember(MemberVO member) throws SQLException {
	}

	@Override
	public void remove(String id) throws SQLException {
		memberDAO.deleteMember(id);
	}
	
	@Override
	public void removeComMember(int mem_num) throws SQLException {
		memberDAO.deleteComMember(mem_num);
	}

	@Override
	public void disabled(String id) throws SQLException {
		memberDAO.disabledMember(id);
	}

	@Override
	public void enabled(String id) throws SQLException {
		memberDAO.enabledMember(id);
	}

	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = memberDAO.selectMemberById(id);
		return member;
	}

	@Override
	public MemberVO getMember(int mem_num) throws SQLException {
		MemberVO member = memberDAO.selectMemberByNum(mem_num);
		return member;
	}
	
	@Override
	public ComMemberVO getComMember(int mem_num) throws SQLException {
		ComMemberVO comMember = memberDAO.selectComMemberByNum(mem_num);
		return comMember;
	}


	@Override
	public MemberVO getMemberByName(String mem_name) throws SQLException {
		MemberVO member = memberDAO.selectMemberByName(mem_name);
		return member;
	}
	
	@Override
	public String getMemberByIdPwUuid(String mem_email, String mem_pw, String uuid_key) throws SQLException {
		String id = memberDAO.selectIdByIdPwUuid(mem_email, mem_pw, uuid_key);
		return id;
	}

	@Override
	public MemberVO findId(String mem_name, String mem_phone) throws SQLException, NotFoundIDException, InvalidPasswordException {
		MemberVO member = memberDAO.selectMemberByNameAndPhone(mem_name, mem_phone);
		if (member == null)
			throw new NotFoundIDException();
		return member;
	}

	@Override
	public Date getMemberLoginLastDate(String id) throws SQLException {
		Date date = memberDAO.selectLastDateById(id);
		return date;
	}

	@Override
	public void updatePlusLoginFailCount(String id) throws SQLException {
		memberDAO.updatePlusLoginFailCount(id);
	}

	@Override
	public void updateClearLoginFailCount(String id) throws SQLException {
		memberDAO.updateClearLoginFailCount(id);
	}

	@Override
	public void updateLoginLastDate(String id) throws SQLException {
		memberDAO.updateLoginLastDate(id);
	}

	@Override
	public int getLoginFailCount(String id) throws SQLException {
		int loginFailCnt = memberDAO.selectLoginFailCount(id);
		return loginFailCnt;
	}

	@Override
	public void updateMemberPassword(String mem_pw, String mem_email) throws SQLException {
		memberDAO.updateMemberPassword(mem_pw, mem_email);
	}

	@Override
	public int getSeqMemNumNextval() throws SQLException {
		int nextval = memberDAO.selectSeqMemNumNextval();
		return nextval;
	}

	@Override
	public int getMemNum(String id) throws SQLException {
		int ret = memberDAO.selectMemNumById(id);
		return ret;
	}

	@Override
	public void updateUuidKey(String uuid_key, String mem_email) throws SQLException {
		memberDAO.updateUuidKey(uuid_key, mem_email);
	}

	@Override
	public String getUuidKeyById(String mem_email) throws SQLException {
		String strUuid = memberDAO.selectUuidKeyById(mem_email);
		return strUuid;
	}









}
