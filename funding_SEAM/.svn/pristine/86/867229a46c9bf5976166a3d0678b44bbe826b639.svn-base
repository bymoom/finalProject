package com.funding.request;

import org.springframework.web.multipart.MultipartFile;

import com.funding.dto.BannerVO;

public class BannerRegistRequest {
	private String b_name;
	private String b_url;
	private String b_type;
	private MultipartFile b_uploadFile;
	public String getB_name() {
		return b_name;
	}
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}
	public String getB_url() {
		return b_url;
	}
	public void setB_url(String b_url) {
		this.b_url = b_url;
	}
	public String getB_type() {
		return b_type;
	}
	public void setB_type(String b_type) {
		this.b_type = b_type;
	}
	
	
	public MultipartFile getB_uploadFile() {
		return b_uploadFile;
	}
	public void setB_uploadFile(MultipartFile b_uploadFile) {
		this.b_uploadFile = b_uploadFile;
	}
	public BannerVO toBannerVO() {
		BannerVO banner = new BannerVO();
		banner.setB_name(b_name);
		banner.setB_type(b_type);
		banner.setB_url(b_url);
		
		return banner;
	}
}
