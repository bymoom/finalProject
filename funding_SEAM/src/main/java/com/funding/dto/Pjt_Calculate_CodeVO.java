package com.funding.dto;

public class Pjt_Calculate_CodeVO {

	private int pjt_calculate_code; //프로젝트 정산 상태코드
	private String pjt_calculate_code_val; //프로젝트 정산 상태코드 값
	
	public Pjt_Calculate_CodeVO() {}

	public Pjt_Calculate_CodeVO(int pjt_calculate_code, String pjt_calculate_code_val) {
		super();
		this.pjt_calculate_code = pjt_calculate_code;
		this.pjt_calculate_code_val = pjt_calculate_code_val;
	}

	public int getPjt_calculate_code() {
		return pjt_calculate_code;
	}

	public void setPjt_calculate_code(int pjt_calculate_code) {
		this.pjt_calculate_code = pjt_calculate_code;
	}

	public String getPjt_calculate_code_val() {
		return pjt_calculate_code_val;
	}

	public void setPjt_calculate_code_val(String pjt_calculate_code_val) {
		this.pjt_calculate_code_val = pjt_calculate_code_val;
	}

	@Override
	public String toString() {
		return "Pjt_Calculate_CodeVO [pjt_calculate_code=" + pjt_calculate_code + ", pjt_calculate_code_val="
				+ pjt_calculate_code_val + "]";
	}
	
}
