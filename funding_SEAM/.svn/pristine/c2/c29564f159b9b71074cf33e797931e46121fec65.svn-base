<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="member list Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:detail_pjt_searchList_go(1);">
			<i class="fas fa-angle-double-left"></i>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:detail_pjt_searchList_go(
			${detailForProjectPageMaker.detail_pjt_prev ? detailForProjectPageMaker.detail_pjt_startPage-1 : 1}				
			);"><i class="fas fa-angle-left"></i></a>
		</li>
		<c:forEach begin="${detailForProjectPageMaker.detail_pjt_startPage }" end="${detailForProjectPageMaker.detail_pjt_endPage }" var="detail_pjt_pageNum">						
		<li class="page-item 
			<c:out value="${detailForProjectPageMaker.detail_pjt_page == detail_pjt_pageNum?'active':''}"/>">
			<a class="page-link page-num" href="javascript:detail_pjt_searchList_go(${detail_pjt_pageNum});" >${detail_pjt_pageNum }</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:detail_pjt_searchList_go(
			${detailForProjectPageMaker.detail_pjt_next ? detailForProjectPageMaker.detail_pjt_endPage+1 : detailForProjectPageMaker.detail_pjt_page}			
			);"><i class="fas fa-angle-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:detail_pjt_searchList_go(
				${detailForProjectPageMaker.detail_pjt_realEndPage});">
				<i class="fas fa-angle-double-right"></i></a>
		</li>	
	</ul>
</nav>

<form id="detail_pjt_jobForm">
	<input type='hidden' name="detail_pjt_page" value="${detailForProjectPageMaker.detail_pjt_page}" />
	<input type='hidden' name="detail_pjt_perPageNum" value="${detailForProjectPageMaker.detail_pjt_perPageNum}"/>
	<input type='hidden' name="mem_num" value="${comMember.mem_num}"/>
</form>


<script>

function detail_pjt_searchList_go(page){

	var detail_pjt_jobForm=$('#detail_pjt_jobForm');
	detail_pjt_jobForm.find("[name='detail_pjt_page']").val(page);
	detail_pjt_jobForm.find("[name='mem_num']").val();

	detail_pjt_jobForm.attr("method","get");
	detail_pjt_jobForm.attr("action","detail");		
	
	detail_pjt_jobForm.submit();

}
</script>