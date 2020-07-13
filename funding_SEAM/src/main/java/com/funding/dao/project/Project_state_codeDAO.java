package com.funding.dao.project;

import java.sql.SQLException;

public interface Project_state_codeDAO {
	
	public String selectGetPjtStateCodeVal(int pjt_state_code)throws SQLException;

}
