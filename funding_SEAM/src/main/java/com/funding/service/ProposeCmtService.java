package com.funding.service;

import java.sql.SQLException;
import java.util.List;

import com.funding.dto.ProjectProposeCmtVO;

public interface ProposeCmtService {
	 List<ProjectProposeCmtVO> selectReplyList(int pjtprp_num)throws SQLException;
	 
	 void regist(ProjectProposeCmtVO proposeCmt) throws SQLException;
	 
	 void disabledProposeCmt(int pjtprp_cmts_num)throws SQLException;
	 
	 void enabledProposeCmt(int pjtprp_cmts_num)throws SQLException;
	 
	 void modifyCmt(ProjectProposeCmtVO cmtVO)throws SQLException;
	 
	 void deleteCmt(int pjtprp_cmts_num)throws SQLException;
}
