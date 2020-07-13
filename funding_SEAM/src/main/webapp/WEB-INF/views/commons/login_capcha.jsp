<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Font Awesome -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- icheck bootstrap -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/icheck-bootstrap/icheck-bootstrap.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">

<script>
// 	alert("아이디 또는 패스워드가 일치하지 않습니다.");
<%-- 	window.location.href="<%=request.getContextPath()%>/commons/loginForm"; --%>
	
// 	var str = "${keys}";
// 	console.log(str);
	
// 	window.location.href="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${keys}";
	
	alert("비밀번호를 5회 이상 틀렸으므로 Capcha 인증페이지로 이동합니다");

	console.log("'https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${keys}'");
</script>

<style>
.login-box {
	margin: 0 auto;
	margin-top: 150px;
}

</style>

<body>

	<div class="login-box">

	<form class="container" role="form" action="capchaResult" method="post" style="">
<%-- 		<a href="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${keys}" onclick="window.open(this.href,'popup'); return false;">Capcha보기</a> --%>
		
		<img style="width:200px;height:100px;" src="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${keys}" ><br><br>
	
<!-- 		<div class="form-group has-success has-feedback" for=""> -->
		<div style="width:200px" class="input-group mb-3">
			<input type="text" class="form-control" id="id" placeholder="Capcha 입력" name="capcha_keys">
			<input type="hidden" name="mem_email" value="${mem_email}" />
		</div>
	
		<div class="form-group has-success has-feedback">
			<div>
				<button type="submit" style="width:200px" class="btn btn-outline-success btn-flat">제출</button>
			</div>
		</div>
	</form>
	
	</div>
	
</script>	
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
	
</body>
</html>