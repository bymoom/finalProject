package com.funding.service.project;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.funding.dto.Pjt_bank_sum_attachVO;
import com.funding.dto.ProjectVO;
import com.funding.request.MainSearchCriteria;
import com.funding.request.PjtSearchCriteria;
import com.funding.request.SearchCriteria;

public interface ProjectService {

	public Map<String, Object> getDonationProjectList(PjtSearchCriteria pjtCri)throws SQLException;
	public Map<String, Object> getLoanProjectList(PjtSearchCriteria pjtCri)throws SQLException;
	
	public ProjectVO getProject(int pjt_num)throws SQLException;
	
	public List<ProjectVO> getSearchProjectList(String val)throws SQLException;
	
	public int selectProjectCount(String val)throws SQLException;
	
	public void donationProjectRegist(ProjectVO project,Pjt_bank_sum_attachVO pjt_bank_sum_attach)throws SQLException;
	public void loanProjectRegist(ProjectVO project,Pjt_bank_sum_attachVO pjt_bank_sum_attach)throws SQLException;

	public Map<String, Object> getRegistProjectList(SearchCriteria cri,int mem_num)throws SQLException;
	
	public void modifyProject(ProjectVO project,Pjt_bank_sum_attachVO pjt_bank_sum_attach)throws SQLException;

	public Map<String, Object> getProgressProjectList(PjtSearchCriteria pjtCri,int mem_num)throws SQLException;
	
	public Map<String, Object> getMainProjectList(MainSearchCriteria mainCri)throws SQLException;
	
	public Map<String, Object> getInterestProjectList(PjtSearchCriteria pjtCri,int mem_num)throws SQLException;
	
	public Map<String, Object> getPjtPayList(MainSearchCriteria mainCri,int mem_num)throws SQLException;

}
