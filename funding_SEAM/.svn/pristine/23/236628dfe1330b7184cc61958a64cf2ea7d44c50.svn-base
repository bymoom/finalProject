package com.funding.service.project;

import java.sql.SQLException;
import java.util.Map;

import com.funding.dto.Project_cmtsVO;

public interface Project_cmtsService {
	
	public void registReply(Project_cmtsVO project_cmts)throws SQLException;
	public void modifyReply(Project_cmtsVO project_cmts)throws SQLException;
	public void removeReply(int pjt_cmts_num)throws SQLException;
	
	public Map<String,Object> replyList(int pjt_num)throws SQLException;
	
	public void enabledCancle(int pjt_num)throws SQLException;
	public void enabled(int pjt_cmts_num)throws SQLException;
}
