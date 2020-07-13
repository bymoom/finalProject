<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="min-height:800px;">
	<div class="row justify-content-md-center">
		<div class="col-12 mb-5">
		<h2 class="page-section-heading text-center text-primary text-secondary mb-0">후원 내역</h2>
		</div>
		<div class="input-group col-3">
		</div>
			<div id="keyword" class="input-group col-8 mb-2">
				<select class="form-control" name="searchType" id="searchType" style="border:none;">
					<option value="ifs"  ${pageMaker.cri.searchType eq 'ifs' ? 'selected':'' }>전체</option>
					<option value="i" ${pageMaker.cri.searchType eq 'i' ? 'selected':'' }>진행중</option>
					<option value="f" ${pageMaker.cri.searchType eq 'f' ? 'selected':'' }>실패</option>
					<option value="s" ${pageMaker.cri.searchType eq 's' ? 'selected':'' }>성공</option>
				</select>
				<input class="form-control" type="text" name="keyword" style="width:200px; outline: 0;border-width: 0 0 2px;" placeholder="검색어를 입력하세요." value="${param.keyword }"/>
				<div class="input-group-append">
					<button class="btn" type="button" onclick="searchList_go(1);" data-card-widget="search"><i class="fas fa-search"></i></button>
				</div>
			</div>	
	</div>
	
<div class="card-body table-responsive p-0">
			<table class="table table-head-fixed text-center border-bottom">					
				<tr style="font-size:0.95em;">
					<th style="width:10%;">no</th>
					<th style="width:10%;">유형</th>
					<th style="width:40%;">제목</th>
					<th style="width:15%;">후원금액</th>
					<th>날짜</th>
					<th style="width:10%;">상태</th>
				</tr>				
				<c:if test="${empty projectList }" >
					<tr>
						<td colspan="6">
							<strong>해당 내용이 없습니다.</strong>
						</td>
					</tr>
				</c:if>						
				<c:forEach items="${projectList }" var="project">
					<div style="display:none;">
				      <jsp:useBean id="now" class="java.util.Date" />
					  <fmt:parseNumber value="${now.time }" integerOnly="true" var="startD" scope="request"/>
				      <fmt:formatDate value="${project.pjt_enddate }" pattern="yyyyMMdd" var="ed"/>
				      <fmt:formatDate value="${now }" pattern="yyyyMMdd" var="sd"/>
					  <fmt:parseNumber value="${project.pjt_enddate.time }" integerOnly="true" var="endD" scope="request"/>
					</div>
				
					<tr style='font-size:0.85em;'>
					<td>${project.pjt_pay_num }</td>
					<td><c:if test="${project.pjt_type_code eq 1 }">후원</c:if>
					<c:if test="${project.pjt_type_code eq 2 }">대출</c:if>
					</td>
					<td class="a" style="text-align:left;max-width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">
					<c:if test="${project.pjt_type_code eq 1 }"><a onclick="detailGo('1','${project.pjt_num}')" style="cursor:pointer;">${project.pjt_title }</a></c:if>
					<c:if test="${project.pjt_type_code eq 2 }"><a onclick="detailGo('2','${project.pjt_num}')" style="cursor:pointer;">${project.pjt_title }</a></c:if>
					</td>
					<td style="width:15%;">${project.pjt_pay_amount }</td>
					<td>
					<fmt:formatDate value="${project.ptj_pay_date }" pattern="yyyy-MM-dd"/>
					</td>
					<td style="width:20%;"><span class="statue" name="sp" end-date="${endD-startD}" type="${project.pjt_type_code}" 
					calc-state="${project.pjt_pay_calc_state }" calD="${ed+20000-sd }" sd="${ed+20000 }"
					pjtPaySum="${project.pjt_cash-project.pjtPaySum }" refund="${project.pjt_refund }">진행중</span></td>
					</tr>
				</c:forEach>
			</table>				
		</div>
		<br>
	<form style="display: hidden" method="POST" id="detailform">
	  <input type="hidden" name="pjt_num" value=""/>
	</form>
		<%@ include file="/WEB-INF/views/mypage/project/paginationBypayList.jsp" %>	
	</div>
	
<script>
$(document).ready(function(){

    var arr_Season = document.getElementsByName("sp");
    for(var i=0;i<arr_Season.length;i++){
    	if(arr_Season[i].getAttribute('refund')==1){
			arr_Season[i].textContent="환불처리중";
		}
    	if(arr_Season[i].getAttribute('refund')==2){
			arr_Season[i].textContent="환불완료";
		}
    	if(arr_Season[i].getAttribute('end-date') <0){
    		arr_Season[i].textContent="실패(환불처리중)";
    		if(arr_Season[i].getAttribute('refund')==2){
    			arr_Season[i].textContent="실패(환불완료)";
    		}
    		if(arr_Season[i].getAttribute('pjtPaySum')<=0){
    			arr_Season[i].textContent="성공";
    			if(arr_Season[i].getAttribute('type')==2){
        			
        			var nowDate=new Date();
        			var nowObj=nowDate.getTime();
        			var dday=to_date(arr_Season[i].getAttribute('sd')).getTime()-nowObj;
        			var gapDay=Math.ceil(dday/(60*1000*60*24));
        			
        			arr_Season[i].textContent="성공 만기 D-"+gapDay;
        	 		
        	 		
        			if(arr_Season[i].getAttribute('calD')<0){
            			arr_Season[i].textContent="성공 (정산처리중)";
            		}
        			if(arr_Season[i].getAttribute('calc-state')==1){
            			arr_Season[i].textContent="성공 (정산완료)";
            		}
        		}
    		}
    	}
    }
    
	$('span[name=sp]').each(function(){
		if($(this).text()!='진행중'){
			$(this).parent().siblings('.a').children().attr('onclick','endProject();');
		}
	});
});

function endProject(){
	alert('종료된 프로젝트 입니다.');
}

function to_date(date_str)
{
    var yyyyMMdd = String(date_str);
    var sYear = yyyyMMdd.substring(0,4);
    var sMonth = yyyyMMdd.substring(4,6);
    var sDate = yyyyMMdd.substring(6,8);

    return new Date(Number(sYear), Number(sMonth)-1, Number(sDate));
}

</script>