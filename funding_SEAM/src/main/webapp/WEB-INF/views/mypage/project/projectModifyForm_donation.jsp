<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<body>
<br>
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-12">
				<div class="text-center">
					<h3>프로젝트 재등록</h3>
				</div>
				<br>
			</div>
			<!-- /.card-header -->
			<!-- form start -->
						<hr>
			<h4 class="pb-5 text-center">업체 정보</h4>
			<div class="col-12">
				<form class="form-horizontal" name="projectModify" action="pjtModify_donation" method="post" enctype="multipart/form-data">
					<div class="card-body">
						<div class="form-group row">
							<label for="comName" class="col-sm-3">상호명</label>
							<div class="col-sm-6">
								<input type="text" name="comName" class="form-control"
									id="comName" readonly="readonly" value="${comMember.com_bsns_name}">
							</div>
						</div>
						<div class="form-group row">
							<label for="Addr" class="col-sm-3">사업장 주소</label>
							<div class="col-sm-8">
								<input type="text" class="form-control col-4" id="comAddr"
									readonly="readonly" value="${comMember.com_zipcode }">
								<input type="text" class="form-control" id="comAddr"
									readonly="readonly" value="${comMember.com_addr1 }">
								<input type="text" class="form-control" id="comAddr"
									readonly="readonly" value="${comMember.com_addr2 }">
							</div>
						</div>
						<div class="form-group row">
							<label for="phone" class="col-sm-3">연락처</label>
							<div class="col-sm-4">
								<input type="text" class="form-control" id="comphone"
									readonly="readonly" value="${comMember.com_bsns_phone }">
							</div>
						</div>
						<div class="form-group row">
							<label for="pjt_category" class="col-sm-3">업종</label>
							<div class="col-sm-4">
								<select class="form-control" name="pjt_category">
									<option>선택</option>
									<option  ${project.pjt_category eq '음식점' ? 'selected':'' }>음식점</option>
									<option  ${project.pjt_category eq '서비스/문화' ? 'selected':'' }>서비스/문화</option>
									<option  ${project.pjt_category eq '도소매' ? 'selected':'' }>도소매</option>
									<option  ${project.pjt_category eq '교육' ? 'selected':'' }>교육</option>
									<option  ${project.pjt_category eq '제조' ? 'selected':'' }>제조</option>
									<option  ${project.pjt_category eq '기타' ? 'selected':'' }>기타</option>
								</select>
							</div>
						</div>

						<div class="form-group row">
							<label class="col-sm-3">통장 사본</label>
							<div class="col-sm-8">
								<div class="input-group">
				                      <input type="file" class="custom-file-input" id="bankBook" name="pjt_atc_bankbook_name">
				                      <c:set var="TextValue" value="${pjtBankSumAttach.pjt_atc_bankbook_name}"/>
				                      <label class="custom-file-label" for="bankBook" id="bankBookName">
				                      ${fn:substringAfter(TextValue, '$$') }
				                      </label>
								</div>
							</div>
							<label class="col-sm-1 col-form-label">
							<a tabindex="0" class="popover-dismiss" role="button" data-toggle="popover" data-placement="right" 
							data-trigger="focus" data-content="프로젝트 달성시 정산받으실 통장 사본파일을 업로드해주세요.">
							<i class="far fa-question-circle"></i></a>
							</label>
						</div>

						<hr>
												<h4 class="pb-5 text-center">프로젝트 정보</h4>
						<div class="form-group row">
							<label for="pjtTitle" class="col-sm-3">프로젝트 유형</label>
							<div class="col-sm-4">
								<input type="text" style="display: none;" name="pjt_type_code"
									class="form-control" id="pjtTitle" value="1"
									readonly="readonly"> <input type="text"
									class="form-control" value="후원형" readonly="readonly">
							</div>
						</div>
						<div class="form-group row">
							<label for="pjtTitle" class="col-sm-3">프로젝트 제목</label>
							<div class="col-sm-8">
								<input type="text" name="pjt_title" class="form-control"
									id="pjtTitle" placeholder="프로젝트 제목" value="${project.pjt_title }">
							</div>
							<label class="col-sm-1 col-form-label">
							<a tabindex="0" class="popover-dismiss" role="button" data-toggle="popover" data-placement="right" 
							data-trigger="focus" data-content="프로젝트의 제목은 한눈에 알아볼 수 있도록 만드는 것이 좋습니다.정답이 있는 것은 아니에요! 개성이 담긴 멋진 제목을 만들 수도 있어요.">
							<i class="far fa-question-circle"></i></a>
							</label>
						</div>
						<div class="form-group row">
							<label for="pjtCash" class="col-sm-3">목표 금액</label>
							<div class="col-sm-4">
								<input type="text" name="pjt_cash" class="form-control"
									id="pjtCash" placeholder="숫자로 입력해주세요" value="${project.pjt_cash }">
							</div>
							<label class="col-sm-1 col-form-label">
							<a tabindex="0" class="popover-dismiss" role="button" data-toggle="popover" data-placement="right" 
							data-trigger="focus" data-content="후원형은 최대 1,000만원까지 정할수 있어요. 기간을 고려하여 설정해주세요.">
							<i class="far fa-question-circle"></i></a>
							</label>
						</div>

						<div class="form-group row">
							<label for="date" class="col-sm-3">프로젝트 기간</label>
							<div class="col-sm-7 input-group-prepend">
								<input type="text" name="pjt_startdate" placeholder="yyyy-mm-dd"
									id="fromDate" class="form-control datepicker"
									data-inputmask-alias="datetime"
									data-inputmask-inputformat="mm/dd/yyyy" data-mask=""
									im-insert="false" value="<fmt:formatDate value="${project.pjt_startdate}" pattern="yyyy-MM-dd" />"> ~<input type="text"
									name="pjt_enddate" placeholder="yyyy-mm-dd" id="toDate"
									class="form-control datepicker" data-inputmask-alias="datetime"
									data-inputmask-inputformat="mm/dd/yyyy" data-mask=""
									im-insert="false" value="<fmt:formatDate value="${project.pjt_enddate}" pattern="yyyy-MM-dd" />">
							</div>
							<label class="col-sm-2 col-form-label">
							<a tabindex="0" class="popover-dismiss" role="button" data-toggle="popover" data-placement="right" 
							data-trigger="focus" data-content="많은 분들이 보통 30일에서 40일 사이의 기간을 설정하고 있으며, 
							최대 90일까지 설정 가능합니다. 심사 기간(최대 7일) 내 피드백 반영까지 고려하여 여유 있게 프로젝트 시작일정을 설정해 주시고,
							프로젝트 및 정산 상황에 따라 적절한 마감일정을 설정해 주세요. 오랫동안 진행한다고 해서 프로젝트가 반드시 성공하는 것은 아닙니다.">
							<i class="far fa-question-circle"></i></a>
							</label>
						</div>

						<div class="form-group row">
							<label class="col-sm-3">대표 이미지</label>
							<div class="col-sm-7">
								<div class="input-group">
				                      <input type="file" class="custom-file-input" id="sumImg" name="pjt_atc_sum_name">
										<c:set var="TextValue" value="${pjtBankSumAttach.pjt_atc_sum_name}"/>
				                      <label class="custom-file-label" for="customFile" id="fileName">
				                      ${fn:substringAfter(TextValue, '$$') }
				                      </label>
								</div>
							</div>
							<label class="col-sm-2 col-form-label"><a tabindex="0" class="popover-dismiss" role="button" data-toggle="popover" data-placement="right" 
							data-trigger="focus" data-content="프로젝트 목록 및 프로젝트 상세페이지 첫번째 노출되는 이미지입니다.">
							<i class="far fa-question-circle"></i></a></label>
						</div>
						
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">미리보기</label>
							<div class="col-sm-8" >
								<div id="sumImgPreView" class="col-sm-12 no-padding" style="height:400px;width:100%;border:1px solid lightgray;"></div>
							</div>
						</div>
						

						<div class="form-group row">
							<label class="col-sm-3">상세내용</label>
							<div class="col-sm-12">
								<textarea class="textarea" name="pjt_contents" id="contents"
									rows="20" placeholder="1000자 내외로 작성하세요." style="display: none;">${project.pjt_contents }</textarea>
							</div>
						</div>
					<input style="display:none;" name="mem_num" value="${loginUser.mem_num }">
					<input type="text" name="old_pjt_atc_bankbook_name" style="display:none;" value="${pjtBankSumAttach.pjt_atc_bankbook_name}">
					<input type="text" name="old_pjt_atc_sum_name" style="display:none;" value="${pjtBankSumAttach.pjt_atc_sum_name}">
					<input style="display:none;" name="pjt_state_code" value="4">
					<input style="display:none;" name="pjt_num" value="${project.pjt_num }">
					</div>
					<!-- /.card-body -->
					<div class="card-footer">
						<div class="row justify-content-md-center">
							<button type="button" class="btn btn-outline-success btn-flat"
								onclick="modify();">재승인요청</button>
							<button type="button" class="btn btn-outline-success btn-flat"
								onclick="javaScript:history.go(-1)">취소</button>
						</div>
					</div>
					<!-- /.card-footer -->
				</form>

			</div>
		</div>
	</div>
 
