<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Content Wrapper. Contains page content -->
<div class="row justify-content-center">
	<div class="col-md-9" style="max-width:960px;">
		<h4 style="padding:10px;">${param.qna_num }번 질문글 답변 등록</h4>
		<hr>
		<div class ="card-tools" style="width:100%;text-align:right;">
			<button type="button" class="btn btn-outline-success btn-flat" id="registBtn">등 록</button>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<button type="button" class="btn btn-outline-success btn-flat" id="cancelBtn">취 소</button>
		</div>
	<!--end card-header  -->
    <!-- Main content -->
			<div class="col-md-9" style="max-width:960px;">
				<!-- <div class="card card-outline card-info">
					
					<div class="card-body pad"> -->
							<form role="form" method="post" action="registCmts" name="registCmts">
						
						  	<input type='hidden' name="qna_cmts_num" value ="${qna.qna_num}">
						  	<input type='hidden' name="qna_num" value ="0">
						  <!-- 	qna_num is whatever but original글 바로 아래로 RE: ~~ 나오게 -->
						  
							<div class="form-group">
								<label for="title">제 목</label> 
								<input type="text" id="title" value=" └ RE: ${qna.qna_title} " readonly name="qna_title" class="form-control">
							</div>							
							<div class="form-group">
								<label for="writer">작성자</label> 
								<input type='hidden' name="mem_num" value ="${loginUser.mem_num}">
								<input type="text" id="writer" value="${loginUser.mem_name} " readonly name="mem_name" class="form-control" >
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="textarea" name="qna_contents" id="contents"> ${qna.qna_contents} 
								<br><br>
								<div class="p-2 mb-1 bg-success text-white" >
									<input type="text" value="답 변" readonly="readonly" style="background-color: #28a745;color: white;border: none;"></input>
								</div>
								<br>
								 </textarea>
							</div>
							<input type='hidden' name="qna_secret" value ="${qna.qna_secret}">
						<!-- 	original글이 일반글이면 1, 비밀글이면 0 따라가게 -->
							<c:if test="${qna.qna_secret eq 0 }">
								<input type="hidden" name="qna_pwd" value="${qna.qna_pwd }">
							</c:if>
							<!-- 원글이 비밀글(비번가지고있으면) 원글 비번 똑같이 보내버려~~ -->
						
						</form>
					</div><!--end card-body  -->
					<div class="card-footer" style="display:none">
					
					</div><!--end card-footer  -->
				</div><!-- end card -->				
   <%@ include file="../commons/summernote_js.jsp" %>
			</div><!-- end col-md-12 -->
  
<script>
	$('#registBtn').on('click',function(e){
		//alert("regist click"); 
		var form=document.registCmts;
		
		form.submit();
	
 		var mem_email = "ahffk933@naver.com";                             // $("input[id='mem_email']").val();
		var title = "문의 해주신 (" +$("input[id='title']").val()+") 글의 대한 답글이 등록되었습니다 ";
		var con = $("textarea[id='contents']").val();
		var content = "안녕하세요 펀심딩입니다 <br> 문의해주셔서 감사합니다 <br>질문내용과 답변내용 : <br>" + con + "<br>더 자세한 내용은  <a href='http://localhost/qna/detail?qna_num=${qna.qna_num }'>www.funseamding.qna/detail.com</a>를 참고해주세요<br> 좋은하루 되세요!";
		//http://localhost/qna/detail?qna_num=41
		
		if (!confirm("${qna.mem_name}님에게 메일를 발송하겠습니까?")) return false;
		
		$.ajax({
			url : '<%= request.getContextPath() %>/sendEmail',
			type : 'post',
			data : {
				'mem_email' : mem_email,
				'title' : title,
				'content' : content
			},
			dataType : 'text',
			success : function(data){
				alert('메일이 발송되었습니다.');
				window.close();
			},
			error : function(error){
				alert('서버 오류로 메일 발송을 실패했습니다.');
			}
		});
	});
	
	$('#cancelBtn').on('click',function(e){
		//alert("cancel btn click");
		history.go(-1);
	});
</script>



</body>


