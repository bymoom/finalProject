package com.funding.dao.myinfo;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.ComMemberDetailRequest;
import com.funding.request.ComMemberModifyRequest;
import com.funding.request.MemberModifyRequest;

public class MyinfoDAOImpl implements MyinfoDAO {
	
	private SqlSession session;	
	public void setSqlSession(SqlSession session) {
		this.session = session;
	}

	@Override
	public MemberVO selectMemberById(String id) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberById", id);
		return member;
	}
	
	@Override
	public MemberVO selectMemberByNum(int mem_num) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberByNum", mem_num);
		return member;
	}
	
	@Override
	public ComMemberVO selectComMemberByNum(int mem_num) throws SQLException {
		ComMemberVO comMember = session.selectOne("Member-Mapper.selectComMemberByNum", mem_num);
		return comMember;
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
	}

	@Override
	public void updateMemberPassword(String mem_pw, String mem_email) throws SQLException {
	}

	@Override
	public void modifyMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateMember", member);
	}

	@Override
	public void modifyComMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.updateComMember", member);
	}
	
	@Override
	public void modifyNewComMember(ComMemberDetailRequest comMember) throws SQLException {
		session.update("Member-Mapper.updateNewComMember", comMember);
	}

	@Override
	public int selectMemNumById(String id) throws SQLException {
		int ret = session.selectOne("Member-Mapper.selectMemNumById", id);
		return ret;
	}

	@Override
	public ComMemberDetailRequest selectComMemberByMemNum(int mem_num) throws SQLException {
		ComMemberDetailRequest comMember = session.selectOne("Member-Mapper.selectComMemberByMemNum", mem_num);
		return comMember;
	}






}
