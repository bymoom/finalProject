package com.funding.service.project;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.funding.dao.project.Pjt_bank_sum_attachDAO;
import com.funding.dto.Pjt_bank_sum_attachVO;

public class Pjt_bank_sum_attachServiceImpl implements Pjt_bank_sum_attachService {
	
	@Autowired
	private Pjt_bank_sum_attachDAO pjt_bank_sum_attachDAO;
	public void setPjt_bank_sum_attachDAO(Pjt_bank_sum_attachDAO pjt_bank_sum_attachDAO) {
		this.pjt_bank_sum_attachDAO = pjt_bank_sum_attachDAO;
	}

	@Override
	public String getSumnail(int pjt_num) throws SQLException {
		String sumNail=pjt_bank_sum_attachDAO.selectSumNameByPjtNum(pjt_num);
		return sumNail;
	}

	@Override
	public Pjt_bank_sum_attachVO getPjtBankSumAttach(int pjt_num) throws SQLException {
		Pjt_bank_sum_attachVO pjtBankSumAttach = pjt_bank_sum_attachDAO.selectPjtBankSumAttachByPjtNum(pjt_num);
		return pjtBankSumAttach;
	}

}
