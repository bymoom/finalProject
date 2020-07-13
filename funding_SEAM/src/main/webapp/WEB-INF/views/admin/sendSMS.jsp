<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
	<title>문자 발송</title>
</head>

<div class="col-md-9">
  <div class="card card-primary card-outline">
    <div class="card-header">
      <h3 class="card-title">문자 발송</h3>
    </div>
    <!-- /.card-header -->
    <div class="card-body">
      	<form role="form" method="post" action="sendSMS" name="sendSMSForm">
	      <div class="form-group">
	      	<table class="table text-center">
	      		<tr>
	      			<th>이 름 : </th>
	      			<td><input class="form-control" value="${mem_name }" readonly></td>
	      		</tr>
	      		<tr>
	      			<th>전화번호 : </th>
	      			<td><input id="mem_phone" class="form-control" value="${mem_phone }" readonly></td>
	      		</tr>
	      		<tr>
	      			<th>내용 : </th>
	      			<td><textarea id="content" class="form-control" style="height: 400px;"></textarea></td>
	      		</tr>
	      	</table>
	      </div>
	     </form>
      </div>
    <!-- /.card-body -->
    <div class="card-footer">
      <div class="float-right">
        <button type="button" class="btn btn-primary" onclick="sendSMS();"><i class="far fa-envelope"></i>보내기</button>
      </div>
      <button type="button" class="btn btn-default" onclick="javascript:window.close();"><i class="fas fa-times"></i>취소</button>
    </div>
    <!-- /.card-footer -->
  </div>
  <!-- /.card -->
</div>

<script>
	function sendSMS(){
		var mem_phone = $("input[id='mem_phone']").val();
		var content = $("textarea[id='content']").val();
		
		if (!confirm("${mem_name}님에게 문자를 발송하겠습니까?")) return false;
		
		$.ajax({
			url : '<%= request.getContextPath() %>/sendSMS',
			type : 'post',
			data : {
				'mem_phone' : mem_phone,
				'content' : content
			},
			dataType : 'text',
			success : function(data){
				alert('문자가 발송되었습니다.');
				window.close();
			},
			error : function(error){
				alert('서버 오류로 문자 발송을 실패했습니다.');
			}
		});
	}
	
	
</script>