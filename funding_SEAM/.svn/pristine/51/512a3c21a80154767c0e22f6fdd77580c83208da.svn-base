package com.funding.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.SearchCriteria;

public interface MemberDAO {

	//회원정보 조회
	MemberVO selectMemberById(String id) throws SQLException;

	MemberVO selectMemberByNum(int mem_num) throws SQLException;

	ComMemberVO selectComMemberByNum(int mem_num) throws SQLException;
	
	int selectMemNumById(String id) throws SQLException;
	
	MemberVO selectMemberByName(String mem_name)throws SQLException;

	MemberVO selectMemberByNameAndPhone(String mem_name, String mem_pw) throws SQLException;
	
	Date selectLastDateById(String id) throws SQLException;
	
	String selectIdByIdPwUuid(String mem_email, String mem_pw, String uuid_key) throws SQLException;
	
	int selectLoginFailCount(String id) throws SQLException;
	
	//회원리스트
	List<MemberVO> selectMemberList() throws SQLException;
	
	List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException;
	
	//휴면회원 리스트
	List<MemberVO> selectDormantMemberList() throws SQLException;
	
	String selectDormantMember(String mem_email) throws SQLException;

	//전체 회원리스트 개수	
	int selectMemberListCount()throws SQLException;

	// 검색 결과의 전체 리스트 개수
	int selectMemberListCount(SearchCriteria cri) throws SQLException;
	
	// seq_mem_num.nextval 조회
	int selectSeqMemNumNextval() throws SQLException;
	
	//일반회원 추가
	void insertMember(MemberVO member) throws SQLException;
	
	//소상공인회원 추가
	void insertComMember(MemberVO member) throws SQLException;		
	
	//회원정보 수정
	void updateMember(MemberVO member) throws SQLException;
	
	//회원정보 삭제
	void deleteMember(String id) throws SQLException;	
	void deleteComMember(int mem_num) throws SQLException;
	
	//회원정지
	void disabledMember(String id) throws SQLException;
	
	//회원 활성화
	void enabledMember(String id) throws SQLException;
	
	//recentLoginTime 갱신
	void updateRecentLoginTime(String id) throws SQLException;
	
	void updatePlusLoginFailCount(String id) throws SQLException;
	
	void updateClearLoginFailCount(String id) throws SQLException;
	
	void updateLoginLastDate(String id) throws SQLException;
	
	//비밀번호 변경 
	void updateMemberPassword(String mem_pw, String mem_email) throws SQLException;
	
	//uuid key 입력
	void updateUuidKey(String uuid_key, String mem_email) throws SQLException;
	//uuid key 조회
	String selectUuidKeyById(String mem_email) throws SQLException;
	
}
