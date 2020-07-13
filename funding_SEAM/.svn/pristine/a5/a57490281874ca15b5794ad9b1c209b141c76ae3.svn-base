<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>

		<div class="album py-5 bg-light">
		    <div class="container">
		      <div class="row contents text-center">
		      
		 <div class="col-md-6" onclick="donationPjt();">
          <div class="card mb-6 shadow-sm  projectCard" style="cursor:pointer;">
           	 <img src="/resources/images/dona.png" width="100%" height="150" />
                   <div class="card-body">
				 	<h3>후원형</h3>
            </div>
          </div>
        </div>
        		 <div class="col-md-6" onclick="loanPjt();">
          <div class="card mb-6 shadow-sm  projectCard" style="cursor:pointer;">
            <img src="/resources/images/loan.png" width="100%" height="150" />
                   <div class="card-body">
				 	<h3>대출형</h3>
            </div>
          </div>
        </div>
		        
		
		      </div>
		    </div>
		  </div>

<script>
function donationPjt(){
	if(!'${loginUser.mem_num}'){
		alert('로그인이 필요합니다.');
		return;
	}
	location.href='/mypage/project/projectRegistForm_donation?mem_num=${loginUser.mem_num }';
}

function loanPjt(){
	if(!'${loginUser.mem_num}'){
		alert('로그인이 필요합니다.');
		return;
	}
	location.href='/mypage/project/projectRegistForm_loan?mem_num=${loginUser.mem_num }';
}


</script>
</body>
