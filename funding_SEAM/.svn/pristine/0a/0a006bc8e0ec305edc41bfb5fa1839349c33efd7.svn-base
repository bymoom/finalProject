<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- Main content -->
<section class="content container-fluid">
	<div class="row justify-content-center">
		<div class="col-md-9" style="max-width:960px;">
				<div class="card-header">
					<h3>배너등록</h3>
					<div class ="card-tools">
						<button type="button" class="btn btn-outline-success btn-flat" id="registBtn">등 록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-success btn-flat" id="cancelBtn">취 소</button>
					</div>
				</div><!--end card-header  -->
				<div class="card-body pad">
					<form role="form" method="post" action="regist" name="registForm" id="registForm" enctype="multipart/form-data">
						<div class="form-group">
							<label for="b_name">배너 제목</label> 
							<input type="text" id="b_name" name='b_name' class="form-control" placeholder="제목을 쓰세요">
						</div>							
						<div class="form-group">
							<label for="b_url">URL</label> 
							<input type="text" id="b_url" name='b_url' class="form-control" value="https://">
						</div>							
						<div class="form-group">
							<label for="b_type">배너 유형</label> 
							<select style="width:300px;" id="b_type" name='b_type' class="form-control" placeholder="메인">
								<option>메인</option>
								<option>파트너</option>
							</select>
						</div>							
						
							<label for="b_uploadFile">이미지 선택</label> 
							<input type="file" id="b_uploadFile" name="b_uploadFile" class="form-control">
						
					</form>
				</div><!--end card-body  -->
				<div class="card-footer" style="display:none">
				
				</div><!--end card-footer  -->
		</div><!-- end col-md-12 -->
	</div><!-- end row -->
</section>
<!-- /.content -->


<script>
	  $('#registBtn').on('click',function(e){
		//alert("regist click");
		
		var form = $('#registForm');
		
		if($('#b_name') == ""){
			alert("제목은 필수입니다.");
			return false;
		}
		if($('#b_url') == ""){
			alert('url은 필수입니다.');
			return false;
		}

		form.submit();
	}); 
	
	
	$('#cancelBtn').on('click', function(e){
		//alert("cancel btn click");
		window.opener.location.href='list';
		window.close();
	});
</script>
