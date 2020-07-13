package com.funding.dto;

import java.util.Date;

public class FaqVO {
	private int faq_num;
	private String faq_title;
	private String faq_contents;
	private Date faq_regdate;
	private Date faq_moddate;
	private int faq_view_cnt;
	private int mem_num;
	private String mem_name;
	
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_contents() {
		return faq_contents;
	}
	public void setFaq_contents(String faq_contents) {
		this.faq_contents = faq_contents;
	}
	public Date getFaq_regdate() {
		return faq_regdate;
	}
	public void setFaq_regdate(Date faq_regdate) {
		this.faq_regdate = faq_regdate;
	}
	public Date getFaq_moddate() {
		return faq_moddate;
	}
	public void setFaq_moddate(Date faq_moddate) {
		this.faq_moddate = faq_moddate;
	}
	public int getFaq_view_cnt() {
		return faq_view_cnt;
	}
	public void setFaq_view_cnt(int faq_view_cnt) {
		this.faq_view_cnt = faq_view_cnt;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	
	
}
