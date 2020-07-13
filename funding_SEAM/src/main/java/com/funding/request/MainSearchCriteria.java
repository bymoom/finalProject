package com.funding.request;

public class MainSearchCriteria {
	
	private int page;  //페이지번호
	private int perPageNum;  // 페이지당 리스트 갯수
	private String whereType;  // 카테고리 구분
	private String keyword;  // 검색어
	
	public MainSearchCriteria() {
		super();
		this.page = 1;
		this.perPageNum = 3;
		this.whereType = "";
		this.keyword = "";
	}
	public int getPageStartRowNum(){ //각 페이지마다 시작하는 행번호
		return (this.page-1)*perPageNum;
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getWhereType() {
		return whereType;
	}

	public void setWhereType(String whereType) {
		this.whereType = whereType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	

}
