<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
 --%>
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

div#picturePreView{
	height:140px;
	width:110px;
	margin:0 auto;
	margin-top : 15px;
	float: left;
	border: 1px solid lightgray;
	background-image:url("<%=request.getContextPath()%>/mypage/info/picture/${member.mem_num}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

</style>

</head>
<body>

	<section class="content-header">
	<div class="container-fluid">
		<div class="row md-1">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>개인 정보 수정</h1>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</section>

				<h3>나의 정보</h3>
			
			<form role="form" action="modify" method="get" enctype="multipart/form-data">
				<div class="card-body">
					<div class="form-group">
						<label for="id">이메일 : </label>
						<label for="id">${member.mem_email}</label>
					</div>
					
					<div class="form-group">
						<label for="name">이름</label>
						<label for="">${member.mem_name }</label>
						
					</div>
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="pw">비밀번호</label> -->
<!-- 						<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="mem_pw" id="pw"> -->
<!-- 					</div> -->
					
<!-- 					<div class="form-group"> -->
<!-- 						<label for="pw2">비밀번호 확인</label> -->
<!-- 						<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="" id="pw2"> -->
<!-- 					</div> -->
					
					<div class="form-group">
						<label for="ptel">휴대폰번호</label>
						<input type="text" style="width:200px;" readonly class="form-control" id="ptel" placeholder="휴대폰번호 입력" name="mem_phone" onkeyup="inputPhoneNumber(this)" value="${member.mem_phone }">
					</div>
					
					<div class="form-group">
						<div role="picture">
							<div id="picturePreView"></div><br/><br/><br/><br/><br/><br/><br/>
<!-- 							<label for="picture"  class="btn btn-xs btn-info" style="width:110px;margin-bottom:2px;">사진변경</label> -->
							<input type="file" id="picture" name="mem_profile_img" style="display:none;"/>
							<input type="hidden" id="picture" name="old_picture" value="${member.mem_profile_img }"/>
						</div>
					</div>
					
						<button type="button" class="btn btn-primary" onclick="modify_go();">수정하기</button>
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

function modify_go(){
	self.location="modify?mem_email=${member.mem_email}";
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

function inputPhoneNumber(obj) {
    var number = obj.value.replace(/[^0-9]/g, "");
    var phone = "";

    if(number.length < 4) {
        return number;
    } else if(number.length < 7) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3);
    } else if(number.length < 11) {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 3);
        phone += "-";
        phone += number.substr(6);
    } else {
        phone += number.substr(0, 3);
        phone += "-";
        phone += number.substr(3, 4);
        phone += "-";
        phone += number.substr(7);
    }
    obj.value = phone;
}

/* 사진업로드 */
$('input[name="mem_profile_img"]').on('change',function(){
	
	//이미지 확장자 jpg 확인
	var fileFormat=
		this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	if(fileFormat!="JPG" && fileFormat!="JPEG"){
		alert("이미지는 jpg 형식만 가능합니다.");			
		return false;
	}
	
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return false;
	};	
	
	if (this.files && this.files[0]) {
		
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	//이미지 미리보기	        	
        	$('div#picturePreView')
        	.css({'background-image':'url('+e.target.result+')',
				  'background-position':'center',
				  'background-size':'cover',
				  'background-repeat':'no-repeat'
        		});
        }
        
        reader.readAsDataURL(this.files[0]);
	}
});	

var imageURL="picture/get.do?picture=${member.mem_profile_img}";
$('div#pictureView').css({'background-image':'url('+imageURL+')',
						  'background-position':'center',
						  'background-size':'cover',
						  'background-repeat':'no-repeat'
});

</script>
<!-- 

</html> -->