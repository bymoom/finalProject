<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
  <%--   
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
	background-image:url("<%=request.getContextPath()%>/mypage/info/picture/${comMember.mem_num}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

</style>

<title>개인 정보 수정</title>
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

				<h3 >나의 정보</h3>
			
			<form role="form" action="modifyCom" method="post" enctype="multipart/form-data">
				<div class="card-body">
					<div class="form-group">
						<label for="id">이메일 : </label>
						<label for="id">${comMember.mem_email }</label>
						<input type="hidden" class="form-control" placeholder="" name="mem_email" id="" value="${comMember.mem_email }">
					</div>
					
					<div class="form-group">
						<label for="">이름 : </label>
						<label for="">${comMember.mem_name }</label>
						<input type="hidden" class="form-control" placeholder="" name="mem_name" id="" value="${comMember.mem_name }">
					</div>
					
					<div class="form-group">
						<label for="pw">비밀번호</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="mem_pw" id="pw">
					</div>
					
					<div class="form-group">
						<label for="pw2">비밀번호 확인</label>
						<input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="" id="pw2">
					</div>
					
					<div class="form-group">
						<label for="ptel">휴대폰번호 : </label>
						<input type="text" class="form-control" id="ptel" placeholder="휴대폰번호 입력" name="mem_phone" onkeyup="inputPhoneNumber(this)" value="${comMember.mem_phone }">
					</div>
					
					<div class="form-group">
						<label class="control-label" for="">사업장명:</label>
						<input type="text" class="form-control" id="" placeholder="사업장명 입력" name="com_bsns_name" value=${comMember.com_bsns_name }>
					</div>

					<div class="form-group">
						<label class="control-label" for="">대표자명:</label>
						<input type="text" class="form-control" id=""
							placeholder="대표자명 입력" name="com_bsns_rep_name" value="${comMember.com_bsns_rep_name }">
					</div>

					<div class="form-group">
						<label class="control-label" for="">사업자 등록번호:</label>
						<input type="text" class="form-control" id="ptel"
							placeholder="사업자 등록번호 입력" name="com_bsns_number" value="${comMember.com_bsns_number }">
					</div>

					<div class="form-group">
						<label class="control-label" for="">대표전화번호:</label>
						<input type="text" class="form-control" id="ptel"
							placeholder="대표전화번호 입력" name="com_bsns_phone" value="${comMember.com_bsns_phone }">
					</div>
					
					<div class="col-sm-12 g_value" data-role="attach">
						<div class="col-sm-6" style="padding:2px 1px;">
							<label for="com_bsns_reg_license" class="label" style="width:100%;">사업자등록증</label>
							<input type="file" id="com_bsns_reg_license" name="com_bsns_reg_license" style="display:none;"/>
							<input type="hidden" name="old_com_bsns_reg_license" value="${comMember.com_bsns_reg_license}" />
							<div class="input-group input-group-sm" data-role="attach">
								<div class="input-group-btn">
                  					<button type="button" class="btn btn-outline-success btn-flat" name="com_bsns_reg_license">변경</button>
                				</div>
								<input type="text" class="form-control" name="view_com_bsns_reg_license"  placeholder="파일을 선택하세요." value="${comMember.com_bsns_reg_license.split('\\$\\$')[1]}" >
								<span class="input-group-btn">
				                      <button type="button" data-role="com_bsns_reg_license" class="btn btn-danger btn-flat">X</button>
				                </span>	
							</div>
							
						</div>	
						<div class="col-sm-6" style="padding:2px 1px;">
							<label for="com_bsns_cert" class="label" style="width:100%;">소상공인증명서</label>
							<input type="file" id="com_bsns_cert" name="com_bsns_cert" style="display:none;"/>
							<input type="hidden" name="old_com_bsns_cert" value="${comMember.com_bsns_cert}" />
							<div class="input-group input-group-sm" data-role="attach">
								<div class="input-group-btn">
                  					<button type="button" class="btn btn-outline-success btn-flat" name="com_bsns_cert">변경</button>
                				</div>
								<input type="text" class="form-control" name="view_com_bsns_cert" placeholder="파일을 선택하세요." value="${comMember.com_bsns_cert.split('\\$\\$')[1]}" >
								<span class="input-group-btn">
				                      <button type="button" data-role="com_bsns_cert" class="btn btn-danger btn-flat">X</button>
				                </span>	
							</div>
							
						</div>	
					</div>
					
					<div class="form-group">
						<div id="picturePreView"></div><br/><br/><br/><br/><br/><br/><br/>
						<label for="picture"  class="btn btn-outline-success btn-flat" style="width:110px;margin-bottom:2px;">사진변경</label>
						<input type="file" id="picture" name="mem_profile_img" style="display:none;"/> 
						<input type="hidden" id="picture" name="old_picture" value="${comMember.mem_profile_img }" />
					</div>
					
					<div class="col-sm-12">
						<div class="form-group" >
							<label class="control-label" for="">주&nbsp;소:</label><br/>
							<div>
								<input id="postCode" style="width:200px;float:left;" class="form-control" name="com_zipcode" type="text" value="${comMember.com_zipcode}" readonly />
								<input type="button" style="float:left;" class="btn btn-outline-success btn-flat" id="searchAddr" onclick="SearchAddress();" value="주소검색"/><br/>
								<input id="address[0]" class="form-control" type="text" name="com_addr1" readonly onclick="$('#searchAddr').click();" style="width:90%;" value="${comMember.com_addr1}"/>
								&nbsp;<input id="address[1]" class="form-control" type="text" name="com_addr2" placeholder="나머지주소" style="width:90%; " value="${comMember.com_addr2}"/>
							</div>
						</div>
					</div>
					
					<div class="card-footer">
						<button type="button" class="btn btn-outline-success btn-flat" onclick="SubmitComMemberModify('form');">저장하기</button>
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

window.onload = function () {
	console.log('${comMember.com_zipcode}');
// 	console.log('${comMember.com_bsns_reg_license.split('\\$\\$')[1]}');
// 	console.log('${comMember.com_bsns_cert.split('\\$\\$')[1]}');
}


//form submit
function SubmitComMemberModify(formRole){
//	var uploadCheck = $('input[name="checkUpload"]').val();
//	if(!(uploadCheck>0)){
//		alert("사진 업로드는 필수입니다.");	
//		//$('input[name="pictureFile"]').click();
//		return;
//	}

	if(!checkPw()) {
		return;
	}
	
	var form = $('form[role="'+formRole+'"]');
	form.submit();
}


function checkPw() {

	var pwd1 = $("#pw").val();
	var pwd2 = $("#pw2").val();
	
	console.log(pwd1);
	console.log(pwd2);
	
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

//첨부문서파일 추가 이벤트
$('div[data-role="attach"] button.btn-outline-success').on('click',function(){
	$('input[name='+$(this).attr('name')+']').click();	
});
$('div[data-role="attach"] input[type="file"]').on('change',function(){
	$('input[name="view_'+$(this).attr("name")+'"]').val(this.value);
});


//첨부문서파일 삭제 이벤트
$('div[data-role="attach"] button.btn-danger').on('click',function(){
	$('input[name="'+$(this).attr("data-role")+'"]').val("");
	$('input[name="old_'+$(this).attr("data-role")+'"]').val("");
	$('input[name="view_'+$(this).attr("data-role")+'"]').val("");
	
});

</script>

<!-- 주소 검색 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function SearchAddress(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	 // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }                

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postCode").value = data.zonecode;
                document.getElementById("address[0]").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("address[1]").focus();
	        }
	    }).open();
    }
</script>

<!-- 
</html> -->