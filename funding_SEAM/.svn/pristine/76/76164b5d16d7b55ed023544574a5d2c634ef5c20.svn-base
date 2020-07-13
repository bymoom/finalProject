<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
<div class="container text-center">
               <h1>관심 프로젝트</h1>
                <hr>
    <button type="button" id="remove" class="btn btn-outline-success btn-flat mt-3 float-right">선택 삭제</button>
</div>            
		<div class="album py-5 bg-light">
		  <div class="container">
		      <div class="row contents text-center">

		      </div>
		  </div>
		</div>
                
    <form id="jobForm">
		  <input type='hidden' name="page" value="${pjtPageMaker.pjtCri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pjtPageMaker.pjtCri.perPageNum}"/>
		  <input type='hidden' name="categoryType" 
		         value="${pjtPageMaker.pjtCri.categoryType }" />
		  <input type='hidden' name="keyword" 
		         value="${pjtPageMaker.pjtCri.keyword }" />
	</form>
	<form style="display: hidden" method="POST" id="detailform">
	  <input type="hidden" name="pjt_num" value=""/>
	  <input type="hidden" name="mem_num" value="${loginUser.mem_num }"/>
	</form>
            
<%@ include file="./interestList_js.jsp" %>

<script>
function detailGo(type,pjt_num){
	var jobForm=$('#detailform');
	jobForm.find("[name='pjt_num']").val(pjt_num);	
	jobForm.attr("method","post");
	
	if(type=="1"){
		jobForm.attr("action","/project/detail");		
	}
	if(type=="2"){
		jobForm.attr("action","/project/loanDetail");		
	}
	
	jobForm.submit();
}
</script>
</body>
