<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Page Content Begins -->
<div class="row justify-content-center">
	<!-- 상단 우측버튼 -->
	<div class="col-md-9" style="max-width:960px;">
		<h3 style="padding:10px;">글 수정</h3>
		<hr>
		<div class="card-tools" style="width:100%;text-align:right;">
			<button type="button" id="modifyBtn" class="btn btn-outline-success btn-flat">수정 완료</button>
			<button type="button" class="btn btn-outline-success btn-flat" onclick="javascript:history.go(-1);">뒤로 가기</button>
		</div>
		<br/>
		<form role="form" name="modifyForm" class="form-horizontal" method="POST" action="<%= request.getContextPath() %>/board/free/modify">
			<input type="hidden" name="free_num" value="${freeBoard.free_num}" />
			<div class="form-group">
			<input id="title" name="free_title" class="form-control" type="text" value="${freeBoard.free_title }"/>
			</div>  
			<div class="form-group">
				<textarea rows="20" id="contents" name="free_contents" class="form-control">${freeBoard.free_contents }</textarea>			
			</div>
		</form>
	</div>
<%@ include file="../../commons/summernote_js.jsp" %>
</div>

<script>
	 $('#modifyBtn').on('click',function(e){
		var form = document.modifyForm;
		
		if(form.title.value == ""){
			alert("제목은 필수입니다.");
			return;
		}

		if(form.contents.value == ""){
			alert("내용을 입력해주세요.");
			return;
		}
		
		if(form.title.value.length > 150){
			alert("제목은 150자 이상을 초과할 수 없습니다.");
			return;
		}
		
		form.submit();
	});
</script>
