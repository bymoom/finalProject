<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container" style="min-height:800px;">
	<div class="justify-content-md-center" style="padding:40px;">
		<h2 class="page-section-heading text-center text-primary text-secondary mb-0">환불 내역</h2>
	</div>
	
<div class="card-body table-responsive p-0">
			<table class="table table-head-fixed text-center border-bottom">					
				<tr style="font-size:0.95em;">
					<th style="width:10%;">no</th>
					<th style="width:10%;">유형</th>
					<th style="width:30%;">프로젝트</th>
					<th style="width:15%;">환불금액</th>
					<th style="width:10%;">날짜</th>
					<th style="width:10%;">상태</th>
				</tr>				
				<c:if test="${empty refundList }" >
					<tr>
						<td colspan="6">
							<strong>해당 내용이 없습니다.</strong>
						</td>
					</tr>
				</c:if>						
				<c:forEach items="${refundList }" var="refund">
					<tr style='font-size:0.85em;'>
						<td>${refund.pjt_pay_num}</td>
						<td>
							<c:if test="${refund.pjt_pay_type eq 'kakaopay' }">카카오페이</c:if>
							<c:if test="${refund.pjt_pay_type eq 'kakao' }">카카오페이</c:if>
							<c:if test="${refund.pjt_pay_type eq 'bankpay' }">무통장입금</c:if>
						</td>
						<td style="text-align:left;max-width:100px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis;">${refund.pjt_title }</td>
						<td style="width:15%;">${refund.pjt_pay_amount }</td>
						<td>
							<fmt:formatDate value="${refund.ptj_pay_date }" pattern="yyyy-MM-dd"/>
						</td>
						<td style="width:10%;"><span class="statue">진행중</span></td>
						
					</tr>
				</c:forEach>
			</table>				
		</div>
		<%@ include file="/WEB-INF/views/mypage/refundlist/paginationByRefundList.jsp" %>	
	</div>
	
<script>

$(document).ready(function(){
	var today = new Date();
	var endday=${project.pjt_enddate }
	if(endday < today){
		$('.statue').text("종료");
	}
});
</script>