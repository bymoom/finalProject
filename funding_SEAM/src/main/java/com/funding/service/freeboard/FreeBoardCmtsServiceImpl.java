package com.funding.service.freeboard;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.freeboard.FreeBoardCmtsDAO;
import com.funding.dto.FreeBoardCmtsVO;

public class FreeBoardCmtsServiceImpl implements FreeBoardCmtsService {

	@Autowired
	private FreeBoardCmtsDAO freeBoardCmtsDAO;
	public void setFreeBoardCmtsDAO(FreeBoardCmtsDAO freeBoardCmtsDAO) {
		this.freeBoardCmtsDAO = freeBoardCmtsDAO;
	}
	
	@Override
	public List<FreeBoardCmtsVO> getFreeBoardCmtsList(int free_num) throws SQLException {
		List<FreeBoardCmtsVO> freeBoardCmtsList = freeBoardCmtsDAO.selectFreeBoardCmtsList(free_num);
		
		int count = freeBoardCmtsDAO.countFreeBoardCmts(free_num);
		
		for(FreeBoardCmtsVO freeBoardCmts : freeBoardCmtsList) {
			freeBoardCmts.setCmtsCount(count);
		}
		return freeBoardCmtsList;
	}
	
	@Override
	public FreeBoardCmtsVO selectFreeBoardCmts(int free_cmts_num) throws SQLException {
		FreeBoardCmtsVO freeBoardCmts = freeBoardCmtsDAO.selectFreeBoardCmts(free_cmts_num);
		return freeBoardCmts;
	}

	@Override
	public void regist(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		freeBoardCmtsDAO.registFreeBoardCmts(freeBoardCmts);
	}

	@Override
	public void modify(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		freeBoardCmtsDAO.modifyFreeBoardCmts(freeBoardCmts);
	}

	@Override
	public void modifyEnabled(FreeBoardCmtsVO freeBoardCmts) throws SQLException {
		freeBoardCmtsDAO.modifyFreeBoardCmtsEnabled(freeBoardCmts);
	}

	@Override
	public void remove(int free_cmts_num) throws SQLException {
		freeBoardCmtsDAO.removeFreeBoardCmts(free_cmts_num);
	}

	@Override
	public void modifyFreeCmtsLike(int free_cmts_num, String str) throws SQLException {
		if(str.equals("add")) {
			freeBoardCmtsDAO.increaseFreeCmtsLike(free_cmts_num);
		}else if(str.equals("sub")) {
			freeBoardCmtsDAO.decreaseFreeCmtsLike(free_cmts_num);
		}		
	}

}
