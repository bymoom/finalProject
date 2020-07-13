package com.funding.request;

import java.util.Date;

public class ProjectPayRequest {

		private int pjt_num;			//프로젝트 번호
		private String pjt_title;		//제목
		private String pjt_contents;	//내용
		private int pjt_cash;			//프로젝트 목표 금액
		private String pjt_int_rate;	//투자이자율
		private Date pjt_startdate;		//시작일
		private Date pjt_enddate;		//종료일
		private Date pjt_calcdate;		//정산일
		private Date pjt_regdate;		//작성일
		private Date pjt_moddate;		//수정일
		private int pjt_view_cnt;		//조회수
		private int pjt_thumbsup;		//추천수
		private int pjt_enabled;		//활성화여부
		private String pjt_category;	//카테고리
		private int pjt_type_code;		//분류코드 (기부,대출)
		private int pjt_state_code;		//진행상태코드(미승인,승인)
		private int mem_num;			//회원번호
		private String pjt_state_comment;//보류메시지
		private int pjt_calculate_code; //프로젝트 정산 상태코드
		private Date pjt_repaydate;		//프로젝트 상환일
		
		private int pjtPaySum; //프로젝트 후원 금액
		
		private int pjt_pay_num;		//결제 내역 번호
		private int pjt_pay_amount;		//결제금액
		private Date ptj_pay_date;		//결제일자
		private String pjt_pay_type;		//결제방식
		private int pjt_pay_usepoint;	//결제 사용한 포인트
		private int pjt_refund;			//환불여부
		private String pjt_pay_phone;		//회원 전화번호
		private Date pjt_pay_refund_date;//환불날짜
		private Date pjt_pay_calc_date;	//정산 날짜
		private int pjt_pay_calc_state;	//정산여부
		
		
		public ProjectPayRequest() {		}
		public ProjectPayRequest(int pjt_num, String pjt_title, String pjt_contents, int pjt_cash, String pjt_int_rate,
				Date pjt_startdate, Date pjt_enddate, Date pjt_calcdate, Date pjt_regdate, Date pjt_moddate,
				int pjt_view_cnt, int pjt_thumbsup, int pjt_enabled, String pjt_category, int pjt_type_code,
				int pjt_state_code, int mem_num, String pjt_state_comment, int pjt_calculate_code, Date pjt_repaydate,
				int pjtPaySum, int pjt_pay_num, int pjt_pay_amount, Date ptj_pay_date, String pjt_pay_type,
				int pjt_pay_usepoint, int pjt_refund, String pjt_pay_phone, Date pjt_pay_refund_date,
				Date pjt_pay_calc_date, int pjt_pay_calc_state) {
			super();
			this.pjt_num = pjt_num;
			this.pjt_title = pjt_title;
			this.pjt_contents = pjt_contents;
			this.pjt_cash = pjt_cash;
			this.pjt_int_rate = pjt_int_rate;
			this.pjt_startdate = pjt_startdate;
			this.pjt_enddate = pjt_enddate;
			this.pjt_calcdate = pjt_calcdate;
			this.pjt_regdate = pjt_regdate;
			this.pjt_moddate = pjt_moddate;
			this.pjt_view_cnt = pjt_view_cnt;
			this.pjt_thumbsup = pjt_thumbsup;
			this.pjt_enabled = pjt_enabled;
			this.pjt_category = pjt_category;
			this.pjt_type_code = pjt_type_code;
			this.pjt_state_code = pjt_state_code;
			this.mem_num = mem_num;
			this.pjt_state_comment = pjt_state_comment;
			this.pjt_calculate_code = pjt_calculate_code;
			this.pjt_repaydate = pjt_repaydate;
			this.pjtPaySum = pjtPaySum;
			this.pjt_pay_num = pjt_pay_num;
			this.pjt_pay_amount = pjt_pay_amount;
			this.ptj_pay_date = ptj_pay_date;
			this.pjt_pay_type = pjt_pay_type;
			this.pjt_pay_usepoint = pjt_pay_usepoint;
			this.pjt_refund = pjt_refund;
			this.pjt_pay_phone = pjt_pay_phone;
			this.pjt_pay_refund_date = pjt_pay_refund_date;
			this.pjt_pay_calc_date = pjt_pay_calc_date;
			this.pjt_pay_calc_state = pjt_pay_calc_state;
		}
		@Override
		public String toString() {
			return "ProjectPayRequest [pjt_num=" + pjt_num + ", pjt_title=" + pjt_title + ", pjt_contents="
					+ pjt_contents + ", pjt_cash=" + pjt_cash + ", pjt_int_rate=" + pjt_int_rate + ", pjt_startdate="
					+ pjt_startdate + ", pjt_enddate=" + pjt_enddate + ", pjt_calcdate=" + pjt_calcdate
					+ ", pjt_regdate=" + pjt_regdate + ", pjt_moddate=" + pjt_moddate + ", pjt_view_cnt=" + pjt_view_cnt
					+ ", pjt_thumbsup=" + pjt_thumbsup + ", pjt_enabled=" + pjt_enabled + ", pjt_category="
					+ pjt_category + ", pjt_type_code=" + pjt_type_code + ", pjt_state_code=" + pjt_state_code
					+ ", mem_num=" + mem_num + ", pjt_state_comment=" + pjt_state_comment + ", pjt_calculate_code="
					+ pjt_calculate_code + ", pjt_repaydate=" + pjt_repaydate + ", pjtPaySum=" + pjtPaySum
					+ ", pjt_pay_num=" + pjt_pay_num + ", pjt_pay_amount=" + pjt_pay_amount + ", ptj_pay_date="
					+ ptj_pay_date + ", pjt_pay_type=" + pjt_pay_type + ", pjt_pay_usepoint=" + pjt_pay_usepoint
					+ ", pjt_refund=" + pjt_refund + ", pjt_pay_phone=" + pjt_pay_phone + ", pjt_pay_refund_date="
					+ pjt_pay_refund_date + ", pjt_pay_calc_date=" + pjt_pay_calc_date + ", pjt_pay_calc_state="
					+ pjt_pay_calc_state + "]";
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
		public Date getPjt_repaydate() {
			return pjt_repaydate;
		}
		public void setPjt_repaydate(Date pjt_repaydate) {
			this.pjt_repaydate = pjt_repaydate;
		}
		public int getPjt_calculate_code() {
			return pjt_calculate_code;
		}
		public void setPjt_calculate_code(int pjt_calculate_code) {
			this.pjt_calculate_code = pjt_calculate_code;
		}
		public String getPjt_state_comment() {
			return pjt_state_comment;
		}
		public void setPjt_state_comment(String pjt_state_comment) {
			this.pjt_state_comment = pjt_state_comment;
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
		public String getPjt_contents() {
			return pjt_contents;
		}
		public void setPjt_contents(String pjt_contents) {
			this.pjt_contents = pjt_contents;
		}
		public int getPjt_cash() {
			return pjt_cash;
		}
		public void setPjt_cash(int pjt_cash) {
			this.pjt_cash = pjt_cash;
		}
		public String getPjt_int_rate() {
			return pjt_int_rate;
		}
		public void setPjt_int_rate(String pjt_int_rate) {
			this.pjt_int_rate = pjt_int_rate;
		}
		public Date getPjt_startdate() {
			return pjt_startdate;
		}
		public void setPjt_startdate(Date pjt_startdate) {
			this.pjt_startdate = pjt_startdate;
		}
		public Date getPjt_enddate() {
			return pjt_enddate;
		}
		public void setPjt_enddate(Date pjt_enddate) {
			this.pjt_enddate = pjt_enddate;
		}
		public Date getPjt_calcdate() {
			return pjt_calcdate;
		}
		public void setPjt_calcdate(Date pjt_calcdate) {
			this.pjt_calcdate = pjt_calcdate;
		}
		public Date getPjt_regdate() {
			return pjt_regdate;
		}
		public void setPjt_regdate(Date pjt_regdate) {
			this.pjt_regdate = pjt_regdate;
		}
		public Date getPjt_moddate() {
			return pjt_moddate;
		}
		public void setPjt_moddate(Date pjt_moddate) {
			this.pjt_moddate = pjt_moddate;
		}
		public int getPjt_view_cnt() {
			return pjt_view_cnt;
		}
		public void setPjt_view_cnt(int pjt_view_cnt) {
			this.pjt_view_cnt = pjt_view_cnt;
		}
		public int getPjt_thumbsup() {
			return pjt_thumbsup;
		}
		public void setPjt_thumbsup(int pjt_thumbsup) {
			this.pjt_thumbsup = pjt_thumbsup;
		}
		public int getPjt_enabled() {
			return pjt_enabled;
		}
		public void setPjt_enabled(int pjt_enabled) {
			this.pjt_enabled = pjt_enabled;
		}
		public String getPjt_category() {
			return pjt_category;
		}
		public void setPjt_category(String pjt_category) {
			this.pjt_category = pjt_category;
		}
		public int getPjt_type_code() {
			return pjt_type_code;
		}
		public void setPjt_type_code(int pjt_type_code) {
			this.pjt_type_code = pjt_type_code;
		}
		public int getPjt_state_code() {
			return pjt_state_code;
		}
		public void setPjt_state_code(int pjt_state_code) {
			this.pjt_state_code = pjt_state_code;
		}
		public int getMem_num() {
			return mem_num;
		}
		public void setMem_num(int mem_num) {
			this.mem_num = mem_num;
		}
		public int getPjtPaySum() {
			return pjtPaySum;
		}
		public void setPjtPaySum(int pjtPaySum) {
			this.pjtPaySum = pjtPaySum;
		}
		
		
		
	}
