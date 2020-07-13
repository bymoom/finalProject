package com.funding.service.project;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.project.Project_type_codeDAO;

public class Project_type_codeServiceImpl implements Project_type_codeService {
	
	@Autowired
	private Project_type_codeDAO project_type_codeDAO;
	public void setProject_type_codeDAO(Project_type_codeDAO project_type_codeDAO) {
		this.project_type_codeDAO = project_type_codeDAO;
	}

	@Override
	public String getPjtTypeVal(int pjt_type_code) throws SQLException {
		String typeVal=project_type_codeDAO.selectGetPjtTypeCodeVal(pjt_type_code);
		return typeVal;
	}

}
