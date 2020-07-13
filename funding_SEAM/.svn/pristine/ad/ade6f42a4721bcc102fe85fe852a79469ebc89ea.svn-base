package com.funding.request;

import com.funding.dto.Project_ProposeVO;

public class ProposeRegistRequest {
	private int pjtprp_num;	//제안게시판 번호
	private String mem_name;//제안게시판 등록회원
	private String pjtprp_title; //제안게시판 제목  
	private String pjtprp_contents; //제안게시판 내용
	private String pjtprp_cash;//제안게시판 금액
	
	
	
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public int getPjtprp_num() {
		return pjtprp_num;
	}
	public void setPjtprp_num(int pjtprp_num) {
		this.pjtprp_num = pjtprp_num;
	}
	public String getPjtprp_title() {
		return pjtprp_title;
	}
	public void setPjtprp_title(String pjtprp_title) {
		this.pjtprp_title = pjtprp_title;
	}
	public String getPjtprp_contents() {
		return pjtprp_contents;
	}
	public void setPjtprp_contents(String pjtprp_contents) {
		this.pjtprp_contents = pjtprp_contents;
	}
	public String getPjtprp_cash() {
		return pjtprp_cash;
	}
	public void setPjtprp_cash(String pjtprp_cash) {
		this.pjtprp_cash = pjtprp_cash;
	}

	
	public Project_ProposeVO toProposeVO() {
		Project_ProposeVO propose = new Project_ProposeVO();
		propose.setPjtprp_num(this.pjtprp_num);		
		propose.setPjtprp_title(this.pjtprp_title);
		propose.setPjtprp_contents(this.pjtprp_contents);
		propose.setMem_name(this.mem_name);
		
		return propose;
	}
}
