package com.funding.request;

import org.springframework.web.multipart.MultipartFile;

import com.funding.dto.MemberVO;

/**
 * @author PC-07
 *
 */
public class ComMemberModifyRequest {
	private String mem_pw; 				//회원 비밀번호
	private String mem_name; 			//회원 이름
	private String mem_phone;			//회원 전화번호
	private MultipartFile mem_profile_img;	//회원 프로필 경로
	private MultipartFile mem_profile_ori; 	//회원 프로필 원본
	
	private String com_bsns_name;		//사업자명
	private String com_bsns_rep_name;	//대표자명
	private String com_bsns_number;		//사업자등록번호
	private String com_bsns_phone;		//대표전화번호
	private MultipartFile com_bsns_reg_license;//사업자등록증
	private MultipartFile com_bsns_cert;		//소상공인 증명서
	
	private String com_zipcode;			//우편번호
	private String com_addr1;			//주소1
	private String com_addr2;			//주소2

	private String mem_email;			//회원 이메일 아이디

	//type : text //기존 파일 스트링으로 들어온다
	private String old_mem_profile_img;
	private String old_com_bsns_reg_license;
	private String old_com_bsns_cert;
	
	public ComMemberModifyRequest() {}
	public ComMemberModifyRequest(String mem_pw, String mem_name, String mem_phone, MultipartFile mem_profile_img,
			MultipartFile mem_profile_ori, String com_bsns_name, String com_bsns_rep_name, String com_bsns_number,
			String com_bsns_phone, MultipartFile com_bsns_reg_license, MultipartFile com_bsns_cert, String com_zipcode,
			String com_addr1, String com_addr2, String mem_email, String old_mem_profile_img,
			String old_com_bsns_reg_license, String old_com_bsns_cert) {
		super();
		this.mem_pw = mem_pw;
		this.mem_name = mem_name;
		this.mem_phone = mem_phone;
		this.mem_profile_img = mem_profile_img;
		this.mem_profile_ori = mem_profile_ori;
		this.com_bsns_name = com_bsns_name;
		this.com_bsns_rep_name = com_bsns_rep_name;
		this.com_bsns_number = com_bsns_number;
		this.com_bsns_phone = com_bsns_phone;
		this.com_bsns_reg_license = com_bsns_reg_license;
		this.com_bsns_cert = com_bsns_cert;
		this.com_zipcode = com_zipcode;
		this.com_addr1 = com_addr1;
		this.com_addr2 = com_addr2;
		this.mem_email = mem_email;
		this.old_mem_profile_img = old_mem_profile_img;
		this.old_com_bsns_reg_license = old_com_bsns_reg_license;
		this.old_com_bsns_cert = old_com_bsns_cert;
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
	public String getCom_bsns_name() {
		return com_bsns_name;
	}
	public void setCom_bsns_name(String com_bsns_name) {
		this.com_bsns_name = com_bsns_name;
	}
	public String getCom_bsns_rep_name() {
		return com_bsns_rep_name;
	}
	public void setCom_bsns_rep_name(String com_bsns_rep_name) {
		this.com_bsns_rep_name = com_bsns_rep_name;
	}
	public String getCom_bsns_number() {
		return com_bsns_number;
	}
	public void setCom_bsns_number(String com_bsns_number) {
		this.com_bsns_number = com_bsns_number;
	}
	public String getCom_bsns_phone() {
		return com_bsns_phone;
	}
	public void setCom_bsns_phone(String com_bsns_phone) {
		this.com_bsns_phone = com_bsns_phone;
	}
	public MultipartFile getCom_bsns_reg_license() {
		return com_bsns_reg_license;
	}
	public void setCom_bsns_reg_license(MultipartFile com_bsns_reg_license) {
		this.com_bsns_reg_license = com_bsns_reg_license;
	}
	public MultipartFile getCom_bsns_cert() {
		return com_bsns_cert;
	}
	public void setCom_bsns_cert(MultipartFile com_bsns_cert) {
		this.com_bsns_cert = com_bsns_cert;
	}
	public String getCom_zipcode() {
		return com_zipcode;
	}
	public void setCom_zipcode(String com_zipcode) {
		this.com_zipcode = com_zipcode;
	}
	public String getCom_addr1() {
		return com_addr1;
	}
	public void setCom_addr1(String com_addr1) {
		this.com_addr1 = com_addr1;
	}
	public String getCom_addr2() {
		return com_addr2;
	}
	public void setCom_addr2(String com_addr2) {
		this.com_addr2 = com_addr2;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getOld_com_bsns_reg_license() {
		return old_com_bsns_reg_license;
	}
	public void setOld_com_bsns_reg_license(String old_com_bsns_reg_license) {
		this.old_com_bsns_reg_license = old_com_bsns_reg_license;
	}
	public String getOld_com_bsns_cert() {
		return old_com_bsns_cert;
	}
	public void setOld_com_bsns_cert(String old_com_bsns_cert) {
		this.old_com_bsns_cert = old_com_bsns_cert;
	}
	public String getOld_mem_profile_img() {
		return old_mem_profile_img;
	}

	public void setOld_mem_profile_img(String old_mem_profile_img) {
		this.old_mem_profile_img = old_mem_profile_img;
	}

	@Override
	public String toString() {
		return "ComMemberModifyRequest [mem_pw=" + mem_pw + ", mem_name=" + mem_name + ", mem_phone=" + mem_phone
				+ ", mem_profile_img=" + mem_profile_img + ", mem_profile_ori=" + mem_profile_ori + ", com_bsns_name="
				+ com_bsns_name + ", com_bsns_rep_name=" + com_bsns_rep_name + ", com_bsns_number=" + com_bsns_number
				+ ", com_bsns_phone=" + com_bsns_phone + ", com_bsns_reg_license=" + com_bsns_reg_license
				+ ", com_bsns_cert=" + com_bsns_cert + ", com_zipcode=" + com_zipcode + ", com_addr1=" + com_addr1
				+ ", com_addr2=" + com_addr2 + ", mem_email=" + mem_email + ", old_mem_profile_img="
				+ old_mem_profile_img + ", old_com_bsns_reg_license=" + old_com_bsns_reg_license
				+ ", old_com_bsns_cert=" + old_com_bsns_cert + "]";
	}
	
	public MemberVO toMemberVO() {
		MemberVO member = new MemberVO();
		member.setMem_email(mem_email);
		member.setMem_pw(mem_pw);
		member.setMem_name(mem_name);
		member.setMem_phone(mem_phone);
//		member.setMem_profile_img(mem_profile_img);
//		member.setMem_profile_ori(mem_profile_ori);
		
		member.setCom_bsns_name(com_bsns_name);
		member.setCom_bsns_rep_name(com_bsns_rep_name);
		member.setCom_bsns_number(com_bsns_number);
		member.setCom_bsns_phone(com_bsns_phone);
//		member.setCom_bsns_reg_license(com_bsns_reg_license);
//		member.setCom_bsns_cert(com_bsns_cert);
		
		member.setCom_zipcode(com_zipcode);
		member.setCom_addr1(com_addr1);
		member.setCom_addr2(com_addr2);
		
		return member;
	}
	
	

	
	
}
