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
			<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
			<a class="page-link" href="javascript:searchList_go(${pageNum});" >${pageNum }
			</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page}			
			);"><i class="fas fa-angle-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
				${pageMaker.realEndPage} );">
				<i class="fas fa-angle-double-right"></i></a>
		</li>	
	</ul>
</nav>   	

<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	<input type='hidden' name="categoryType" value="${pageMaker.cri.categoryType }" />
	<input type='hidden' name="pjtType" value="${pageMaker.cri.pjtType }" />
	<input type='hidden' name="stateType" value="${pageMaker.cri.stateType }" />
	<input type='hidden' name="progressType" value="${pageMaker.cri.progressType }" />
	<input type='hidden' name="calcType" value="${pageMaker.cri.calcType }" />
	<input type='hidden' name="calcDate" value="${pageMaker.cri.calcDate }" />
	<input type='hidden' name="successOrFailure" value="${pageMaker.cri.successOrFailure }" />
</form>


<script>
	function stateStandByListGo(){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1);
		jobForm.find("[name='stateType']").val("미승인");	
		
		jobForm.find("[name='searchType']").val("");
		jobForm.find("[name='keyword']").val("");	
		jobForm.find("[name='categoryType']").val("");	
		jobForm.find("[name='pjtType']").val("");	
		jobForm.find("[name='progressType']").val("");	
		jobForm.find("[name='calcType']").val("");	
		jobForm.find("[name='calcDate']").val("");
		jobForm.find("[name='successOrFailure']").val("");
		
		jobForm.attr("method","post");
		jobForm.attr("action","list");		
		
		jobForm.submit();
	}
	
	function calcStandByListGo(){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(1);
		jobForm.find("[name='calcType']").val("정산 미완료");	
		
		jobForm.find("[name='searchType']").val("");
		jobForm.find("[name='keyword']").val("");	
		jobForm.find("[name='categoryType']").val("");	
		jobForm.find("[name='pjtType']").val("");	
		jobForm.find("[name='progressType']").val("");	
		jobForm.find("[name='calcDate']").val("");
		jobForm.find("[name='stateType']").val("");	
		jobForm.find("[name='successOrFailure']").val("");
		
		jobForm.attr("method","post");
		jobForm.attr("action","list");		
		
		jobForm.submit();
	}
	
	function searchList_go(page,url){
		
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
		jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());	
		jobForm.find("[name='categoryType']").val($('select[name="categoryType"]').val());	
		jobForm.find("[name='pjtType']").val($('select[name="pjtType"]').val());	
		jobForm.find("[name='stateType']").val($('select[name="stateType"]').val());	
		jobForm.find("[name='progressType']").val($('select[name="progressType"]').val());	
		jobForm.find("[name='calcType']").val($('select[name="calcType"]').val());	
		jobForm.find("[name='calcDate']").val($('input[name="calcDate"]').val());
		jobForm.find("[name='successOrFailure']").val($('select[name="successOrFailure"]').val());
		
		jobForm.attr("method","post");
		jobForm.attr("action","list");		
		
		jobForm.submit();
	}
</script>