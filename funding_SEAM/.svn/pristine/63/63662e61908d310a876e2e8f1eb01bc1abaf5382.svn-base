<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="member list Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(1);">
			<i class="fas fa-angle-double-left"></i>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${projectPayPageMaker.prev ? projectPayPageMaker.startPage-1 : 1}				
			);"><i class="fas fa-angle-left"></i></a>
		</li>
		<c:forEach begin="${projectPayPageMaker.startPage }" end="${projectPayPageMaker.endPage }" var="pageNum">						
		<li class="page-item 
			<c:out value="${projectPayPageMaker.page == pageNum?'active':''}"/>">
			<a class="page-link page-num" href="javascript:searchList_go(${pageNum});" >${pageNum }</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${projectPayPageMaker.next ? projectPayPageMaker.endPage+1 : projectPayPageMaker.page}			
			);"><i class="fas fa-angle-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
				${projectPayPageMaker.realEndPage});">
				<i class="fas fa-angle-double-right"></i></a>
		</li>	
	</ul>
</nav>

<form id="jobForm">
	<input type='hidden' name="page" value="${projectPayPageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${projectPayPageMaker.perPageNum}"/>
	<input type='hidden' name="mem_num" value="${member.mem_num}"/>
</form>


<script>

function searchList_go(page){

	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='mem_num']").val();

	jobForm.attr("method","get");
	jobForm.attr("action","detail");		
	
	jobForm.submit();

}
</script>