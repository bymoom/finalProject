<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<body>
<div class="container text-center">
<br>
               <h1>프로젝트 등록 현황</h1>
               <br>
</div> 
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-12">

    <section class="content">		
		<div class="row justify-content-md-center">
					<div class="col-7"></div>
					<div class="input-group col-5" style="width:350px;">						
						<input  class="form-control" type="text" style="width:200px; outline: 0; border-width: 0 0 2px;" name="keyword" onkeyup="enterkey();" placeholder="검색어를 입력하세요." value="${param.keyword }" />
						<span class="input-group-append">
							<button class="btn" type="button" onclick="searchList_go(1);" 
							data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					</div>
			<div class="card-body table-responsive p-0 mb-3 mt-3">
				<table class="table table-head-fixed text-center border-bottom" >					
					<tr style="font-size:0.85em;">
						<th style="width:5%;">no</th>
						<th style="width:5%;">분류</th>
						<th style="width:40%;">제 목</th>
						<th style="width:15%;">사업장명</th>
						<th style="width:15%;">목표금액</th>
						<th>등록일</th>
						<th style="width:10%;">진행상태</th>
					</tr>				
					<c:if test="${empty projectList }" >
						<tr>
							<td colspan="6">
								<strong>등록하신 프로젝트가 없습니다.</strong>
							</td>
						</tr>
					</c:if>						
					<c:forEach items="${projectList }" var="project">
						<tr style='font-size:0.8em;'>
							<td>${project.pjt_num }</td>
							<td>${project.pjt_type_code_val }</td>
							<td id="boardTitle" style="text-align:left;max-width: 100px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">
							
							<a onclick="detailGo(${project.pjt_num},'projectDetail')" style="cursor:pointer;">
								${project.pjt_title }
							</a>
							
							</td>
							<td>${project.comName }</td>
							<td>
							<fmt:formatNumber value="${project.pjt_cash }" pattern="#,###" />
							</td>
							<td><fmt:formatDate value="${project.pjt_moddate }" pattern="yyyy-MM-dd"/></td>
							<td>${project.pjt_state_code_val }</td>
						</tr>
					</c:forEach>
				</table>				
			</div>
				<%@ include file="/WEB-INF/views/mypage/project/pagination.jsp" %>			
			</div>
    			</section>
			</div>
		</div>
	</div>
	<form style="display: hidden" method="POST" id="detailform">
	  <input type="hidden" name="mem_num" value="${loginUser.mem_num }"/>
	  <input type="hidden" name="pjt_num" value=""/>
	</form>
<script>
function detailGo(pjt_num,url){
	var jobForm=$('#detailform');
	jobForm.find("[name='pjt_num']").val(pjt_num);	
	jobForm.attr("method","post");
	if(url){
		jobForm.attr("action",url);		
	}
	jobForm.submit();
}
</script>
	
</body>
