<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<br>

<div class="container">
		<h2 class="page-section-heading text-center text-uppercase text-secondary mb-0">마이페이지</h2>
		<br>
	<div class="row justify-content-md-center">
		
		<a data-url="<%=request.getContextPath()%>/mypage/info/calmain">
			<button	style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">출석체크</button>
		</a> 
		
		<c:if test="${loginUser.code_num eq 1 }">
		<a data-url="<%=request.getContextPath()%>/mypage/info/detail">
			<button style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">정보수정</button>
		</a>
		</c:if>
		
		<c:if test="${loginUser.code_num == 2 || loginUser.code_num == 9}">
		<a data-url="<%=request.getContextPath()%>/mypage/info/detailCom">		
			<button style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">정보수정</button>
		</a>
		</c:if>

        <a data-url="#">
			<button style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">결제/환불 내역</button>
		</a>
        <a data-url="#">
			<button style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">프로젝트 관리</button>
		</a>

        <a data-url="<%=request.getContextPath()%>/mypage/info/withdrawForm">		
			<button style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">회원 탈퇴</button>
		</a>
		
	</div>

	<br>
	
	<div class="container">
		<div style="text-align:right;">
<!-- 			<button id="FAQRegist" class="btn btn-success" style="width:100px;" type="button" onclick="OpenWindow('regist','등록',1200,800)">FAQ 등록</button> -->
			<iframe id="iframe" width="1000" height="100%" src="<%=request.getContextPath()%>/mypage/info/calmain"></iframe>
		</div>
	</div>
	<br>
	<!-- 일반 회원 리스트 -->
	<!-- 
	
	<div class="container">
		<div class="row justify-content-md-center cols-xl-4">
			<c:forEach items="${FAQ }" var="faq">
				<input type="hidden" class="faqnum" value="${faq.faq_num }">			
				<button class="accordion" style="background-color:white;border-top:2px solid black;text-align:center;font-weight:bold;"><div style="float:left;"><svg style="font-weight:bold;font-size:1.5em;" class="bi bi-emoji-sunglasses" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
					  <path fill-rule="evenodd" d="M4.285 9.567a.5.5 0 0 1 .683.183A3.498 3.498 0 0 0 8 11.5a3.498 3.498 0 0 0 3.032-1.75.5.5 0 1 1 .866.5A4.498 4.498 0 0 1 8 12.5a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .183-.683zM6.5 6.497V6.5h-1c0-.568.447-.947.862-1.154C6.807 5.123 7.387 5 8 5s1.193.123 1.638.346c.415.207.862.586.862 1.154h-1v-.003l-.003-.01a.213.213 0 0 0-.036-.053.86.86 0 0 0-.27-.194C8.91 6.1 8.49 6 8 6c-.491 0-.912.1-1.19.24a.86.86 0 0 0-.271.194.213.213 0 0 0-.036.054l-.003.01z"></path>
					  <path d="M2.31 5.243A1 1 0 0 1 3.28 4H6a1 1 0 0 1 1 1v1a2 2 0 0 1-2 2h-.438a2 2 0 0 1-1.94-1.515L2.31 5.243zM9 5a1 1 0 0 1 1-1h2.72a1 1 0 0 1 .97 1.243l-.311 1.242A2 2 0 0 1 11.439 8H11a2 2 0 0 1-2-2V5z"></path>
					</svg></div>&nbsp;&nbsp;${faq.faq_title } <div class="pointer" style="float:right"><svg class="bi bi-caret-down-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path d="M7.247 11.14L2.451 5.658C1.885 5.013 2.345 4 3.204 4h9.592a1 1 0 0 1 .753 1.659l-4.796 5.48a1 1 0 0 1-1.506 0z"></path>
					</svg><svg style="display:none;" class="bi bi-caret-up-fill" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  <path d="M7.247 4.86l-4.796 5.481c-.566.647-.106 1.659.753 1.659h9.592a1 1 0 0 0 .753-1.659l-4.796-5.48a1 1 0 0 0-1.506 0z"></path>
					</svg></div>
				</button>
				<div class="panel" style="background-color:#effaf4;width:100%;">
				  <p style="font-weight:bold; padding-top:10px;"><b style="font-size:1.5em;color:blue;">A.</b> &nbsp;${faq.faq_contents }</p>

				</div>
			</c:forEach>
				<div style="width:100%;border-bottom:2px solid black;"></div>
				
		</div>
		<br>
<%--       <%@include file="pagination.jsp"%> --%>
<%--       <%@include file="list_js.jsp"%> --%>
   </div>
   
    -->
<script>


// 	   var acc = document.getElementsByClassName("accordion");
// 	var i;
	
// 	for (i = 0; i < acc.length; i++) {
// 	  acc[i].addEventListener("click", function() {
// 	    this.classList.toggle("active");
// 	    var panel = this.nextElementSibling;
// 	    if (panel.style.display === "block") {
// 	      $('.panel').slideUp();
// 	    } else {
// 	      $('.panel').slideDown();
// 	    }
// 	  });
// 	}

	$('.accordion').on('click',function(){
		if($(this).next('.panel').css('display')=='none'){
			$(this).next('.panel').slideDown();
			$('.bi-caret-down-fill',this).css('display','none');
			$('.bi-caret-up-fill',this).css('display','block');
		}else{
			$(this).next('.panel').slideUp();
			$('.bi-caret-down-fill',this).css('display','block');
			$('.bi-caret-up-fill',this).css('display','none');
		}
	});
	
	$(document).ready(function(e) {
		/* a요소를 클릭 했을 시 */
	    $('a').click(function(){
		/* iframe 요소의 src 속성값을 a 요소의 data-url 속성값으로 변경 */ 
        $('#iframe').attr('src',$(this).attr('data-url'));
        })
	});

		
	
</script>