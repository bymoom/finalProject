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
          <input type="email" class="form-control" name="mem_email" id="userId"
							placeholder="이메일형식의 아이디를 입력하세요." value="" >
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
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="idSaveCheck">
              <label for="remember">
                아이디 저장
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
<%-- 
	<div class="login-box">
		<div class="login-logo">
<!-- 			<a href="#"><b>관리자 로그인</b></a> -->
		</div>
		<!-- /.login-logo -->
		<div class="card">
			<div class="card-body login-card-body">
<!-- 				<p class="login-box-msg">Sign in to start your session</p> -->
				<h1 style="text-align: center">로그인</h1>
				</br>

				<form action="<%=request.getContextPath()%>/commons/login" method="post">
					<div class="form-group has-feedback">
						<input type="email" class="form-control" name="mem_email"
							placeholder="이메일형식의 아이디를 입력하세요." value=""> <span
							class="glyphicon glyphicon-envelope form-control-feedback"></span>
					</div>
					<div class="form-group has-feedback">
						<input type="password" class="form-control" name="mem_pw"
							placeholder="패스워드를 입력하세요."> <span
							class="glyphicon glyphicon-lock form-control-feedback"></span>
					</div>
					<div class="row">
						<div class="col-sm-8">
<!-- 							<div class="checkbox icheck"> -->
<!-- 								<label> <input type="checkbox"> Remember Me -->
<!-- 								</label> -->
<!-- 							</div> -->
						</div>
						<!-- /.col -->
						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary btn-block btn-flat">로그인</button>
						</div>
						<!-- /.col -->
					</div>
				</form>
				
				<br/>
				<div class="row">
					<div class="col-sm-4">
						<a href="#" onclick="OpenWindow('<%=request.getContextPath()%>/member/findId', '아이디 찾기', '500', '600')" style="font-weight: bold;">아이디 찾기</a><br>
					</div>
					<div class="col-sm-4">
						<a href="#" onclick="OpenWindow('<%=request.getContextPath()%>/member/findPw', '비밀번호 찾기', '500', '600')" style="font-weight: bold;  float: center;">패스워드 찾기</a><br>
					</div>
					<div class="col-sm-4">
						<a href="<%=request.getContextPath()%>/member/joinIntro" style="font-weight: bold; float: right;">회원가입</a><br>
					</div>
				</div>
				
			</div>
			<!-- /.login-box-body -->
		</div>
	</div> --%>
	
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
	
	/* 아이디 저장 기능 */
	$(document).ready(function(){
		 
	    // 저장된 쿠키값을 가져와서 ID 칸에 넣어준다. 없으면 공백으로 들어감.
	    var key = getCookie("key");
	    $("#userId").val(key); 
	     
	    if($("#userId").val() != ""){ // 그 전에 ID를 저장해서 처음 페이지 로딩 시, 입력 칸에 저장된 ID가 표시된 상태라면,
	        $("#idSaveCheck").attr("checked", true); // ID 저장하기를 체크 상태로 두기.
	    }
	     
	    $("#idSaveCheck").change(function(){ // 체크박스에 변화가 있다면,
	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기 체크했을 때,
	            setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
	        }else{ // ID 저장하기 체크 해제 시,
	            deleteCookie("key");
	        }
	    });
	     
	    // ID 저장하기를 체크한 상태에서 ID를 입력하는 경우, 이럴 때도 쿠키 저장.
	    $("#userId").keyup(function(){ // ID 입력 칸에 ID를 입력할 때,
	        if($("#idSaveCheck").is(":checked")){ // ID 저장하기를 체크한 상태라면,
	            setCookie("key", $("#userId").val(), 7); // 7일 동안 쿠키 보관
	        }
	    });
	});
	 
	function setCookie(cookieName, value, exdays){
	    var exdate = new Date();
	    exdate.setDate(exdate.getDate() + exdays);
	    var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
	    document.cookie = cookieName + "=" + cookieValue;
	}
	 
	function deleteCookie(cookieName){
	    var expireDate = new Date();
	    expireDate.setDate(expireDate.getDate() - 1);
	    document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}
	 
	function getCookie(cookieName) {
	    cookieName = cookieName + '=';
	    var cookieData = document.cookie;
	    var start = cookieData.indexOf(cookieName);
	    var cookieValue = '';
	    if(start != -1){
	        start += cookieName.length;
	        var end = cookieData.indexOf(';', start);
	        if(end == -1)end = cookieData.length;
	        cookieValue = cookieData.substring(start, end);
	    }
	    return unescape(cookieValue);
	}
	
	</script>

