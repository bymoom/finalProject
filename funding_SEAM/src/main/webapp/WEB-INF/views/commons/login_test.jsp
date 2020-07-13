<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>소상공인 크라우드 펀딩 시스템</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/commons/css/util.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/commons/css/main.css" />
</head>

<body  class="login-layout light-login">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<div class="login100-pic js-tilt" data-tilt>
					<img src="<%=request.getContextPath()%>/resources/images/loginLogo.png" alt="IMG">
				</div>

				<form class="login100-form validate-form" action="<%=request.getContextPath() %>/commons/login"	method="post" >
					<span class="login100-form-title">
						<h1>로그인</h1>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is required: ex@abc.xyz">
						<input class="input100" type="text" name="mem_email" placeholder="Email">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Password is required">
						<input class="input100" type="password" name="mem_pw" placeholder="Password">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button type="submit" class="login100-form-btn">
							로그인
						</button>
					</div>

					<div class="text-center p-t-12">
						<span class="txt1">
						</span>
						<a class="txt2" href="#">
							아이디∙비밀번호 찾기
						</a>
					</div>

					<div class="text-center p-t-136">
						<a class="txt2" href="#">
							회원가입
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>