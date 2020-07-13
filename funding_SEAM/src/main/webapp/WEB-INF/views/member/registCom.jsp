<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>

div#picturePreView{
	height:140px;
	width:110px;
	margin:3px auto;	  		
	border : 1px solid lightgray;
	float: left;
	background-image:url("<%=request.getContextPath()%>/mypage/info/picture/${member.mem_num}");
	background-repeat:no-repeat;
	background-position:center;
	background-size:cover;
}

</style>

<body>

<!-- 	<header class="heading"> 소상공인 회원가입 </header> -->
<!-- 	<hr></hr> -->

		<div class="container">
			<div class="text-center">
				<h3>소상공인 회원가입</h3>
			</div>
			
				
<!-- 			<div class="col-sm-6"> -->
<!-- 			</div> -->
			
<!-- 			<div class="col-sm-6"> -->
<!-- 				<ol class="breadcrumb float-sm-right"> -->
<!-- 					<li class="breadcrumb-item"><a href="lis"> <i -->
<!-- 							class="fa fa-dashboard"></i> 회원관리 -->
<!-- 					</a></li> -->
<!-- 					<li class="breadcrumb-item active">등록</li> -->
<!-- 				</ol> -->
<!-- 			</div> -->
	<!-- 	</div>
	</div> -->
				<form class="form-horizontal" role="form" action="registCom" method="post" enctype="multipart/form-data">
				
				
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
						
						<hr>
						<div class="mt-3 mb-3 text-center">
							<h3>사업장 정보</h3>
						</div>
						
						
						<div class="form-group row pb-1">
							<label for="" class="col-sm-2 col-form-label">사업장명</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" id="com_bsns_name" placeholder="사업장명 입력" name="com_bsns_name">
								</div>
							</div>
						</div>

						<div class="form-group row pb-1">
							<label for="" class="col-sm-2 col-form-label">대표자명</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" id="com_bsns_rep_name" placeholder="대표자명 입력" name="com_bsns_rep_name">
								</div>
							</div>
						</div>
						
						<div class="form-group row pb-1">
							<label for="" class="col-sm-2 col-form-label">사업자 등록 번호</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" id="com_bsns_number" placeholder="사업자 등록 번호 입력" name="com_bsns_number">
								</div>
							</div>
						</div>
						
						<div class="form-group row pb-1">
							<label for="" class="col-sm-2 col-form-label">대표전화번호</label>
							<div class="col-4">
								<div class="input-group">
									<input type="text" class="form-control" id="com_bsns_phone" placeholder="대표전화번호입력" name="com_bsns_phone">
								</div>
							</div>
						</div>
					
						<div class="form-group row pb-1">
							<label for="" class="col-sm-2 col-form-label">주소</label>
							<div class="col-8">
								<div class="row">
									<div class="input-group col-6">
										<input id="postCode" class="form-control" name="com_zipcode" type="text" readonly placeholder="우편번호">
										<button type="button"  class="btn btn-outline-success btn-flat" id="searchAddr" onclick="SearchAddress();" >주소검색</button>
									</div>
									
									<div class="col-12">
									<input id="address[0]" class="form-control" type="text" name="com_addr1" readonly onclick="$('#searchAddr').click();"/>
									</div>								
									<div class="col-12">
									<input id="address[1]" class="form-control" type="text" name="com_addr2" placeholder="나머지주소"/>
									</div>								
								</div>
							</div>
						</div>
					
					
						<div class="form-group row pb-1" data-role="attach">
							<label for="inputFile" class="col-sm-2 col-form-label">사업자등록증</label>
							<div class="col-4">
								<div class="input-group">
									<input id="RegLicense" class="form-control" type="file" name="com_bsns_reg_license" />
									<span class='input-group-btn'>
										<button class="btn btn-outline-danger btn-flat com_bsns_reg" type='button' data-role="com_bsns_reg_license"><b>X</b></button>
									</span>
								</div>
							</div>
						</div>

						<div class="form-group row pb-1" data-role="attach">
							<label for="inputFile" class="col-sm-2 col-form-label">소상공인증명서</label>
							<div class="col-4">
								<div class="input-group">
									<input id="RegCert" class="form-control" type="file" name="com_bsns_cert" />
									<span class='input-group-btn'>
										<button class="btn btn-outline-danger btn-flat com_bsns_reg" type='button' data-role="com_bsns_cert"><b>X</b></button>
									</span>
								</div>
							</div>
						</div>
					
