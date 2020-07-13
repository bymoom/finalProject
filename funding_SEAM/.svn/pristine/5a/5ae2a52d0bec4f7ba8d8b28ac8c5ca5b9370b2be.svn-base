package com.funding.service.project;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.project.Project_state_codeDAO;

public class Project_state_codeServiceImpl implements Project_state_codeService {
	@Autowired
	private Project_state_codeDAO project_state_codeDAO;
	public void setProject_state_codeDAO(Project_state_codeDAO project_state_codeDAO) {
		this.project_state_codeDAO = project_state_codeDAO;
	}

	@Override
	public String getPjtStateVal(int pjt_state_code) throws SQLException {
		String pjtStateVal = project_state_codeDAO.selectGetPjtStateCodeVal(pjt_state_code);
		return pjtStateVal;
	}

}
