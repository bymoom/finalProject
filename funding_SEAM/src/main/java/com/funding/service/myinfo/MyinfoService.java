package com.funding.service.myinfo;

import java.sql.SQLException;

import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.ComMemberDetailRequest;
import com.funding.request.ComMemberModifyRequest;
import com.funding.request.MemberModifyRequest;

public interface MyinfoService {

	//회원정보조회
	MemberVO getMember(String id)throws SQLException;
	ComMemberVO getComMember(String id) throws SQLException;
	MemberVO getMemberByNum(int mem_num) throws SQLException;
	
	int getMemNum(String id) throws SQLException;
	
	//회원정보 수정
	void updateMember(MemberVO member) throws SQLException;

	//비밀번호 변경 
	void updateMemberPassword(String mem_pw, String mem_email) throws SQLException;
	
	//일반회원 수정
	void modify(MemberVO member) throws SQLException;
	
	//소상공인 회원수정
	void modifyCom(MemberVO member) throws SQLException;
	
	void modifyNewCom(ComMemberDetailRequest comMember) throws SQLException;

	ComMemberDetailRequest getComMemberByMemNum(String mem_email) throws SQLException;
	
	
	
}
