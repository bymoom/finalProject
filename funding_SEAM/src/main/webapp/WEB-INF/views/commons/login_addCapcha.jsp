<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>

<style>
.login-box {
	margin: 0 auto;
	margin-top: 150px;
	margin-bottom: 150px;
}

</style>

<body "hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
  <h2>로그인</h2></div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">

      <form action="<%=request.getContextPath()%>/commons/login" method="post" id="loginForm">
        <div class="input-group mb-3">
          <input type="email" class="form-control" name="mem_email"
							placeholder="이메일형식의 아이디를 입력하세요." value="">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" name="mem_pw"
							placeholder="패스워드를 입력하세요.">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        
        <div style="text-align:center;">
	        <img src="https://openapi.naver.com/v1/captcha/ncaptcha.bin?key=${keys}" ><br><br>
        </div>
        
        <div class="input-group mb-3">
			<input type="text" class="form-control" id="capcha_keys" placeholder="Capcha 입력" name="">
			<input type="hidden" id="mem_email" value="${mem_email}" />
			<div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
		</div>
	
		<div class="form-group has-success has-feedback">
			<div>
				<button type="button" style="width:316px" class="btn btn-outline-success btn-flat" onclick="capcha_go()">제출</button>
			</div>
		</div>
		
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div>
          </div>
          <!-- /.col -->
        </div>
      <div class="social-auth-links text-center mb-3">
      	<button type="submit" class="btn btn-outline-success btn-block btn-flat" onkeyup="enterkey();">로그인</button>
      </div>
      </form>

      <!-- /.social-auth-links -->

      <p class="mb-1">
        <a href="#" onclick="OpenWindow('<%=request.getContextPath()%>/member/findId', '아이디 찾기', '500', '300')">아이디 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
        <a href="#" onclick="OpenWindow('<%=request.getContextPath()%>/member/findPw', '비밀번호 찾기', '500', '300')">패스워드 찾기</a>&nbsp;&nbsp;|&nbsp;&nbsp; 
        <a href="<%=request.getContextPath()%>/member/joinIntro">회원가입</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</div>

	
<script>

function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	   winleft = (screen.width - WinWidth) / 2;
	   wintop = (screen.height - WinHeight) / 2;
	   var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", height="+ WinHeight +", top="+ wintop +", left=" + winleft + ", resizable=yes, status=yes"  );
	    win.focus() ; 
}

function enterkey() {
    if (window.event.keyCode == 13) {
    	var loginForm=$('#loginForm');
    	loginForm.submit();
    }
}

function capcha_go() {
	var mem_email = $('input#mem_email').val();
	console.log(mem_email);
	var keys = $('input#capcha_keys').val();
	console.log(keys);
	
	$.ajax({
		url : "<%=request.getContextPath() %>/commons/capchaResultByAjax",
		data: {mem_email : mem_email, keys : keys},
		success : function(data) {
			if(data.result) {
				alert("인증 성공");
			}
			else {
				alert("인증 실패");
			}
		}
	})
}

</script>

