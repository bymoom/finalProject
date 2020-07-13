package com.funding.request;

import java.util.Date;

public class AdminProjectRequest {
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
	private int pjt_state_code;		//진행상태코드(미승인, 승인, 보류, 승인재요청)
	private int mem_num;			//회원번호
	private String pjt_state_comment; //보류메시지
	private String pjt_state_code_val; //코드값(미승인,승인,보류)
	private String pjt_type_code_val; //코드값(기부,대출)
	private int pjtPaySum; //프로젝트 후원 금액
	private String pjt_atc_sum_name; //섬네일파일이름
	private String com_bsns_name; //사업장명
	private String com_addr1; //사업장주소
	
	private int pjt_atc_num;				//첨부번호
	private String pjt_atc_bankbook_path;	//통장파일경로
	private String pjt_atc_bankbook_name;	//통장파일이름
	private String pjt_atc_sum_path;		//섬네일파일경로
	private Date pjt_atc_regdate;			//첨부 등록일자
	private Date pjt_atc_moddate;			//첨부 수정일자
	private int pjt_calculate_code; //프로젝트 정산 상태코드
	private Date pjt_repaydate;		//프로젝트 상환일
	
	private Date dateToRefund; //대출상환일
	
	public AdminProjectRequest() {}

	public AdminProjectRequest(int pjt_num, String pjt_title, String pjt_contents, int pjt_cash, String pjt_int_rate,
			Date pjt_startdate, Date pjt_enddate, Date pjt_calcdate, Date pjt_regdate, Date pjt_moddate,
			int pjt_view_cnt, int pjt_thumbsup, int pjt_enabled, String pjt_category, int pjt_type_code,
			int pjt_state_code, int mem_num, String pjt_state_comment, String pjt_state_code_val,
			String pjt_type_code_val, int pjtPaySum, String pjt_atc_sum_name, String com_bsns_name, String com_addr1,
			int pjt_atc_num, String pjt_atc_bankbook_path, String pjt_atc_bankbook_name, String pjt_atc_sum_path,
			Date pjt_atc_regdate, Date pjt_atc_moddate, int pjt_calculate_code, Date pjt_repaydate, Date dateToRefund) {
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
		this.pjt_state_code_val = pjt_state_code_val;
		this.pjt_type_code_val = pjt_type_code_val;
		this.pjtPaySum = pjtPaySum;
		this.pjt_atc_sum_name = pjt_atc_sum_name;
		this.com_bsns_name = com_bsns_name;
		this.com_addr1 = com_addr1;
		this.pjt_atc_num = pjt_atc_num;
		this.pjt_atc_bankbook_path = pjt_atc_bankbook_path;
		this.pjt_atc_bankbook_name = pjt_atc_bankbook_name;
		this.pjt_atc_sum_path = pjt_atc_sum_path;
		this.pjt_atc_regdate = pjt_atc_regdate;
		this.pjt_atc_moddate = pjt_atc_moddate;
		this.pjt_calculate_code = pjt_calculate_code;
		this.pjt_repaydate = pjt_repaydate;
		this.dateToRefund = dateToRefund;
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

	public String getPjt_state_comment() {
		return pjt_state_comment;
	}

	public void setPjt_state_comment(String pjt_state_comment) {
		this.pjt_state_comment = pjt_state_comment;
	}

	public String getPjt_state_code_val() {
		return pjt_state_code_val;
	}

	public void setPjt_state_code_val(String pjt_state_code_val) {
		this.pjt_state_code_val = pjt_state_code_val;
	}

	public String getPjt_type_code_val() {
		return pjt_type_code_val;
	}

	public void setPjt_type_code_val(String pjt_type_code_val) {
		this.pjt_type_code_val = pjt_type_code_val;
	}

	public int getPjtPaySum() {
		return pjtPaySum;
	}

	public void setPjtPaySum(int pjtPaySum) {
		this.pjtPaySum = pjtPaySum;
	}

	public String getPjt_atc_sum_name() {
		return pjt_atc_sum_name;
	}

	public void setPjt_atc_sum_name(String pjt_atc_sum_name) {
		this.pjt_atc_sum_name = pjt_atc_sum_name;
	}

	public String getCom_bsns_name() {
		return com_bsns_name;
	}

	public void setCom_bsns_name(String com_bsns_name) {
		this.com_bsns_name = com_bsns_name;
	}

	public String getCom_addr1() {
		return com_addr1;
	}

	public void setCom_addr1(String com_addr1) {
		this.com_addr1 = com_addr1;
	}

	public int getPjt_atc_num() {
		return pjt_atc_num;
	}

	public void setPjt_atc_num(int pjt_atc_num) {
		this.pjt_atc_num = pjt_atc_num;
	}

	public String getPjt_atc_bankbook_path() {
		return pjt_atc_bankbook_path;
	}

	public void setPjt_atc_bankbook_path(String pjt_atc_bankbook_path) {
		this.pjt_atc_bankbook_path = pjt_atc_bankbook_path;
	}

	public String getPjt_atc_bankbook_name() {
		return pjt_atc_bankbook_name;
	}

	public void setPjt_atc_bankbook_name(String pjt_atc_bankbook_name) {
		this.pjt_atc_bankbook_name = pjt_atc_bankbook_name;
	}

	public String getPjt_atc_sum_path() {
		return pjt_atc_sum_path;
	}

	public void setPjt_atc_sum_path(String pjt_atc_sum_path) {
		this.pjt_atc_sum_path = pjt_atc_sum_path;
	}

	public Date getPjt_atc_regdate() {
		return pjt_atc_regdate;
	}

	public void setPjt_atc_regdate(Date pjt_atc_regdate) {
		this.pjt_atc_regdate = pjt_atc_regdate;
	}

	public Date getPjt_atc_moddate() {
		return pjt_atc_moddate;
	}

	public void setPjt_atc_moddate(Date pjt_atc_moddate) {
		this.pjt_atc_moddate = pjt_atc_moddate;
	}

	public Date getDateToRefund() {
		return dateToRefund;
	}

	public void setDateToRefund(Date dateToRefund) {
		this.dateToRefund = dateToRefund;
	}

	public int getPjt_calculate_code() {
		return pjt_calculate_code;
	}

	public void setPjt_calculate_code(int pjt_calculate_code) {
		this.pjt_calculate_code = pjt_calculate_code;
	}

	public Date getPjt_repaydate() {
		return pjt_repaydate;
	}

	public void setPjt_repaydate(Date pjt_repaydate) {
		this.pjt_repaydate = pjt_repaydate;
	}

	@Override
	public String toString() {
		return "AdminProjectRequest [pjt_num=" + pjt_num + ", pjt_title=" + pjt_title + ", pjt_contents=" + pjt_contents
				+ ", pjt_cash=" + pjt_cash + ", pjt_int_rate=" + pjt_int_rate + ", pjt_startdate=" + pjt_startdate
				+ ", pjt_enddate=" + pjt_enddate + ", pjt_calcdate=" + pjt_calcdate + ", pjt_regdate=" + pjt_regdate
				+ ", pjt_moddate=" + pjt_moddate + ", pjt_view_cnt=" + pjt_view_cnt + ", pjt_thumbsup=" + pjt_thumbsup
				+ ", pjt_enabled=" + pjt_enabled + ", pjt_category=" + pjt_category + ", pjt_type_code=" + pjt_type_code
				+ ", pjt_state_code=" + pjt_state_code + ", mem_num=" + mem_num + ", pjt_state_comment="
				+ pjt_state_comment + ", pjt_state_code_val=" + pjt_state_code_val + ", pjt_type_code_val="
				+ pjt_type_code_val + ", pjtPaySum=" + pjtPaySum + ", pjt_atc_sum_name=" + pjt_atc_sum_name
				+ ", com_bsns_name=" + com_bsns_name + ", com_addr1=" + com_addr1 + ", pjt_atc_num=" + pjt_atc_num
				+ ", pjt_atc_bankbook_path=" + pjt_atc_bankbook_path + ", pjt_atc_bankbook_name="
				+ pjt_atc_bankbook_name + ", pjt_atc_sum_path=" + pjt_atc_sum_path + ", pjt_atc_regdate="
				+ pjt_atc_regdate + ", pjt_atc_moddate=" + pjt_atc_moddate + ", pjt_calculate_code="
				+ pjt_calculate_code + ", pjt_repaydate=" + pjt_repaydate + ", dateToRefund=" + dateToRefund + "]";
	}
	
}
