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
			${pageMaker.prev ? pageMaker.startPage-1 : 1}				
			);"><i class="fas fa-angle-left"></i></a>
		</li>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
		<li class="page-item 
			<c:out value="${pageMaker.page == pageNum?'active':''}"/>">
			<a class="page-link page-num" href="javascript:searchList_go(${pageNum});" >${pageNum }</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.next ? pageMaker.endPage+1 : pageMaker.page}			
			);"><i class="fas fa-angle-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
				${pageMaker.realEndPage});">
				<i class="fas fa-angle-double-right"></i></a>
		</li>	
	</ul>
</nav>

<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.perPageNum}"/>
	<input type='hidden' name="pjt_num" value="${project.pjt_num}"/>
	<input type='hidden' name="mem_num" value="${project.mem_num}"/>
</form>


<script>
	function searchList_go(page){
	
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='pjt_num']").val();
		jobForm.find("[name='mem_num']").val();
	
		jobForm.attr("method","get");
		jobForm.attr("action","detail");		
		
		jobForm.submit();
	
	}
</script>