<%@ include file="../../commons/summernote_js.jsp"%> 

	<script>
	/* 후원형 금액 제한 */
	$('#pjtCash').on('change',function(){
		if($(this).val()*1 > 10000000){
			alert("후원형 프로젝트는 최대 1000만원까지 가능합니다.");
			$(this).val('');
			$(this).focus();
		}
		
	})
	/* 도움말 popover */
	$(function () {
		$('.popover-dismiss').popover({
			  trigger: 'focus'
			})
	});
	/* 수정버튼 */
	function modify(){
		if(!'${loginUser.mem_num}'){
			alert('로그인이 필요합니다.');
			location.href="/commons/loginForm"
			return;
		}
		//약관 동의
        var isSeasonChk = false;
        var arr_Season = document.getElementsByName("agree");
        for(var i=0;i<arr_Season.length;i++){
            if(arr_Season[i].checked == false) {
                isSeasonChk = false;
                alert("프로젝트 등록시 유의사항을 확인하고 동의해주세요.");
                return;
            }
        }
        
      //업종 미선택
        if($('[name=pjt_category]').val()=='선택'){
        	alert('업종을 선택해주세요.');
        	$('[name=pjt_category]').focus();
	        return;
        }
        //통장사본 미업로드
		if($('#isbankBookUpload').val()=="0"){
			alert('통장사본을 업로드해주세요.');
        	$('#bankBook').focus();
	        return;
		}
        //대표이미지 미업로드
        if($('#isSumImgUpload').val()=="0"){
        	alert('대표이미지를 업로드해주세요.');
        	$('#sumImg').focus();
	        return;
        }
        //제목 미입력
        if($('#pjtTitle').val()==""){
    		alert("프로젝트 제목을 입력해주세요.");
    		$('#pjtTitle').focus();
    		return;
    	}
        //날짜 미입력
        if($('#fromDate').val()==""){
			alert("프로젝트 시작일을 입력해주세요");
			$('#fromDate').focus();
			return;
		}
        if($('#toDate').val()==""){
        	alert("프로젝트 종료일을 입력해주세요");
			$('#toDate').focus();
			return;
        }
        //목표 금액 미입력
        if($('#pjtCash').val()==""){
        	alert("목표 금액을 입력해주세요.");
			$('#pjtCash').focus();
			return;
        }
		$('form[name="projectModify"]').submit();
	}
	
 	var imageURL="/project/picture/get?picture=${pjtBankSumAttach.pjt_atc_sum_name}";
	$('div#sumImgPreView').css({'background-image':'url('+imageURL+')',
							  'background-position':'center',
							  'background-size':'cover',
							  'background-repeat':'no-repeat'
	});
	
	
	/* 전체 동의 */
	$('.agreeAll').on('click',function(){
	    var chk = $(this).is(":checked");
	    if(chk) $(".agree").prop('checked', true);
	    else  $(".agree").prop('checked', false);
	});
	
	/* 사진업로드 */
	$('input#sumImg').on('change',function(event){
		//$('input[name="checkUpload"]').val(0);
		
		var fileFormat=this.value.substr(this.value.lastIndexOf(".")+1).toUpperCase();
		//이미지 확장자 jpg 확인
		if(fileFormat!="JPG"){
			alert("이미지는 jpg 형식만 가능합니다.");
			return;
		}
		//이미지 파일 용량 체크
		if(this.files[0].size>1024*1024*1){
			alert("사진 용량은 1MB 이하만 가능합니다.");
			return;
		}
		$('#fileName').text(this.files[0].name);
		
		if(this.files && this.files[0]){
			
			var reader = new FileReader();
			
			reader.onload = function (e){
				//이미지 미리보기
				$('div#sumImgPreView').css({
					'background-image':'url('+e.target.result+')',
					'background-position':'center',
					'background-size':'cover',
					'background-repeat':'no-repeat',
					'width':'100%',
					'height':'400px'
				});
			}
			
			reader.readAsDataURL(this.files[0]);
		}
	});
	
	/* 통장 사본 업로드 */
	$('input#bankBook').on('change',function(event){
		$('#bankBookName').text(this.files[0].name);
		
	});

		/* 데이트 픽커 */
		$(function() {
			//오늘 날짜를 출력
			$("#today").text(new Date().toLocaleDateString());

			//datepicker 한국어로 사용하기 위한 언어설정
			$.datepicker.setDefaults($.datepicker.regional['ko']);

			// 시작일(fromDate)은 종료일(toDate) 이후 날짜 선택 불가
			// 종료일(toDate)은 시작일(fromDate) 이전 날짜 선택 불가

			//시작일.
			$('#fromDate').datepicker(
					{
						showButtonPanel : true,
						closeText : '닫기', // 닫기 버튼 텍스트 변경
						currentText : '오늘',
						changeMonth : true, // 월을 이동하기 위한 선택상자 표시여부
						minDate : 0, // 선택할수있는 최소날짜, ( 0 : 오늘 이전 날짜 선택 불가)
						onClose : function(selectedDate) {

							//시작일을 다시 설정할 경우 종료 기간을 초기화시킨다.
							$('#toDate').datepicker('setDate', '');

							//시작일로 부터 최대 90일
							var orginalDate = new Date(selectedDate);
							var monthsAddedDate = new Date(
									new Date(orginalDate).setDate(orginalDate
											.getDate() + 90));

							// 시작일(fromDate) datepicker가 닫힐때
							// 종료일(toDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
							$("#toDate").datepicker("option", "minDate",
									selectedDate);
							$("#toDate").datepicker("option", "maxDate",
									monthsAddedDate);
						}
					});

			//종료일
			$('#toDate').datepicker({
				showButtonPanel : true,
				closeText : '닫기', // 닫기 버튼 텍스트 변경
				currentText : '오늘',
				changeMonth : true,
				minDate : 0, // 오늘 이전 날짜 선택 불가
				onClose : function(selectedDate) {
					// 종료일(toDate) datepicker가 닫힐때
					// 시작일(fromDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 종료일로 지정 
					//$("#fromDate").datepicker( "option", "maxDate", selectedDate );
				}
			});
		});
	</script>

</body>
