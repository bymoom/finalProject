<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<head>
<title>공지사항&nbsp;수정 페이지</title>
<style type="text/css" id="fontFamilyStyleSheet">
body { 
	font-family: 'Malgun Gothic', sans-serif !important; 
}
.fileDrop{
	width:90%;
	height:100px;
	border:1px dotted gray;
	margin:auto;
}

</style>
</head>
<body>
<!-- Content Wrapper. Contains page content -->
   
  
    <!-- Main content -->
    <section class="content container-fluid">
		<div class="row justify-content-center">
			<div class="col-md-9" style="max-width:960px;">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h3 class="card-title p-1">수정</h3>
						<div class ="card-tools">
							<button type="button" class="btn btn-primary" id="modifyBtn">업데이트</button>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<button type="button" class="btn btn-warning" id="cancelBtn">취 소</button>
						</div>
					</div><!--end card-header  -->
					<div class="card-body pad">
						<form role="form" method="post" action="modify" name="modify">
						
						  	<input type='hidden' name="notice_num" value ="${notice.notice_num}">
						
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value="${notice.notice_title} " name="notice_title" class="form-control" placeholder="제목을 쓰세요">
							</div>							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type="text" id="writer" value="${notice.mem_num} " readonly name="mem_num" class="form-control" >
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="notice_contents" id="contents" >${notice.notice_contents}</textarea>
							</div>
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
			</div><!-- end col-md-12 -->
		</div><!-- end row -->
    </section>
    <!-- /.content -->
  
 <%@ include file="../../commons/summernote_js.jsp" %>
  
  
<script>
	$('#modifyBtn').on('click',function(e){
		//alert('modify clicked');
		var title=$('input[name="notice_title"]');
		if(title.value==""){
			alert("제목은 필수입니다.");
			return;
		}
		
		var form=document.modify;
		form.submit();
	});
	
	$('#cancelBtn').on('click',function(e){
		history.go(-1);
	});
</script>

</body>


