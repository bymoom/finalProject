package com.funding.dao.project;

import java.sql.SQLException;

import com.funding.dto.Pjt_bank_sum_attachVO;

public interface Pjt_bank_sum_attachDAO {
	
	public void insertPjtBankSumAttach(Pjt_bank_sum_attachVO pjt_bank_sum_attach)throws SQLException;
	
	public String selectSumNameByPjtNum(int pjt_num)throws SQLException;
	
	public Pjt_bank_sum_attachVO selectPjtBankSumAttachByPjtNum(int pjt_num)throws SQLException;
	
	public void updatePjtBankSumAttach(Pjt_bank_sum_attachVO pjt_bank_sum_attach)throws SQLException;

}
