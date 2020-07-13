package com.funding.dto;

import java.util.Date;

public class Interest_pjtVO {
	
	private int int_pjt_num;		//관심 프로젝트 번호
	private Date int_pjt_adddate;	//관심 프로젝트 추가 일자
	private int pjt_num;			//프로젝트 번호
	private int mem_num;			//회원 번호
	
	public int getInt_pjt_num() {
		return int_pjt_num;
	}
	public void setInt_pjt_num(int int_pjt_num) {
		this.int_pjt_num = int_pjt_num;
	}
	public Date getInt_pjt_adddate() {
		return int_pjt_adddate;
	}
	public void setInt_pjt_adddate(Date int_pjt_adddate) {
		this.int_pjt_adddate = int_pjt_adddate;
	}
	public int getPjt_num() {
		return pjt_num;
	}
	public void setPjt_num(int pjt_num) {
		this.pjt_num = pjt_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	
	public Interest_pjtVO() {}
	@Override
	public String toString() {
		return "Interest_pjtVO [int_pjt_num=" + int_pjt_num + ", int_pjt_adddate=" + int_pjt_adddate + ", pjt_num="
				+ pjt_num + ", mem_num=" + mem_num + "]";
	}
	public Interest_pjtVO(int int_pjt_num, Date int_pjt_adddate, int pjt_num, int mem_num) {
		super();
		this.int_pjt_num = int_pjt_num;
		this.int_pjt_adddate = int_pjt_adddate;
		this.pjt_num = pjt_num;
		this.mem_num = mem_num;
	}

}
