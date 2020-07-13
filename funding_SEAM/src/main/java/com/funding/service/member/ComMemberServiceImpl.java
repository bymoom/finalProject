package com.funding.service.member;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.member.ComMemberDAO;
import com.funding.dto.ComMemberVO;

public class ComMemberServiceImpl implements ComMemberService {
	@Autowired
	private ComMemberDAO comMemberDAO;
	public void setComMemberDAO(ComMemberDAO comMemberDAO) {
		this.comMemberDAO = comMemberDAO;
	}

	@Override
	public ComMemberVO getComMember(int mem_num) throws SQLException {
		ComMemberVO comMember = comMemberDAO.selectComMemberByMemNum(mem_num);
		return comMember;
	}

}
