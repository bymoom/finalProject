<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!-- Main content -->
	<div class="row justify-content-center">
		<div class="col-md-9" style="max-width:960px;">
				<div class="card-body pad">
				<h3>제안하기</h3>
					<div class ="card-tools" style="width:100%;text-align:right;">
						<button type="button" class="btn btn-outline-success btn-flat" id="proposeModify">수정완료</button>
						&nbsp;&nbsp;
						<button type="button" class="btn btn-outline-success btn-flat" id="cancelBtn" onclick="javascript:history.go(-1);">뒤로가기</button>
					</div>
					<form role="form" method="post" action="<%=request.getContextPath() %>/menu/proposeModify?pjtprp_num=${propose.pjtprp_num}" name="modifyForm">
						<div class="form-group">
							<input style="width:200px;text-align:center;display:none;" type="text" id="writer" readonly name="mem_name" class="form-control" value="${loginUser.mem_name }">
						</div>
						<div class="form-group">
							<input type="text" id="title" name='pjtprp_title' class="form-control" value="${propose.pjtprp_title }">
						</div>							
						
						<div class="form-group">
							<textarea class="textarea" name="pjtprp_contents" id="contents" rows="20" placeholder="1000자 내외로 작성하세요." style="display: none;">${propose.pjtprp_contents}</textarea>
						</div>
					</form>
				</div><!--end card-body  -->
				<div class="card-footer" style="display:none">
				
				</div><!--end card-footer  -->
		</div><!-- end col-md-12 -->
	</div><!-- end row -->
<!-- /.content -->

<%@ include file="../commons/summernote_js.jsp" %>
<script>

	var dataForm = $('form[name="modifyForm"]');
	$('#proposeModify').on('click',function(){
		dataForm.submit();
	});
	$('#registBtn').on('click',function(e){
		//alert("regist click");
		var form = document.registForm;
		
		if(form.title.value == ""){
			alert("제목은 필수입니다.");
			return;
		}
		
		if(form.contents.value.length > 1000){
			alert("글자수가 1000자를 초과할 수 없습니다.");
			return;
		}
		form.submit();
	});
	function registCancel(){
		var ask = confirm("취소하시면 작성한 내용이 사라집니다.\n취소 하시겠습니까?");
		if(ask){
			location.href="<%=request.getContextPath()%>/menu/propose";			
		}
	}
	

</script>