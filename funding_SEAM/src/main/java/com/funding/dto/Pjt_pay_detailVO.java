package com.funding.dto;

import java.util.Date;

public class Pjt_pay_detailVO {
	
	private int pjt_pay_num;		//결제내역 번호
	private int pjt_pay_amount;		//결제금액
	private Date ptj_pay_date;		//결제일자
	private String pjt_pay_type;	//결제방식
	private int pjt_pay_usepoint;	//결제사용한포인트
	private int pjt_refund;			//환불 여부
	private int mem_num;			//회원 번호
	private int pjt_num;			//프로젝트 번호
	private String pjt_pay_phone;	//결제 휴대폰번호
	private Date pjt_pay_refund_date;//환불 날짜
	private Date pjt_pay_calc_date;	 //정산 날짜
	private int pjt_pay_calc_state;	//정산 여부
	
	
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
	public String getPjt_pay_phone() {
		return pjt_pay_phone;
	}
	public void setPjt_pay_phone(String pjt_pay_phone) {
		this.pjt_pay_phone = pjt_pay_phone;
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
	public int getPjt_num() {
		return pjt_num;
	}
	public void setPjt_num(int pjt_num) {
		this.pjt_num = pjt_num;
	}
	public Pjt_pay_detailVO(int pjt_pay_num, int pjt_pay_amount, Date ptj_pay_date, String pjt_pay_type,
			int pjt_pay_usepoint, int pjt_refund, int mem_num, int pjt_num, String pjt_pay_phone,
			Date pjt_pay_refund_date, Date pjt_pay_calc_date, int pjt_pay_calc_state) {
		super();
		this.pjt_pay_num = pjt_pay_num;
		this.pjt_pay_amount = pjt_pay_amount;
		this.ptj_pay_date = ptj_pay_date;
		this.pjt_pay_type = pjt_pay_type;
		this.pjt_pay_usepoint = pjt_pay_usepoint;
		this.pjt_refund = pjt_refund;
		this.mem_num = mem_num;
		this.pjt_num = pjt_num;
		this.pjt_pay_phone = pjt_pay_phone;
		this.pjt_pay_refund_date = pjt_pay_refund_date;
		this.pjt_pay_calc_date = pjt_pay_calc_date;
		this.pjt_pay_calc_state = pjt_pay_calc_state;
	}
	@Override
	public String toString() {
		return "Pjt_pay_detailVO [pjt_pay_num=" + pjt_pay_num + ", pjt_pay_amount=" + pjt_pay_amount + ", ptj_pay_date="
				+ ptj_pay_date + ", pjt_pay_type=" + pjt_pay_type + ", pjt_pay_usepoint=" + pjt_pay_usepoint
				+ ", pjt_refund=" + pjt_refund + ", mem_num=" + mem_num + ", pjt_num=" + pjt_num + ", pjt_pay_phone="
				+ pjt_pay_phone + ", pjt_pay_refund_date=" + pjt_pay_refund_date + ", pjt_pay_calc_date="
				+ pjt_pay_calc_date + ", pjt_pay_calc_state=" + pjt_pay_calc_state + "]";
	}
	public Pjt_pay_detailVO() {	}

}
