package com.funding.dto;

import java.util.Date;

public class Notice_atcVO {
	
	private int ntc_atc_num;
	private String ntc_atc_uploadPath;
	private String ntc_atc_fileName;
	private String ntc_atc_fileType;
	private int ntc_atc_pno;
	private Date ntc_atc_regdate;
	private Date ntc_atc_moddate;
	private Date ntc_atc_deldate;
	private String ntc_atc_uuid;
	private int notice_num;

	public int getNtc_atc_num() {
		return ntc_atc_num;
	}
	public void setNtc_atc_num(int ntc_atc_num) {
		this.ntc_atc_num = ntc_atc_num;
	}
	public String getNtc_atc_uploadPath() {
		return ntc_atc_uploadPath;
	}
	public void setNtc_atc_uploadPath(String ntc_atc_uploadPath) {
		this.ntc_atc_uploadPath = ntc_atc_uploadPath;
	}
	public String getNtc_atc_fileName() {
		return ntc_atc_fileName;
	}
	public void setNtc_atc_fileName(String ntc_atc_fileName) {
		this.ntc_atc_fileName = ntc_atc_fileName;
	}
	public String getNtc_atc_fileType() {
		return ntc_atc_fileType;
	}
	public void setNtc_atc_fileType(String ntc_atc_fileType) {
		this.ntc_atc_fileType = ntc_atc_fileType;
	}
	public int getNtc_atc_pno() {
		return ntc_atc_pno;
	}
	public void setNtc_atc_pno(int ntc_atc_pno) {
		this.ntc_atc_pno = ntc_atc_pno;
	}
	public Date getNtc_atc_regdate() {
		return ntc_atc_regdate;
	}
	public void setNtc_atc_regdate(Date ntc_atc_regdate) {
		this.ntc_atc_regdate = ntc_atc_regdate;
	}
	public Date getNtc_atc_moddate() {
		return ntc_atc_moddate;
	}
	public void setNtc_atc_moddate(Date ntc_atc_moddate) {
		this.ntc_atc_moddate = ntc_atc_moddate;
	}
	public Date getNtc_atc_deldate() {
		return ntc_atc_deldate;
	}
	public void setNtc_atc_deldate(Date ntc_atc_deldate) {
		this.ntc_atc_deldate = ntc_atc_deldate;
	}
	public String getNtc_atc_uuid() {
		return ntc_atc_uuid;
	}
	public void setNtc_atc_uuid(String ntc_atc_uuid) {
		this.ntc_atc_uuid = ntc_atc_uuid;
	}
	public int getNotice_num() {
		return notice_num;
	}
	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}
	
	@Override
	public String toString() {
		return "Notice_atcVO [ntc_atc_num=" + ntc_atc_num + ", ntc_atc_uploadPath=" + ntc_atc_uploadPath
				+ ", ntc_atc_fileName=" + ntc_atc_fileName + ", ntc_atc_fileType=" + ntc_atc_fileType + ", ntc_atc_pno="
				+ ntc_atc_pno + ", ntc_atc_regdate=" + ntc_atc_regdate + ", ntc_atc_moddate=" + ntc_atc_moddate
				+ ", ntc_atc_deldate=" + ntc_atc_deldate + ", ntc_atc_uuid=" + ntc_atc_uuid + ", notice_num="
				+ notice_num + "]";
	}
	
	public Notice_atcVO() {
		
	}
	
	public Notice_atcVO(int ntc_atc_num, String ntc_atc_uploadPath, String ntc_atc_fileName, String ntc_atc_fileType,
			int ntc_atc_pno, Date ntc_atc_regdate, Date ntc_atc_moddate, Date ntc_atc_deldate, String ntc_atc_uuid,
			int notice_num) {
		super();
		this.ntc_atc_num = ntc_atc_num;
		this.ntc_atc_uploadPath = ntc_atc_uploadPath;
		this.ntc_atc_fileName = ntc_atc_fileName;
		this.ntc_atc_fileType = ntc_atc_fileType;
		this.ntc_atc_pno = ntc_atc_pno;
		this.ntc_atc_regdate = ntc_atc_regdate;
		this.ntc_atc_moddate = ntc_atc_moddate;
		this.ntc_atc_deldate = ntc_atc_deldate;
		this.ntc_atc_uuid = ntc_atc_uuid;
		this.notice_num = notice_num;
	}

	
}
