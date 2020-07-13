<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<body  class="hold-transition login-page text-center">
<br>
	<form class="container" role="form" action="findPw" method="post">
		<div class="form-group has-success has-feedback" for="">
			<label class="control-label" for="inputSuccess2">이메일 아이디:</label>
			<input type="email" class="form-control" id="id" placeholder="이메일을 입력하세요" name="mem_email">
			<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
		</div>
	
		<div class="form-group has-success has-feedback">
			<div>
				<button type="button" class="btn btn-outline-success btn-flat" onclick="FindPw();">비밀번호 찾기</button>
			</div>
		</div>
	</form>

<script>
function FindPw() {
	var mem_email = $('input[name="mem_email"]');
	
	if(!mem_email.val()) {
		alert("회원 이메일을 입력하세요");
		mem_email.focus();
		return;
	}
	var temp = mem_email.val();	//email
	
	$.ajax({
		url : "requestFindPw",
		type : "post",
		data : {
			"mem_email" : temp
		},
		success : function(data) {
			if(data.strResult == "") {
				//존재하는 이메일아이디 없음
 				console.log("fail : no have mem_email");
				alert("존재하는 아이디가 없음");
			}
			else {
				//이메일아이디 찾음
				console.log(data.strResult);
				var strRes = data.strResult;
				
				$.ajax({
					url : "sendPassword",
					type : "post",
					data : {
						"mem_email" : strRes
					},
					success : function(data) {
						console.log( strRes + "로 메일을 보냅니다.");
						window.location.href="<%=request.getContextPath()%>/member/findPw_ok?email=" + strRes;
					}
				});
				
			}
		},
		error : function(data) {
			alert("아이디 확인이 불가능합니다.")
		}
	});
}
</script>

</body>
