package com.funding.request;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.funding.dto.MemberVO;

public class MemberModifyRequest {
	private String mem_pw; 				//회원 비밀번호
	private String mem_name; 			//회원 이름
	private String mem_phone;			//회원 전화번호
	private MultipartFile mem_profile_img;	//회원 프로필 경로
	private MultipartFile mem_profile_ori; 	//회원 프로필 원본
	private String mem_email;			//회원 이메일 아이디
	
	public MemberModifyRequest() {}
	public MemberModifyRequest(String mem_pw, String mem_name, String mem_phone, MultipartFile mem_profile_img,
			MultipartFile mem_profile_ori, String mem_email) {
		super();
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_profile_img = mem_profile_img;
		this.mem_profile_ori = mem_profile_ori;
		this.mem_email = mem_email;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public MultipartFile getMem_profile_img() {
		return mem_profile_img;
	}
	public void setMem_profile_img(MultipartFile mem_profile_img) {
		this.mem_profile_img = mem_profile_img;
	}
	public MultipartFile getMem_profile_ori() {
		return mem_profile_ori;
	}
	public void setMem_profile_ori(MultipartFile mem_profile_ori) {
		this.mem_profile_ori = mem_profile_ori;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	@Override
	public String toString() {
		return "MemberModifyRequest [mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_phone=" + mem_phone
				+ ", mem_profile_img=" + mem_profile_img + ", mem_profile_ori=" + mem_profile_ori + ", mem_email="
				+ mem_email + "]";
	}
	
	public MemberVO toMemberVO() {
		MemberVO member = new MemberVO();
		member.setMem_pw(mem_pw);
		member.setMem_name(mem_name);
		member.setMem_phone(mem_phone);
//		member.setMem_profile_img(mem_profile_img);
		member.setMem_email(mem_email);
		return member;
	}
	
	
}
