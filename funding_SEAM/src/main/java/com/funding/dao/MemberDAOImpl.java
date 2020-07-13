package com.funding.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.funding.dto.ComMemberVO;
import com.funding.dto.MemberVO;
import com.funding.request.MemberRegistRequest;
import com.funding.request.SearchCriteria;

public class MemberDAOImpl implements MemberDAO {
	
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
	public String selectIdByIdPwUuid(String mem_email, String mem_pw, String uuid_key) throws SQLException {
		MemberVO vo = new MemberVO();
		vo.setMem_email(mem_email);
		vo.setMem_pw(mem_pw);
		vo.setUuid_key(uuid_key);
		String id = session.selectOne("Member-Mapper.selectIdByIdPwUuid", vo);
		return id;
	}

	@Override
	public void insertMember(MemberVO member) throws SQLException {
		session.update("Member-Mapper.insertMember", member);
	}
	
	@Override
	public void insertComMember(MemberVO member) throws SQLException {
//		Map<String,Object> paramMap = new HashMap<String,Object>();
//		paramMap.put("member", member);
//		paramMap.put("nextval", nextval);
		session.update("Member-Mapper.insertComMember", member);
	}

	@Override
	public void updateMember(MemberVO member) throws SQLException {
		//작성중.. 확인필요
	}

	@Override
	public void deleteMember(String id) throws SQLException {
		session.update("Member-Mapper.deleteMember", id);
	}
	
	@Override
	public void deleteComMember(int mem_num) throws SQLException {
		session.update("Member-Mapper.deleteComMember", mem_num);
	}

	@Override
	public void disabledMember(String id) throws SQLException {
		session.update("Member-Mapper.disableMember",id);
	}

	@Override
	public void enabledMember(String id) throws SQLException {
		session.update("Member-Mapper.enableMember",id);
	}

	@Override
	public void updateRecentLoginTime(String id) throws SQLException {
		session.update("Member-Mapper.updateRecentLoginTime",id);
	}

	@Override
	public MemberVO selectMemberByName(String mem_name) throws SQLException {
		MemberVO member = session.selectOne("Member-Mapper.selectMemberByName",mem_name);
		
		return member;
	}

	@Override
	public MemberVO selectMemberByNameAndPhone(String mem_name, String mem_phone) throws SQLException {
//		MemberVO member = session.selectOne("Member-Mapper.findIdByEmailAndPhone")
		MemberVO vo = new MemberVO();
		vo.setMem_name(mem_name);
		vo.setMem_phone(mem_phone);
		MemberVO member = session.selectOne("Member-Mapper.findIdByEmailAndPhone", vo);
		return member;
	}

	@Override
	public List<MemberVO> selectMemberList() throws SQLException {
		List<MemberVO> memberList = session.selectList("Member-Mapper.selectMemberList", null);
		return memberList;
	}

	@Override
	public List<MemberVO> selectMemberList(SearchCriteria cri) throws SQLException {
		int offset = cri.getPageStartRowNum();
		int limit = cri.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		List<MemberVO> memberList = null;
		
		memberList = session.selectList("Member-Mapper.selectSearchMemberList", cri,rowBounds);

		return memberList;
	}
	
	//휴면계정 리스트 조회
	@Override
	public List<MemberVO> selectDormantMemberList() throws SQLException {
		List<MemberVO> dormantList = session.selectList("Member-Mapper.selectDormantMemberList", null);
		return dormantList;
	}

	//휴면계정 조회
	@Override
	public String selectDormantMember(String mem_email) throws SQLException {
		String strRet = session.selectOne("Member-Mapper.selectDormantMember", mem_email);
		return strRet;
	}

	@Override
	public int selectMemberListCount() throws SQLException {
		int count = session.selectOne("Member-Mapper.selectMemberListCount", null);
		return count;
	}

	@Override
	public int selectMemberListCount(SearchCriteria cri) throws SQLException {
		int count=0;		
		count = session.selectOne("Member-Mapper.selectSearchMemberListCount",cri);
		return count;
	}

	////
	@Override
	public Date selectLastDateById(String id) throws SQLException {
		Date date = null;
		date = session.selectOne("Member-Mapper.selectMemberLoginLastDate", id);
		return date;
	}
	
	@Override
	public int selectSeqMemNumNextval() throws SQLException {
		int nextval = session.selectOne("Member-Mapper.selectSeqMemNumNextVal");
		return nextval;
	}

	@Override
	public void updatePlusLoginFailCount(String id) throws SQLException {
		session.update("Member-Mapper.plusLoginFailCount", id);
	}

	@Override
	public void updateClearLoginFailCount(String id) throws SQLException {
		session.update("Member-Mapper.updateClearLoginFailCount", id);
	}

	@Override
	public void updateLoginLastDate(String id) throws SQLException {
		session.update("Member-Mapper.updateLoginLastDate", id);
	}

	@Override
	public int selectLoginFailCount(String id) throws SQLException {
		int loginFailCnt = session.selectOne("Member-Mapper.selectLoginFailCount", id);
		return loginFailCnt;
	}

	@Override
	public void updateMemberPassword(String mem_pw, String mem_email) throws SQLException {
		MemberVO vo = new MemberVO();
		vo.setMem_pw(mem_pw);
		vo.setMem_email(mem_email);
		session.update("Member-Mapper.updateMemberPassword", vo);
	}

	@Override
	public int selectMemNumById(String id) throws SQLException {
		int ret = session.selectOne("Member-Mapper.selectMemNumById", id);
		return ret;
	}

	@Override
	public void updateUuidKey(String uuid_key, String mem_email) throws SQLException {
		MemberVO vo = new MemberVO();
		vo.setMem_email(mem_email);
		vo.setUuid_key(uuid_key);

		session.update("Member-Mapper.updateUuidKey", vo);
	}

	@Override
	public String selectUuidKeyById(String mem_email) throws SQLException {
		String strUuid = session.selectOne("Member-Mapper.selectUuidKeyById", mem_email);
		return strUuid;
	}










}
