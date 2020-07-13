package com.funding.request;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class AdminProjectPaySearchCriteria {

	private Integer page; //페이지 번호
	private Integer perPageNum; //페이지당 리스트 개수
	private String searchType;  //검색구분
	private String keyword;  //검색어
	private String pjtPayType; //결제 방식
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date firstPjtPayDate; //결제 날짜1
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date lastPjtPayDate; //결제 날짜2
	private Integer firstPjtPayAmount; //결제 금액1
	private Integer lastPjtPayAmount; //결제 금액2
	private String pjtRefundType; //환불 여부
	
	public AdminProjectPaySearchCriteria() {
		super();
		this.page = 1;
		this.perPageNum = 10;
	}

	public AdminProjectPaySearchCriteria(Integer page, Integer perPageNum, String searchType, String keyword, String pjtPayType,
			Date firstPjtPayDate, Date lastPjtPayDate, Integer firstPjtPayAmount, Integer lastPjtPayAmount,
			String pjtRefundType) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.searchType = searchType;
		this.keyword = keyword;
		this.pjtPayType = pjtPayType;
		this.firstPjtPayDate = firstPjtPayDate;
		this.lastPjtPayDate = lastPjtPayDate;
		this.firstPjtPayAmount = firstPjtPayAmount;
		this.lastPjtPayAmount = lastPjtPayAmount;
		this.pjtRefundType = pjtRefundType;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(Integer perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPjtPayType() {
		return pjtPayType;
	}

	public void setPjtPayType(String pjtPayType) {
		this.pjtPayType = pjtPayType;
	}

	public Date getFirstPjtPayDate() {
		return firstPjtPayDate;
	}

	public void setFirstPjtPayDate(Date firstPjtPayDate) {
		this.firstPjtPayDate = firstPjtPayDate;
	}

	public Date getLastPjtPayDate() {
		return lastPjtPayDate;
	}

	public void setLastPjtPayDate(Date lastPjtPayDate) {
		this.lastPjtPayDate = lastPjtPayDate;
	}

	public Integer getFirstPjtPayAmount() {
		return firstPjtPayAmount;
	}

	public void setFirstPjtPayAmount(Integer firstPjtPayAmount) {
		this.firstPjtPayAmount = firstPjtPayAmount;
	}

	public Integer getLastPjtPayAmount() {
		return lastPjtPayAmount;
	}

	public void setLastPjtPayAmount(Integer lastPjtPayAmount) {
		this.lastPjtPayAmount = lastPjtPayAmount;
	}

	public String getPjtRefundType() {
		return pjtRefundType;
	}

	public void setPjtRefundType(String pjtRefundType) {
		this.pjtRefundType = pjtRefundType;
	}
	
	public Integer getPageStartRowNum() {  //각 페이지마다 시작하는 행번호
		return(this.page-1)*perPageNum;
	}

	@Override
	public String toString() {
		return "AdminProjectPaySearchCriteria [page=" + page + ", perPageNum=" + perPageNum + ", searchType="
				+ searchType + ", keyword=" + keyword + ", pjtPayType=" + pjtPayType + ", firstPjtPayDate="
				+ firstPjtPayDate + ", lastPjtPayDate=" + lastPjtPayDate + ", firstPjtPayAmount=" + firstPjtPayAmount
				+ ", lastPjtPayAmount=" + lastPjtPayAmount + ", pjtRefundType=" + pjtRefundType + "]";
	}
	
}
