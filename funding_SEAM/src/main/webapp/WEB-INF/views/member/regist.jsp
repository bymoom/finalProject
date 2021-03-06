<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- <style>

div#picturePreView{
	height:140px;
	width:110px;
	margin:3px auto;	  		
	border : 1px solid lightgray;
	float: left;  		
}
</style> -->

<body>

	<!-- <section class="content-header">
	<div class="container-fluid">
		<div class="row md-1">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h1>일반회원가입</h1>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
	</section> -->
	<div class="container">
		<div class="text-center">
				<h3>회원가입</h3>
		</div>
		<br>
			
			<form role="form" action="regist" method="post" enctype="multipart/form-data">
				<div class="card-body">
				
						<div class="form-group row justify-content-md-center pb-1">
							<div class="col-2">
								<div class="input-group picture">
									<div class="col-2">
										<img class="img-circle img-bordered-md mb-3" src="/resources/images/profile-picture.png" 
										alt="user image" style="width: 100px; height: 100px;object-fit:cover; object-position:center; object-repeat:no-repeat;" id="picturePreView">
										<label for="picture"  class="btn btn-outline-success btn-flat" style="width:110px;margin-bottom:2px;">사진등록</label>
										<input type="file" id="picture" name="mem_profile_img" style="display:none;"/>
									</div>
									<!-- <div id="picturePreView img-circle img-bordered-md"></div> -->
								</div>
							</div>
							<div class="col-12 text-center">
										<span style="font-size:0.8em; color:red;">※ 프로필 사진은 1MB이하 jpg파일만 업로드 가능합니다.</span>
							</div>
						</div>
				
				<hr>
				<div class="mt-3 mb-3 text-center">
					<h3>회원 정보</h3>
				</div>
						<div class="form-group row pb-1">
							<label for="id" class="col-sm-2 col-form-label">이메일</label>
							<div class="col-8">
								<div class="input-group">
									<input type="email" class="form-control" id="id" placeholder="이메일을 입력하세요" name="mem_email" value="${mem_email }" readonly />
<!-- 									<button type="button" id="btnid" class="btn btn-outline-success btn-flat" onclick="checkId()" >중복검사</button> -->
								</div>
							</div>
						</div>
						
						<div class="form-group row pb-1">
							<label for="name" class="col-sm-2 col-form-label">이름</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="이름을 입력하세요" name="mem_name" id="name">
								</div>
							</div>
						</div>
						
						<div class="form-group row pb-1">
							<label for="pw" class="col-sm-2 col-form-label">비밀번호</label>
							<div class="col-4">
								<div class="input-group">
									<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="mem_pw" id="pw">
								</div>
							</div>
						</div>
					
						<div class="form-group row pb-1">
							<label for="pw2" class="col-sm-2 col-form-label">비밀번호 확인</label>
							<div class="col-4">
								<div class="input-group">
									<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="" id="pw2">
								</div>
							</div>
						</div>
					
						<div class="form-group row pb-1">
							<label for="ptel" class="col-sm-2 col-form-label">휴대폰번호 입력</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" id="ptel" placeholder="휴대폰번호 입력" name="mem_phone" onkeyup="inputPhoneNumber(this)">
								</div>
							</div>
						</div>
						

						
						
<!-- 					
					<div class="form-group">
						<div role="picture">
							<div id="picturePreView"></div><br/><br/><br/><br/><br/><br/>
							<label for="picture"  class="btn btn-outline-success btn-flat" style="width:110px;margin-bottom:2px;">사진등록</label>
							<input type="file" id="picture" name="mem_profile_img" style="display:none;"/>
						</div> 
					</div> -->
					<div class="row justify-content-md-center">
						<button type="button" class="btn btn-outline-success btn-flat" onclick="SubmitMemberRegist('form');">가입하기</button>
						<button type="button" class="btn btn-outline-success btn-flat" onclick="javascript:history.go(-1)">뒤로가기</button>
					</div>
				</div>
			</form>
	</div>
</body>

<script>
//form submit
function SubmitMemberRegist(formRole){
//	var uploadCheck = $('input[name="checkUpload"]').val();
//	if(!(uploadCheck>0)){
//		alert("사진 업로드는 필수입니다.");	
//		//$('input[name="pictureFile"]').click();
//		return;
//	}

	if(!checkPw()) {
		return;
	}
	
	if(registInputCheck() == false) {
		return;
	}

	var form = $('form[role="'+formRole+'"]');


	form.submit();

}

function checkId() {
	var id = $('input[name="mem_email"]');
	if(!id.val()){
		alert("이메일주소를 입력하세요.")
		id.focus();
		return;
	}
	
	var bRes = idFormCheck();
	
	if(!bRes)
		return;
	
	$.ajax({
		url:"checkId",
		type:"get",
		data:{"id" : id.val()},
		success:function(data){
			if(data.result){
				alert("사용가능합니다.");					
			}else{
				alert("중복된 아이디입니다.");
			}
		},
		error:function(data){
			alert("중복 확인이 불가합니다.\n직원등록을 취소합니다.");
			window.close();
		}
	});
}

function checkPw() {

	var pwd1 = $("#pw").val();
	var pwd2 = $("#pw2").val();
	
	
	if(pwd1 == '' || pwd2 == ''){
		alert("비밀번호를 입력하세요.")
		pwd1.focus();
		return false;
	}
	
	if(pwd1 != '' || pwd2 != '') {
		if(pwd1 == pwd2) {
			return true;
		}
		else {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
	}
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

function idFormCheck() {
	  var email = $("#id").val();

	  // if value is empty then exit
	  if( email == '' || email == 'undefined') return;

	  // valid check
	  if(! email_check(email) ) {
// 	  	$("#result-check").text('Not valid email.');
		alert("올바르지 않은 이메일형식입니다.");
	    $(this).focus();
	    return false;
	  }
	  else {
// 	  	$("#result-check").text('Email address test OK.');
		console.log("올바른 이메일 형식");
		return true;
	  }
}

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

	var fileFormat = this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
	//이미지 확장자 jpg 확인
	if(fileFormat!="JPG" && fileFormat!="JPEG"){
		alert("이미지는 jpg 형식만 가능합니다.");
		return;
	} 
	
	//이미지 파일 용량 체크
	if(this.files[0].size>1024*1024*1){
		alert("사진 용량은 1MB 이하만 가능합니다.");
		return;
	};	


	if (this.files && this.files[0]) {
		
        var reader = new FileReader();
        
        reader.onload = function (e) {
        	//이미지 미리보기	        	
        	$('img#picturePreView')
        	.attr({'src':e.target.result/* ,
				  'background-position':'center',
				  'background-size':'cover',
				  'background-repeat':'no-repeat' */
        		});
        }
        
        reader.readAsDataURL(this.files[0]);
	}
	

});

function registInputCheck() {
	var name = $("#name").val();
	var ptel = $("#ptel").val();
	
	if(name == ''){
		alert("이름을 입력하세요.")
		$("#name").focus();
		return false;
	}

	if(ptel == ''){
		alert("휴대폰번호를 입력하세요.")
		$("#name").focus();
		return false;
	}

	return true;
}

	

</script>


</html>