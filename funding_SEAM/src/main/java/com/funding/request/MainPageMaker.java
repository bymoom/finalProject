package com.funding.request;

public class MainPageMaker {
	private int totalCount; // 전체 행의 개수
	private int startPage=1; // 시작 페이지 번호
	private int endPage=1; // 마지막 페이지 번호
	private int realEndPage; // 끝 페이지 번호
	private boolean prev; //이전페이지 버튼 유무
	private boolean next; //다음페이지 버튼 유무
	
	private int displayPageNum=1; //한 페이지에 보여줄 페이지번호 개수
	
	private MainSearchCriteria mainCri; //현재 페이지 정보
	
	public int getRealEndPage() {
		return realEndPage;
	}

	public void setRealEndPage(int realEndPage) {
		this.realEndPage = realEndPage;
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

	public MainSearchCriteria getMainCri() {
		return mainCri;
	}

	public void setMainCri(MainSearchCriteria mainCri) {
		this.mainCri = mainCri;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", realEndPage=" + realEndPage + ", prev=" + prev + ", next=" + next + ", displayPageNum="
				+ displayPageNum + ", mainCri=" + mainCri + "]";
	}

	//starPage,endPage, prev, next 설정. by totalCount
	private void calcData(){
		//마지막 페이지는 현재 페이지/화면에 보여주는페이지수(10)에서 올림하여 10을 곱한다.
		endPage = (int) (Math.ceil(mainCri.getPage() / (double) displayPageNum)
					* displayPageNum);
		
		//시작페이지는 마지막페이지-화면에 보여주는 페이지수(10)+1이다.
		startPage = (endPage - displayPageNum) + 1;
		
		//끝페이지는 전체수/1페이지당 노출되는글 올림이다.
		realEndPage= (int) (Math.ceil(totalCount / 
									(double) mainCri.getPerPageNum()));
		
		
		//마지막 페이지가 끝 페이지보다 높을경우 마지막페이지로 셋팅
		if (endPage > realEndPage) {
			endPage = realEndPage;
		}

		//시작 페이지가 1이면 prev가 없음
		prev = startPage == 1 ? false : true;
		
		//끝 페이지*1페이지당 노출되는 글이 전체 글보다 많거나 같을경우 next가 없음
		next = endPage * mainCri.getPerPageNum() >= totalCount ? false : true;
	}
	
	
	
	public String makeQuery(){	
		String query="?page="+mainCri.getPage()
				    +"&perPageNum="+mainCri.getPerPageNum()
				    +"&whereType="+mainCri.getWhereType()
				    +"&keyword="+mainCri.getKeyword();
		return query;
	}
	
	public String makeQuery(int page){	
		String query="?page="+page
				    +"&perPageNum="+mainCri.getPerPageNum()
				    +"&whereType="+mainCri.getWhereType()
				    +"&keyword="+mainCri.getKeyword();
		return query;
	}
}
