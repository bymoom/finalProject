<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container col-10">
<!-- 환불 대기 정보 -->
<%-- <div class="info-box bg-warning">`
	<span class="info-box-icon bg-warning elevation-1"><i class="fas fa-users"></i></span>
 	<div class="info-box-content">
   		<span class="info-box-text"><a href="#" onclick="stateStandByListGo();" style="font-size:35px;color:black;"><b>${stateStandByTotalCount }</b>개의 프로젝트가 승인 대기 중입니다!</a></span>
 	</div>
 	<!-- /.info-box-content -->
</div>
<div class="info-box bg-warning">
	<span class="info-box-icon bg-warning elevation-1"><i class="fas fa-users"></i></span>
	<div class="info-box-content">
	  	<span class="info-box-text"><a href="#" onclick="calcStandByListGo();" style="font-size:35px;color:black;"><b>${calcStandByTotalCount }</b>개의 프로젝트가 정산 대기 중입니다!</a></span>
	</div>
 	<!-- /.info-box-content -->
</div> --%>

	<!-- 결제 내역 리스트 -->
	<ul class="list-group list-group-flush" style="list-style: none;">
		<li class="list-group-item">
	       <h3 class="float-left">결제 내역 리스트</h3>
    	</li>
    	<hr>	
    </ul>
       <!-- /.card-header -->
       <div class="card-body table-responsive p-0" style="height: auto;">
        <div class="card-tools">
            <table>
              	<tr>
              		<td>
              			<select class="form-control" name="pjtPayType" id="pjtPayType" onchange="searchList_go(1);" style="border:none;">
	             			<option>결제 방식</option>
							<option value="kakaopay" ${pageMaker.cri.pjtPayType eq 'kakaopay' ? 'selected':'' }>카카오페이</option>
							<option value="bankpay" ${pageMaker.cri.pjtPayType eq 'bankpay' ? 'selected':'' }>무통장입금</option>
						</select>
              		</td>
              		<td>
              			<select class="form-control" name="pjtRefundType" id="pjtRefundType" onchange="searchList_go(1);" style="border:none;">
		             		<option>환불 상태</option>
							<option value="환불 요청" ${pageMaker.cri.pjtRefundType eq '환불 요청' ? 'selected':'' }>환불 요청</option>
							<option value="환불 대기 중" ${pageMaker.cri.pjtRefundType eq '환불 대기 중' ? 'selected':'' }>환불 대기 중</option>
							<option value="환불 완료" ${pageMaker.cri.pjtRefundType eq '환불 완료' ? 'selected':'' }>환불 완료</option>
						</select>
              		</td>	
              		<td>
              			<div class="input-group" style="float:left;margin:0px 10px 0px 10px;">
              				<div class="input-group-prepend">
		              			<h7 style="padding-top:10px;">결제 일자&nbsp;:&nbsp;</h7>
			                    <span class="input-group-text" style="height:30px;margin-top:7px;">
			                    	<i class="far fa-calendar-alt"></i>
			                    </span>
			                    <input type="text" id="firstPjtPayDate" name="firstPjtPayDate" class="form-control input-group-append datepicker" style="width:110px;height:30px;margin-top:7px;" value="${param.firstPjtPayDate }">
		                    </div>
		                    <h7 style="margin-top:7px;">&nbsp;~&nbsp;</h7>
		                    <div class="input-group-prepend">
			                    <span class="input-group-text" style="height:30px;margin-top:7px;">
			                    	<i class="far fa-calendar-alt"></i>
			                    </span>
			                    <input type="text" id="lastPjtPayDate" name="lastPjtPayDate" class="form-control input-group-append datepicker" style="width:110px;height:30px;margin-top:7px;" value="${param.lastPjtPayDate }">
			                </div>    
	                    </div>
              		</td>
              		<td>
              			<div class="input-group" style="float:left;">
              				<div class="input-group-prepend">
		              			<h7 style="padding-top:10px;">결제 금액&nbsp;:&nbsp;</h7>
			                    <input type="text" id="firstPjtPayAmount" name="firstPjtPayAmount" class="form-control" style="width:110px;height:30px;margin-top:7px;" value="${param.firstPjtPayAmount }">
							</div>
		                    <h7 style="margin-top:7px;">&nbsp;~&nbsp;</h7>
		                    <div class="input-group-prepend">
			                    <input type="text" id="lastPjtPayAmount" name="lastPjtPayAmount" class="form-control" style="width:110px;height:30px;margin-top:7px;" value="${param.lastPjtPayAmount }">
			                </div>    
	                	</div>
              		</td>
              		<td style="padding-right:30px;">
              			<div class="input-group row float-right" style="width:400px;margin-left:30px;">
						    <select class="form-control col-md-4" name="searchType" id="searchType" style="border:none;">
								<option value="all"  ${pageMaker.cri.searchType eq 'all' ? 'selected':'' }>전 체</option>
								<option value="name" ${pageMaker.cri.searchType eq 'name' ? 'selected':'' }>회원 이름</option>
								<option value="email" ${pageMaker.cri.searchType eq 'email' ? 'selected':'' }>회원 이메일</option>
								<option value="projectTitle" ${pageMaker.cri.searchType eq 'projectTitle' ? 'selected':'' }>프로젝트 제목</option>
							</select>					
						    <input  class="form-control col-md-6" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${param.keyword }" style="width:180px;outline: 0;border-width: 0 0 2px;"/>
							<span class="input-group-append">
								<button class="btn" type="button" id="searchBtn" onclick="searchList_go(1);" data-card-widget="search"><i class="fas fa-search"></i></button>
							</span>
						</div>
              		</td>
              		<td>
              			<button type="button" id="downloadBtn" class="btn btn-secondary" style="float:right;" onclick="fnExcelReport('hiddenTable','funseamding_결제내역리스트')">Excel</button>
              		</td>
				</tr>
			</table>
       </div>
       <br/>
       <hr>
       	<div class="row">
			<div class="col-md-3" style="margin-top:20px;">
				<button type="button" class="btn btn-secondary" id="checkBtn" onclick="refundGo();">환불 완료</button>			
			</div>
		</div>
       <table class="table text-center">
        <thead>
          <tr>
          	<th style="width:2%;"><input type='checkbox' id='checkAll' name='checkAll'></th>
            <th style="width:10%;">번호</th>
            <th style="width:12%;">이름</th>
            <th>이메일</th>
            <th style="width:13%;">전화<br>번호</th>
            <th style="width:10%;">프로젝트</th>
            <th style="width:8%;">유형</th>
            <th>결제<br/>방식</th>
            <th>결제<br/>금액</th>
            <th style="width:12%;">포인트<br/>사용</th>
            <!-- <th style="width:8%;">결제<br/>전화번호</th> -->
            <th>결제<br/>일자</th>
            <th style="width:9%;">환불<br/>여부</th>
            <th style="width:13%;">상태</th>
          </tr>
        </thead>
        <tbody>
        <c:if test="${empty projectPayList }" >
		<tr>
			<td colspan="13">
				<strong>해당 내용이 없습니다.</strong>
			</td>
		</tr>
		</c:if>						
		<c:forEach items="${projectPayList }" var="projectPay">
			<tr class="trForClick" style='font-size:0.85em;cursor:pointer;'>
				<c:choose>
					<c:when test="${projectPay.pjt_refund eq 0 or projectPay.pjt_refund eq 1}">
						<td onclick="event.cancelBubble=true"><input type='checkbox' name='check' value='${projectPay.pjt_pay_num }'></td>
					</c:when>
					<c:when test="${projectPay.pjt_refund eq 2 }">
						<td onclick="event.cancelBubble=true"><input type='checkbox' name='check' value='${projectPay.pjt_pay_num }' checked></td>
					</c:when>
				</c:choose>
				<td>${projectPay.pjt_pay_num }</td>
				<td>${projectPay.mem_name }</td>
				<td>${projectPay.mem_email }</td>
				<td>${projectPay.mem_phone }</td>
				<td style="text-align:left;max-width: 200px; overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${projectPay.pjt_title }</td>
				<td>${projectPay.pjt_type_code_val }</td>
				<td>${projectPay.pjt_pay_type }</td>
				<td><fmt:formatNumber>${projectPay.pjt_pay_amount }</fmt:formatNumber></td>
				<td><fmt:formatNumber>${projectPay.pjt_pay_usepoint }</fmt:formatNumber></td>
				<%-- <td>${projectPay.pjt_pay_phone }</td> --%>
				<td><fmt:formatDate value="${projectPay.ptj_pay_date }" pattern="yyyy-MM-dd"/></td>
				<c:if test="${projectPay.pjt_refund eq 0 or projectPay.pjt_refund eq 1}">
					<td>N</td>
					<td>
						<c:choose>
							<c:when test="${projectPay.pjt_refund eq 1}">
								<b style="color:red;">*환불 요청*</b>
							</c:when>
							<c:when test="${projectPay.pjt_refund eq 0}">
								<c:forEach items="${standByToRefundList }" var="standByToRefund">
									<c:if test="${standByToRefund.pjt_pay_num eq projectPay.pjt_pay_num }">
										<b style="color:red;">환불 대기중</b>
									</c:if>
								</c:forEach>
								<c:forEach items="${standByRepaymentList }" var="standByToRepayment">
									<c:if test="${standByToRepayment.pjt_num eq projectPay.pjt_num }">
										<c:if test="${projectPay.pjt_pay_calc_state eq 0 }">
											<b style="color:red;">대출 상환 대기 중</b>
										</c:if>
										<c:if test="${projectPay.pjt_pay_calc_state eq 1 }">
											대출 상환 완료
										</c:if>
									</c:if>
								</c:forEach>
							</c:when>
						</c:choose>
					</td>
				</c:if>
				<c:if test="${projectPay.pjt_refund eq 2}">
					<td>Y</td>
					<td></td>
				</c:if>
			</tr>
		</c:forEach>	
        </tbody>
       </table>
      </div>
     <!-- /.card-body -->
     <div class="card-footer" style="background:white;">
	<%@ include file="/WEB-INF/views/admin/pay/pagination.jsp" %>		
  </div>
</div>
<br/>
<table class="table text-center" id="hiddenTable" style="display:none;">
	<thead>
	  <tr>
	    <th>번 호</th>
        <th>이 름</th>
        <th>이메일</th>
        <th>전화번호</th>
        <th>프로젝트</th>
        <th>유 형</th>
        <th>결제 방식</th>
        <th>결제 금액</th>
        <th>포인트 사용</th>
        <th>결제 전화번호</th>
        <th>결제 일자</th>
        <th>환불 여부</th>
	  </tr>
	</thead>
	<tbody>
	<c:if test="${empty projectPayList }" >
		<tr>
			<td colspan="12">
				<strong>해당 내용이 없습니다.</strong>
			</td>
		</tr>
	</c:if>						
	<c:forEach items="${projectPayListForDownload }" var="projectPayForDownload">
		<tr style='font-size:0.85em;'>
			<td>${projectPayForDownload.pjt_pay_num }</td>
			<td>${projectPayForDownload.mem_name }</td>
			<td>${projectPayForDownload.mem_email }</td>
			<td>${projectPayForDownload.mem_phone }</td>
			<td>${projectPayForDownload.pjt_title }</td>
			<td>${projectPayForDownload.pjt_type_code_val }</td>
			<td>${projectPayForDownload.pjt_pay_type }</td>
			<td><fmt:formatNumber>${projectPayForDownload.pjt_pay_amount }</fmt:formatNumber></td>
			<td><fmt:formatNumber>${projectPayForDownload.pjt_pay_usepoint }</fmt:formatNumber></td>
			<td>${projectPayForDownload.pjt_pay_phone }</td>
			<td><fmt:formatDate value="${projectPayForDownload.ptj_pay_date }" pattern="yyyy-MM-dd"/></td>
			<c:if test="${projectPayForDownload.pjt_refund eq 0}">
				<td>N</td>
			</c:if>
			<c:if test="${projectPayForDownload.pjt_refund eq 1}">
				<td>Y</td>
			</c:if>
		</tr>
	</c:forEach>
	</tbody>
</table>
<br/>
<script>
	$('.datepicker').datepicker({});
	
/* 	$(function(){
		var option = {
		// datepicker 애니메이션 타입
		// option 종류 : "show" , "slideDown", "fadeIn", "blind", "bounce", "clip", "drop", "fold", "slide"
		showAnim : "slideDown",
		// 해당 월의 다른 월의 날짜가 보이는 여부, 예를 들면 10월이면 전후에 9월 마지막과 11월의 시작 일이 보이는 여부입니다. 즉, 달력이 꽉 차 보이게 하는 것
		showOtherMonths: true,
		// 선택 여부 (showOtherMonths 옵션과 같이 일치시키지 않으면 에러가 발생합니다.)
		selectOtherMonths: true,
		// 달력 밑에 오늘과 닫기 버튼이 보인다.
		showButtonPanel: true,
		// 년 월이 셀렉트 박스로 표현 되어서 선택할 수 있다.
		changeMonth: true,
		changeYear: true,
		// 한번에 보이는 개월 수
		numberOfMonths: 3,
		// 데이터 포멧
		dateFormat: "yy-mm-dd",
		// 텍스트 박스 옆의 달력 포시
		showOn: "button",
		//이미지 타입인지 버튼 타입인지 설정
		buttonImageOnly: true,
		// 이미지 경로
		buttonImage: "https://jqueryui.com/resources/demos/datepicker/images/calendar.gif",
		// 버튼 타입이면 버튼 값
		buttonText: "Select date",
		// alt 데이터 포멧
		altFormat: "DD, d MM, yy",
		// 선택 가능한 날짜(수 형식) - 현재 기준 -20일
		minDate: -20,
		// 선택 가능한 최대 날짜(문자 형식) - 현재 기준 +1월 +20일
		maxDate: "+1M +20D",
		// 주 표시
		showWeek: true
		};
		var optionFrom = option;
		optionFrom.altField = "#alternateFrom";
		var dateFormat = "mm/dd/yy";
		// 시작일이 선택이 되면 종료일은 시작일 보다 앞을 선택할 수 없다.
		var from = $( "#from" )
		.datepicker(optionFrom)
		.on( "change", function() {
		to.datepicker( "option", "minDate", getDate( this ) );
		});
		var optionTo = option;
		optionTo.altField = "#alternateTo";
		// 종료일이 선택이 되면 시작일은 시작일 보다 앞을 선택할 수 없다.
		var to = $( "#to" )
		.datepicker(optionTo)
		.on( "change", function() {
		from.datepicker( "option", "maxDate", getDate( this ) );
		});
		function getDate( element ) {
		return moment(element.value).toDate();
		}
		}); */
		
	function fnExcelReport(id, title) {
		var tab_text = '<html xmlns:x="urn:schemas-microsoft-com:office:excel">';
		tab_text = tab_text + '<head><meta http-equiv="content-type" content="application/vnd.ms-excel; charset=UTF-8">';
		tab_text = tab_text + '<xml><x:ExcelWorkbook><x:ExcelWorksheets><x:ExcelWorksheet>'
		tab_text = tab_text + '<x:Name>Test Sheet</x:Name>';
		tab_text = tab_text + '<x:WorksheetOptions><x:Panes></x:Panes></x:WorksheetOptions></x:ExcelWorksheet>';
		tab_text = tab_text + '</x:ExcelWorksheets></x:ExcelWorkbook></xml></head><body>';
		tab_text = tab_text + "<table border='1px'>";
		var exportTable = $('#' + id).clone();
		exportTable.find('input').each(function (index, elem) { $(elem).remove(); });
		tab_text = tab_text + exportTable.html();
		tab_text = tab_text + '</table></body></html>';
		var data_type = 'data:application/vnd.ms-excel';
		var ua = window.navigator.userAgent;
		var msie = ua.indexOf("MSIE ");
		var fileName = title + '.xls';
		//Explorer 환경에서 다운로드
		if (msie > 0 || !!navigator.userAgent.match(/Trident.*rv\:11\./)) {
		if (window.navigator.msSaveBlob) {
		var blob = new Blob([tab_text], {
		type: "application/csv;charset=utf-8;"
		});
		navigator.msSaveBlob(blob, fileName);
		}
		} else {
		var blob2 = new Blob([tab_text], {
		type: "application/csv;charset=utf-8;"
		});
		var filename = fileName;
		var elem = window.document.createElement('a');
		elem.href = window.URL.createObjectURL(blob2);
		elem.download = filename;
		document.body.appendChild(elem);
		elem.click();
		document.body.removeChild(elem);
		}
	}
		
	$(".trForClick").on('click', function(){
		var tr = $(this);
		var td = tr.children();
		var pjt_pay_num = td.eq(1).text();
		//alert(pjt_pay_num);
		OpenWindow("<%= request.getContextPath() %>/admin/pay/detail?pjt_pay_num=" + pjt_pay_num, '결제 내역 상세 보기', 950, 900);	
	});
		
	$("#checkAll").on('click', function(){
        if($("#checkAll").prop("checked")){
            $("input[name='check']").prop("checked", true);
        }else{
            $("input[name='check']").prop("checked", false);
        }
    });

	function refundGo(){
		if($("input:checkbox[name='check']").is(":checked") == false){
			alert("환불 완료로 처리할 결제 내역을 선택해주세요.");
			return;
		}
		
		var checkedTrueList = new Array();
		var checkedFalseList = new Array();
		
		if($("input:checkbox[name='check']").is(":checked") == true){
			$(":checkbox[name='check']:checked").each(function(i,e){
				//alert("check된거 : " + e.value);
				checkedTrueList.push(e.value);
			});
        }

		var json = { 'checkedTrueList' : checkedTrueList };
		
		var con = confirm("환불 완료로 처리하시겠습니까?");
		if(con){
			$.ajax({
				url : '<%= request.getContextPath() %>/admin/pay/refund',
				type : 'post',
				data: JSON.stringify(json),
		        //dataType:'json',
		        contentType:'application/json',
				success : function(result){
					alert("선택하신 내역을 환불 완료로 처리했습니다.");
					location.reload();
				},
				error : function(xhr,error){
					alert("서버 오류로 실패했습니다. 다시 시도해주세요!");
					//alert("code:"+xhr.status+"\n"+"message:"+xhr.responseText+"\n"+"error:"+error);
				}
			})	
		}else{
			alert("취소하였습니다.");
		}

	}
</script>

