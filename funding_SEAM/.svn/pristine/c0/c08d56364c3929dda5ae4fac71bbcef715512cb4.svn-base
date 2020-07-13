package com.funding.request;

public class AdminDetailPageMaker {
	private int totalCount; // 전체 행의 개수
	private int startPage=1; // 시작 페이지 번호
	private int endPage=1; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; //이전페이지 버튼 유무
	private boolean next; //다음페이지 버튼 유무
	
	private int displayPageNum=10; //한 페이지에 보여줄 페이지번호 개수
	
	private int page=1; //페이지 번호
	private int perPageNum=10; //페이지당 리스트 개수
	
	//starPage,endPage, prev, next 설정. by totalCount
	private void calcData(){
		endPage = (int) (Math.ceil(page / (double) displayPageNum)
					* displayPageNum);
					startPage = (endPage - displayPageNum) + 1;		
		
		realEndPage= (int) (Math.ceil(totalCount / (double) perPageNum));
		
		if(startPage<0){
			startPage=1;
		}
		if (endPage > realEndPage) {		
			endPage = realEndPage;			
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage * perPageNum >= totalCount ? false : true;
	}
	
	public AdminDetailPageMaker() {}

	public AdminDetailPageMaker(int totalCount, int startPage, int endPage, int realEndPage, boolean prev, boolean next,
			int displayPageNum, int page, int perPageNum) {
		super();
		this.totalCount = totalCount;
		this.startPage = startPage;
		this.endPage = endPage;
		this.realEndPage = realEndPage;
		this.prev = prev;
		this.next = next;
		this.displayPageNum = displayPageNum;
		this.page = page;
		this.perPageNum = perPageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
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

	public int getPageStartRowNum() {  //각 페이지마다 시작하는 행번호
		return(this.page-1)*perPageNum;
	}
	
	@Override
	public String toString() {
		return "AdminDetailPageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", realEndPage=" + realEndPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + ", page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
