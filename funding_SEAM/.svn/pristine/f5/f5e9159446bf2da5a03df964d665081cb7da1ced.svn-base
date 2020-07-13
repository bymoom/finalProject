package com.funding.request;

public class AdminDetailForProjectPageMaker {
	
	private int detail_pjt_totalCount; // 전체 행의 개수
	private int detail_pjt_startPage=1; // 시작 페이지 번호
	private int detail_pjt_endPage=1; // 마지막 페이지 번호
	private int detail_pjt_realEndPage; // 끝 페이지 번호
	private boolean detail_pjt_prev; //이전페이지 버튼 유무
	private boolean detail_pjt_next; //다음페이지 버튼 유무
	
	private int detail_pjt_displayPageNum=10; //한 페이지에 보여줄 페이지번호 개수
	
	private int detail_pjt_page=1; //페이지 번호
	private int detail_pjt_perPageNum=5; //페이지당 리스트 개수
	
	//starPage,endPage, prev, next 설정. by totalCount
	private void calcData(){
		detail_pjt_endPage = (int) (Math.ceil(detail_pjt_page / (double) detail_pjt_displayPageNum)
					* detail_pjt_displayPageNum);
					detail_pjt_startPage = (detail_pjt_endPage - detail_pjt_displayPageNum) + 1;		
		
		detail_pjt_realEndPage= (int) (Math.ceil(detail_pjt_totalCount / (double) detail_pjt_perPageNum));
		
		if(detail_pjt_startPage<0){
			detail_pjt_startPage=1;
		}
		if (detail_pjt_endPage > detail_pjt_realEndPage) {		
			detail_pjt_endPage = detail_pjt_realEndPage;			
		}
		
		detail_pjt_prev = detail_pjt_startPage == 1 ? false : true;
		detail_pjt_next = detail_pjt_endPage * detail_pjt_perPageNum >= detail_pjt_totalCount ? false : true;
	}

	public AdminDetailForProjectPageMaker() {}

	public AdminDetailForProjectPageMaker(int detail_pjt_totalCount, int detail_pjt_startPage, int detail_pjt_endPage,
			int detail_pjt_realEndPage, boolean detail_pjt_prev, boolean detail_pjt_next, int detail_pjt_displayPageNum,
			int detail_pjt_page, int detail_pjt_perPageNum) {
		super();
		this.detail_pjt_totalCount = detail_pjt_totalCount;
		this.detail_pjt_startPage = detail_pjt_startPage;
		this.detail_pjt_endPage = detail_pjt_endPage;
		this.detail_pjt_realEndPage = detail_pjt_realEndPage;
		this.detail_pjt_prev = detail_pjt_prev;
		this.detail_pjt_next = detail_pjt_next;
		this.detail_pjt_displayPageNum = detail_pjt_displayPageNum;
		this.detail_pjt_page = detail_pjt_page;
		this.detail_pjt_perPageNum = detail_pjt_perPageNum;
	}

	public int getDetail_pjt_totalCount() {
		return detail_pjt_totalCount;
	}

	public void setDetail_pjt_totalCount(int detail_pjt_totalCount) {
		this.detail_pjt_totalCount = detail_pjt_totalCount;
		
		calcData();
	}

	public int getDetail_pjt_startPage() {
		return detail_pjt_startPage;
	}

	public void setDetail_pjt_startPage(int detail_pjt_startPage) {
		this.detail_pjt_startPage = detail_pjt_startPage;
	}

	public int getDetail_pjt_endPage() {
		return detail_pjt_endPage;
	}

	public void setDetail_pjt_endPage(int detail_pjt_endPage) {
		this.detail_pjt_endPage = detail_pjt_endPage;
	}

	public int getDetail_pjt_realEndPage() {
		return detail_pjt_realEndPage;
	}

	public void setDetail_pjt_realEndPage(int detail_pjt_realEndPage) {
		this.detail_pjt_realEndPage = detail_pjt_realEndPage;
	}

	public boolean isDetail_pjt_prev() {
		return detail_pjt_prev;
	}

	public void setDetail_pjt_prev(boolean detail_pjt_prev) {
		this.detail_pjt_prev = detail_pjt_prev;
	}

	public boolean isDetail_pjt_next() {
		return detail_pjt_next;
	}

	public void setDetail_pjt_next(boolean detail_pjt_next) {
		this.detail_pjt_next = detail_pjt_next;
	}

	public int getDetail_pjt_displayPageNum() {
		return detail_pjt_displayPageNum;
	}

	public void setDetail_pjt_displayPageNum(int detail_pjt_displayPageNum) {
		this.detail_pjt_displayPageNum = detail_pjt_displayPageNum;
	}

	public int getDetail_pjt_page() {
		return detail_pjt_page;
	}

	public void setDetail_pjt_page(int detail_pjt_page) {
		this.detail_pjt_page = detail_pjt_page;
	}

	public int getDetail_pjt_perPageNum() {
		return detail_pjt_perPageNum;
	}

	public void setDetail_pjt_perPageNum(int detail_pjt_perPageNum) {
		this.detail_pjt_perPageNum = detail_pjt_perPageNum;
	}
	
	public int getPageStartRowNum() {  //각 페이지마다 시작하는 행번호
		return(this.detail_pjt_page-1)*detail_pjt_perPageNum;
	}

	@Override
	public String toString() {
		return "AdminDetailForProjectPageMaker [detail_pjt_totalCount=" + detail_pjt_totalCount
				+ ", detail_pjt_startPage=" + detail_pjt_startPage + ", detail_pjt_endPage=" + detail_pjt_endPage
				+ ", detail_pjt_realEndPage=" + detail_pjt_realEndPage + ", detail_pjt_prev=" + detail_pjt_prev
				+ ", detail_pjt_next=" + detail_pjt_next + ", detail_pjt_displayPageNum=" + detail_pjt_displayPageNum
				+ ", detail_pjt_page=" + detail_pjt_page + ", detail_pjt_perPageNum=" + detail_pjt_perPageNum + "]";
	}
	
}
