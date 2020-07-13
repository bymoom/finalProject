package com.funding.service.project;

import java.sql.SQLException;

import com.funding.dto.Pjt_bank_sum_attachVO;

public interface Pjt_bank_sum_attachService {
	
	public String getSumnail(int pjt_num)throws SQLException;
	
	public Pjt_bank_sum_attachVO getPjtBankSumAttach(int pjt_num)throws SQLException;

}
