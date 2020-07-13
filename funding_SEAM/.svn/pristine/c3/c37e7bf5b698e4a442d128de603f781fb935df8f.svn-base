package com.funding.service.myinfo;

import java.sql.SQLException;

import com.funding.dao.MemberDAO;
import com.funding.dao.myinfo.MyinfoDAO;
import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.ComMemberDetailRequest;
import com.funding.request.ComMemberModifyRequest;
import com.funding.request.MemberModifyRequest;

public class MyinfoServiceImpl implements MyinfoService {

//	//MemberDAO
//	private MemberDAO memberDAO;
//	public void setMemberDAO(MemberDAO memberDAO) {
//		this.memberDAO = memberDAO;
//	}
	
	//MyinfoDAO
	private MyinfoDAO myinfoDAO;
	public void setMyinfoDAO(MyinfoDAO myinfoDAO) {
		this.myinfoDAO = myinfoDAO;
	}
	
	@Override
	public MemberVO getMember(String id) throws SQLException {
		MemberVO member = myinfoDAO.selectMemberById(id);
		return member;
	}

	@Override
	public MemberVO getMemberByNum(int mem_num) throws SQLException {
		MemberVO member = myinfoDAO.selectMemberByNum(mem_num);
		return member;
	}

	@Override
	public ComMemberVO getComMember(String id) throws SQLException {
		int mem_num = myinfoDAO.selectMemNumById(id);
		ComMemberVO comMember = myinfoDAO.selectComMemberByNum(mem_num);
		return comMember;
	}
	
	@Override
	public void updateMember(MemberVO member) throws SQLException {
		
	}

	@Override
	public void updateMemberPassword(String mem_pw, String mem_email) throws SQLException {
		
	}

	@Override
	public void modify(MemberVO member) throws SQLException {
		myinfoDAO.modifyMember(member);
	}

	@Override
	public void modifyCom(MemberVO member) throws SQLException {
		myinfoDAO.modifyComMember(member);
	}
	
	@Override
	public void modifyNewCom(ComMemberDetailRequest comMember) throws SQLException {
		myinfoDAO.modifyNewComMember(comMember);
	}

	@Override
	public int getMemNum(String id) throws SQLException {
		return myinfoDAO.selectMemNumById(id);
	}

	@Override
	public ComMemberDetailRequest getComMemberByMemNum(String mem_email) throws SQLException {
		int mem_num = myinfoDAO.selectMemNumById(mem_email);
		
		ComMemberDetailRequest comMember = myinfoDAO.selectComMemberByMemNum(mem_num);
		return comMember;
	}





}
