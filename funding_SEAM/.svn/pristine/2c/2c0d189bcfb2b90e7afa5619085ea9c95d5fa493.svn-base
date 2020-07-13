package com.funding.dao.myinfo;

import java.sql.SQLException;

import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.ComMemberDetailRequest;
import com.funding.request.ComMemberModifyRequest;
import com.funding.request.MemberModifyRequest;

public interface MyinfoDAO {

	MemberVO selectMemberById(String id) throws SQLException;
	
	MemberVO selectMemberByNum(int mem_num) throws SQLException;
	
	ComMemberVO selectComMemberByNum(int mem_num) throws SQLException;
	
	int selectMemNumById(String id) throws SQLException;
	
	//회원정보 수정
	void updateMember(MemberVO member) throws SQLException;

	//비밀번호 변경 
	void updateMemberPassword(String mem_pw, String mem_email) throws SQLException;

	//일반회원 정보수정
	void modifyMember(MemberVO member) throws SQLException;
	
	//소상공인회원 정보수정
	void modifyComMember(MemberVO member) throws SQLException;
	
	void modifyNewComMember(ComMemberDetailRequest comMember) throws SQLException;

	ComMemberDetailRequest selectComMemberByMemNum(int mem_num) throws SQLException;
}
