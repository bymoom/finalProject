package com.funding.service.project;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.MemberDAO;
import com.funding.dao.project.Project_cmtsDAO;
import com.funding.dto.ProjectVO;
import com.funding.dto.Project_cmtsVO;

public class Project_cmtsServiceImpl implements Project_cmtsService {
	
	@Autowired
	private Project_cmtsDAO project_cmtsDAO;
	public void setProject_cmtsDAO(Project_cmtsDAO project_cmtsDAO) {
		this.project_cmtsDAO = project_cmtsDAO;
	}
	
	@Autowired
	private MemberDAO memberDAO;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public void registReply(Project_cmtsVO project_cmts) throws SQLException {
		project_cmtsDAO.insertReply(project_cmts);
	}

	@Override
	public void modifyReply(Project_cmtsVO project_cmts) throws SQLException {
		project_cmtsDAO.updateReply(project_cmts);
	}

	@Override
	public void removeReply(int pjt_cmts_num) throws SQLException {
		project_cmtsDAO.deleteReply(pjt_cmts_num);
	}

	@Override
	public Map<String, Object> replyList(int pjt_num) throws SQLException {
		Map<String,Object> dataMap = new HashMap<String,Object>();
		
		List<Project_cmtsVO> replyList = project_cmtsDAO.selectReplyList(pjt_num);
		
		for(Project_cmtsVO project_cmts : replyList) {
			String mem_name = memberDAO.selectMemberByNum(project_cmts.getMem_num()).getMem_name();
			project_cmts.setMem_name(mem_name);
		}
		
		
		dataMap.put("replyList", replyList);
		return dataMap;
	}

	@Override
	public void enabledCancle(int pjt_cmts_num)throws SQLException {
		project_cmtsDAO.updateBlind(pjt_cmts_num);
	}

	@Override
	public void enabled(int pjt_num) throws SQLException {
		project_cmtsDAO.updateAllBlindCancle(pjt_num);
	}

}
