package com.funding.request;

import java.util.Date;

public class MypagePaylistRequest {

	private int pjt_num;			//프로젝트 번호
	private String pjt_title;		//제목
	private Date pjt_enddate;		//종료일
	
	private int pjt_pay_num;		//결제 내역 번호
	private int pjt_pay_amount;		//결제금액
	private Date ptj_pay_date;		//결제일자
	private String pjt_pay_type;		//결제방식
	private int pjt_pay_usepoint;	//결제 사용한 포인트
	private int pjt_refund;			//환불여부
	private int mem_num;			//회원번호
	private String pjt_pay_phone;		//회원 전화번호
	private Date pjt_pay_refund_date;//환불날짜
	private Date pjt_pay_calc_date;	//정산 날짜
	private int pjt_pay_calc_state;	//정산여부
	
	
	public MypagePaylistRequest() {}


	public MypagePaylistRequest(int pjt_num, String pjt_title, Date pjt_enddate, int pjt_pay_num, int pjt_pay_amount,
			Date ptj_pay_date, String pjt_pay_type, int pjt_pay_usepoint, int pjt_refund, int mem_num,
			String pjt_pay_phone, Date pjt_pay_refund_date, Date pjt_pay_calc_date, int pjt_pay_calc_state) {
		super();
		this.pjt_num = pjt_num;
		this.pjt_title = pjt_title;
		this.pjt_enddate = pjt_enddate;
		this.pjt_pay_num = pjt_pay_num;
		this.pjt_pay_amount = pjt_pay_amount;
		this.ptj_pay_date = ptj_pay_date;
		this.pjt_pay_type = pjt_pay_type;
		this.pjt_pay_usepoint = pjt_pay_usepoint;
		this.pjt_refund = pjt_refund;
		this.mem_num = mem_num;
		this.pjt_pay_phone = pjt_pay_phone;
		this.pjt_pay_refund_date = pjt_pay_refund_date;
		this.pjt_pay_calc_date = pjt_pay_calc_date;
		this.pjt_pay_calc_state = pjt_pay_calc_state;
	}


	public int getPjt_num() {
		return pjt_num;
	}


	public void setPjt_num(int pjt_num) {
		this.pjt_num = pjt_num;
	}


	public String getPjt_title() {
		return pjt_title;
	}


	public void setPjt_title(String pjt_title) {
		this.pjt_title = pjt_title;
	}


	public Date getPjt_enddate() {
		return pjt_enddate;
	}


	public void setPjt_enddate(Date pjt_enddate) {
		this.pjt_enddate = pjt_enddate;
	}


	public int getPjt_pay_num() {
		return pjt_pay_num;
	}


	public void setPjt_pay_num(int pjt_pay_num) {
		this.pjt_pay_num = pjt_pay_num;
	}


	public int getPjt_pay_amount() {
		return pjt_pay_amount;
	}


	public void setPjt_pay_amount(int pjt_pay_amount) {
		this.pjt_pay_amount = pjt_pay_amount;
	}


	public Date getPtj_pay_date() {
		return ptj_pay_date;
	}


	public void setPtj_pay_date(Date ptj_pay_date) {
		this.ptj_pay_date = ptj_pay_date;
	}


	public String getPjt_pay_type() {
		return pjt_pay_type;
	}


	public void setPjt_pay_type(String pjt_pay_type) {
		this.pjt_pay_type = pjt_pay_type;
	}


	public int getPjt_pay_usepoint() {
		return pjt_pay_usepoint;
	}


	public void setPjt_pay_usepoint(int pjt_pay_usepoint) {
		this.pjt_pay_usepoint = pjt_pay_usepoint;
	}


	public int getPjt_refund() {
		return pjt_refund;
	}


	public void setPjt_refund(int pjt_refund) {
		this.pjt_refund = pjt_refund;
	}


	public int getMem_num() {
		return mem_num;
	}


	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}


	public String getPjt_pay_phone() {
		return pjt_pay_phone;
	}


	public void setPjt_pay_phone(String pjt_pay_phone) {
		this.pjt_pay_phone = pjt_pay_phone;
	}


	public Date getPjt_pay_refund_date() {
		return pjt_pay_refund_date;
	}


	public void setPjt_pay_refund_date(Date pjt_pay_refund_date) {
		this.pjt_pay_refund_date = pjt_pay_refund_date;
	}


	public Date getPjt_pay_calc_date() {
		return pjt_pay_calc_date;
	}


	public void setPjt_pay_calc_date(Date pjt_pay_calc_date) {
		this.pjt_pay_calc_date = pjt_pay_calc_date;
	}


	public int getPjt_pay_calc_state() {
		return pjt_pay_calc_state;
	}


	public void setPjt_pay_calc_state(int pjt_pay_calc_state) {
		this.pjt_pay_calc_state = pjt_pay_calc_state;
	}
	
	
	
	
	
}
