<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- Main content -->
<br><br><br>
<section class="content container-fluid">
	<div class="row justify-content-center">
		<div class="col-md-9" style="max-width:960px;">
					<h3 >FAQ 수정</h3>
					
				<div class="card-body pad">
					<form role="form" method="post" action="modify" name="modifyForm" id="modifyForm">
						<input type="hidden" name="faq_num" value="${faq.faq_num}">
						<div class="form-group">
							<label for="faq_title">질문 제목</label> 
							<input type="text" id="faq_title" name='faq_title' class="form-control" value="${faq.faq_title }">
						</div>							
						<div class="form-group">
							<label for="faq_contents">내용</label> 
							<textarea class="form-control" id="faq_contents" name="faq_contents" style="height:300px;">${faq.faq_contents }</textarea>
						</div>							
								
					</form>
					<br>
					<div style="width:100%;text-align:center;">
						<button type="button" class="btn btn-outline-success btn-flat" id="modifyBtn">완 료</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-success btn-flat" id="cancelBtn">취 소</button>
					</div>
				</div><!--end card-body  -->
				<div class="card-footer" style="display:none">
				
				</div><!--end card-footer  -->
		</div><!-- end col-md-12 -->
	</div><!-- end row -->
</section>
<!-- /.content -->


<script>
	  $('#modifyBtn').on('click',function(e){
		//alert("regist click");
		
		var form = $('#modifyForm');
		
		if($('#faq_title') == ""){
			alert("제목은 필수입니다.");
			return false;
		}
		
		if($('#faq_contents') == ""){
			alert("내용은 필수입니다.");
			return false;
		}

		form.submit();
	}); 
	
	
	$('#cancelBtn').on('click', function(e){
		//alert("cancel btn click");
		
		window.close();
	});
</script>