<!-- 					<div class="col-sm-12 g_value" data-role="attach">
						<div class="col-sm-6" style="padding:2px 1px;">
							<label for="inputFile" class="label" style="width:100%;">사업자등록증</label>
							<div class="input-group">
								<input id="RegLicense" class="form-control" type="file" name="com_bsns_reg_license" />
								<span class='input-group-btn'>
									<button class="btn btn-outline-danger btn-flat" type='button' data-role="com_bsns_reg_license"><b>X</b></button>
								</span>
							</div>
						</div>	
						<div class="col-sm-6" style="padding:2px 1px;">
							<label for="inputFile" class="label" style="width:100%;">소상공인증명서</label>
							<div class="input-group">
								<input id="RegCert" class="form-control" type="file" name="com_bsns_cert" />
								<span class='input-group-btn'>
									<button class="btn btn-outline-danger btn-flat" type='button' data-role="com_bsns_cert"><b>X</b></button>
								</span>
							</div>
						</div>	
					</div> -->

<!-- 					<div class="col-sm-12"> -->
<!-- 						<div class="form-group row"> -->
<!-- 							<div class="col-sm-4"> -->
<!-- 								<label for="inputFile" class="control-label">사업자등록증</label> -->
<!-- 							</div> -->
<!-- 							<div class="col-sm-8"> -->
<!-- 								<input id="inputRegLicense" class="form-control" type="text" -->
<!-- 									name="com_bsns_reg_license" /> -->
<!-- 							</div> -->
<!-- 							<span class=""> -->
<!-- 								<button type="button" class="" -->
<!-- 									onclick="upload_bsns_reg_license();">업로드</button> -->
<!-- 							</span> -->
<!-- 						</div> -->
<!-- 					</div> -->

<!-- 					<div class="col-sm-12"> -->
<!-- 						<div class="form-group row"> -->
<!-- 							<div class="col-sm-4"> -->
<!-- 								<label for="inputFile" class="control-label">소상공인증명서</label> -->
<!-- 							</div> -->
<!-- 							<div class="col-sm-8"> -->
<!-- 								<input id="inputCert" class="form-control" type="text" -->
<!-- 									name="com_bsns_cert" /> -->
<!-- 							</div> -->
<!-- 							<span class=""> -->
<!-- 								<button type="button" class="" onclick="upload_bsns_cert();">업로드</button> -->
<!-- 							</span> -->
<!-- 						</div> -->
<!-- 					</div> -->

					<br/><br/><br/>
<!-- 
					<div class="form-group">
						<div role="picture">
							<div id="picturePreView"></div><br/><br/><br/><br/><br/><br/><br/>
							<label for="picture"  class="btn btn-outline-success btn-flat" style="width:110px;margin-bottom:2px;">사진등록</label>
							<input type="file" id="picture" name="mem_profile_img" style="display:none;"/>
						</div> 
					</div> -->
					

					
					
					
					<div class="row justify-content-md-center">
						<button type="button" class="btn btn-outline-success btn-flat" onclick="SubmitMemberRegist('form');">가입하기</button>
						<button type="button" class="btn btn-outline-success btn-flat" onclick="javascript:history.go(-1)">뒤로가기</button>
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

function idFormCheck() {
	  var email = $("#id").val();

	  // if value is empty then exit
	  if( email == '' || email == 'undefined') return;

	  // valid check
	  if(! email_check(email) ) {
//	  	$("#result-check").text('Not valid email.');
		alert("올바르지 않은 이메일형식입니다.")
	    $(this).focus();
	    return false;
	  }
	  else {
//	  	$("#result-check").text('Email address test OK.');
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

//첨부문서파일 삭제 이벤트
$('div[data-role="attach"] button.com_bsns_reg').on('click',function(){
	
	$('input[name="'+$(this).attr("data-role")+'"]').val("");
});


function registInputCheck() {
	var name = $("#name").val();
	var ptel = $("#ptel").val();
	var bsns_name = $("#com_bsns_name").val();	//사업장명
	var bsns_rep_name = $("#com_bsns_rep_name").val();	//대표자명
	var bsns_number = $("#com_bsns_number").val();	//사업자등록번호
	var bsns_phone = $("#com_bsns_phone").val();	//대표전화번호
	var postCode = $("#postCode").val();	//우편번호
	var address1 = $("address[0]").val(); //주소1
	var address2 = $("address[1]").val(); //주소2
	
	if(name == ''){
		alert("이름을 입력하세요.")
		$("#name").focus();
		return false;
	}
	
	if(ptel == ''){
		alert("휴대폰번호를 입력하세요.")
		$("#ptel").focus();
		return false;
	}
	
	if(bsns_name == '') {
		alert('사업장명을 입력하세요');
		$("#com_bsns_name").focus();
		return false;
	}

	if(bsns_rep_name == '') {
		alert('대표자명을 입력하세요');
		$("#com_bsns_rep_name").focus();
		return false;
	}
	
	if(bsns_number == '') {
		alert('사업자등록번호를 입력하세요');
		$("#com_bsns_number").focus();
		return false;
	}

	if(bsns_phone == '') {
		alert('대표전화번호를 입력하세요');
		$("#com_bsns_phone").focus();
		return false;
	}
	
	if(address2 == '') {
		alert('상세주소를 입력하세요');
		$("address[1]").focus();
		return false;
	}
	
	return true;
}


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
</html>