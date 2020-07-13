<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <html>
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
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet"> --%>

<style>
.register-box {
	display: flex;
	align-items : center;
	margin: 0 auto;
}

.register-card-body {
	margin: 0 auto;
	padding: 0 auto;
}

.col-sm-4 {
	text-align : center;
	padding-top:10px;
}

#card {
	width: 500px;
}

</style>

</head>
<body>

	<section class="content-header">
	<div class="container-fluid">
		<div class="row md-1">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>회원탈퇴</h1>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</section>

	<!-- 회원탈퇴  -->
<!-- 				<h3>회원탈퇴</h3> -->
			
			<form role="form" action="withdraw" method="post" >
				<div class="card-body">
					<div class="form-group">
						<label for="id">이메일 아이디 입력 : </label>
						<input type="email" class="form-control" placeholder="이메일 아이디 입력" name="mem_email" id="id">
					</div>
					
					<div class="form-group">
						<label for="pw">비밀번호 입력</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="mem_pw" id="pw">
					</div>

					<div class="form-group">
<!-- 						<label for="pw">UUID email로 발급하기 </label> -->
						<button type="button" class="btn btn-outline-success btn-flat" onclick="OpenWindow('issueUuidKey?mem_email=${member.mem_email }','','450','350');" name="" id="uuid_key" >인증키 전송 </button>
					</div>
					
					<div class="form-group">
						<label for="uuid_key">인증키 입력</label>
						<input type="text" class="form-control" placeholder="메일로 발급받은 인증키를 입력하세요" name="uuid_key" id="uuid_key">
					</div>

					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="ptel">휴대폰번호 입력</label> -->
<%-- 						<input type="text" class="form-control" id="ptel" placeholder="휴대폰번호 입력" name="mem_phone" onkeyup="inputPhoneNumber(this)" value="${member.mem_phone }"> --%>
<!-- 					</div> -->
					
					<div class="card-footer">
						<button type="button" class="btn btn-outline-danger btn-flat" onclick="SubmitMemberWithdraw('form');">회원탈퇴하기</button>
					</div>
				</div>
			</form>


<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
</body>	
</body>

<script>

window.onload = function() {
	console.log('${member.mem_email}');
}

//form submit
function SubmitMemberWithdraw(formRole){

// 	if(!checkUUID()) {
// 		return;
// 	}
	
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}


$("#id").blur(function() {
	  var email = $(this).val();

	  // if value is empty then exit
	  if( email == '' || email == 'undefined') return;

	  // valid check
	  if(! email_check(email) ) {
// 	  	$("#result-check").text('Not valid email.');
		alert("올바르지 않은 이메일형식입니다.")
	    $(this).focus();
	    return false;
	  }
	  else {
// 	  	$("#result-check").text('Email address test OK.');
		return true;
	  }
	
})

// email check function
function email_check( email ) {    
    var regex=/([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    return (email != '' && email != 'undefined' && regex.test(email)); 
}

//새로운 Window창을 Open할 경우 사용되는 함수 ( arg : 주소 , 창타이틀 , 넓이 , 길이 )
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr , WinTitle , "scrollbars=yes,width="+ WinWidth +", " 
							+"height="+ WinHeight +", top="+ wintop +", left=" 
							+ winleft +", resizable=yes, status=yes"  );
  win.focus() ; 
}

</script>

<!-- 
</html> -->