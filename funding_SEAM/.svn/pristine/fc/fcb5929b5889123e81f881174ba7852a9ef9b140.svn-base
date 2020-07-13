package com.funding.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.funding.dao.ProposeCmtDAO;
import com.funding.dto.ProjectProposeCmtVO;

public class ProposeCmtServiceImpl implements ProposeCmtService{
	private ProposeCmtDAO proposeCmtDAO;
	
	public void setProposeCmtDAO(ProposeCmtDAO proposeCmtDAO) {
		this.proposeCmtDAO = proposeCmtDAO;
	}
	@Override
	public List<ProjectProposeCmtVO> selectReplyList(int pjtprp_num) throws SQLException {
		List<ProjectProposeCmtVO> cmtList = proposeCmtDAO.selectReplyList(pjtprp_num);
		return cmtList;
	}
	@Override
	public void regist(ProjectProposeCmtVO proposeCmt) throws SQLException {
		int seq = proposeCmtDAO.selectReplySeqNext();
		proposeCmt.setPjtprp_cmts_num(seq);
		proposeCmtDAO.insertReply(proposeCmt);
		
	}
	@Override
	public void disabledProposeCmt(int pjtprp_cmts_num) throws SQLException {
		proposeCmtDAO.disabledProposeCmt(pjtprp_cmts_num);
		
	}
	@Override
	public void enabledProposeCmt(int pjtprp_cmts_num) throws SQLException {
		proposeCmtDAO.enabledProposeCmt(pjtprp_cmts_num);
		
	}
	@Override
	public void modifyCmt(ProjectProposeCmtVO cmtVO) throws SQLException {
		proposeCmtDAO.modifyCmt(cmtVO);
		
	}
	@Override
	public void deleteCmt(int pjtprp_cmts_num) throws SQLException {
		proposeCmtDAO.deleteCmt(pjtprp_cmts_num);
	}

}
