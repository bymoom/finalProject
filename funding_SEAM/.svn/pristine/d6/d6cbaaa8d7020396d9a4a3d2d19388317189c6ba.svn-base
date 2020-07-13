<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<head>
<style>
	.js-switch{
    color             :'#64bd63',
    jackColor         :'#fff'
    className         :'switchery',
    disabled          :false,
    disabledOpacity   : 0.5,
    speed             :'0.4s',
    size              :'default'
	}


</style>
</head>


<div class="row justify-content-center">
<div class="col-md-9" style="max-width:960px;">
		<h3 style="padding:10px;">글쓰기</h3>
<div class="card-body pad">
	<form role="form" method="post" action="regist" name="regist" id="regist">
	<div class="form-inline col-md-12">
		<div class="form-group col-9" style="padding-left: 0px;">
			<label for="title">제 목</label> 
			<input type="text" id="title" name='qna_title' class="form-control" placeholder="제목을 입력하세요" style="width: 600px;">
		</div>
		<div class="form-group col-3" style="padding-left: 0px;">
			<label for="writer">작성자</label>
			 <input type="hidden" id="writer_num" name="mem_num" class="form-control"
				value="${loginUser.mem_num }">
			
			 <input type="text" id="writer" readonly name="mem_name" class="form-control"
				value="${loginUser.mem_name }">
		</div>
		</div>
		<br>
		<div class="form-group col-md-12">
			<label for="content">내 용</label>
			<textarea class="textarea" name="qna_contents" id="contents" style="display: none;"></textarea>
		</div>
	<div id="aa" class="col-sm-6">
		<label for="secret">공개/비공개</label> 
		<input type="checkbox" class="js-switch" /> &nbsp;&nbsp;
		<!-- <input style="display: none;" type="password" class="form-control col-4" name="qna_pwd" id="qna_pwd" placeholder="패스워드를 입력하세요."> -->
	</div>
	</form>
	
	<div class ="card-tools col-sm-12 col-3" style="width:100%;text-align:right;">
			<button type="button" class="btn btn-outline-success btn-flat" id="registBtn">등 록</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-outline-success btn-flat" id="cancelBtn">취 소</button>
		</div>
</div>
<!--end card-body  -->
</div>
</div>

<div class="card-footer" style="display:none"></div>

<%@ include file="../commons/summernote_js.jsp" %>

<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/switchery-master/dist/switchery.css" />
<script src="<%=request.getContextPath()%>/resources/switchery-master/dist/switchery.js"></script>


<script>
$(function(){
	$('#qna_pwd').hide();
});
	$('#registBtn').on('click',function(){
		document.regist.submit();
		

	});
	$('#cancelBtn').on('click', function(e) {
		alert("작성중인 문서는 저장되지 않습니다");
		window.history.go(-1);
	});
	
//	var elem = document.querySelector('.js-switch');
//	var init =new Switchery(elem);
$('.js-switch').on('change',function(){
	var pwd=$('<input>',{
		'type':'password',
		'id':'password',
		'name':'qna_pwd',
		'placeholder':'비밀번호를 입력해주세요.'
	});
	
	if($(':checkbox[class="js-switch"]').is(':checked') == true){
		$("#aa").append(pwd);		
	}else{
		$('input[name="qna_pwd"]').remove();
	}
//	alert($('#password').val());
});
	

</script>

