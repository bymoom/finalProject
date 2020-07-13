<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
<div class="container text-center">
<br>
               <h1>승인된 프로젝트 진행 현황</h1>
               <br>
                <hr>
</div>             
                
		<div class="album py-5 bg-light">
		  <div class="container">
		      <div class="row contents text-center">
				<c:if test="${empty projectList }" >
							<strong>해당 내용이 없습니다.</strong>
				</c:if>	
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
	</form>
            
<%@ include file="./list_js.jsp" %>
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
