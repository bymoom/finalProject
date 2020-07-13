<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
<style>
.projectCard:hover {
  border:2px solid #28a745;
}
#pjtList li { 
	width:100px; 
	font-size:0.7em;
}
#pjtList a{
	color:black;
}
.active#c{
	border-radius: 25px;
	font-weight: bold;
	color:#28a745;
}
</style>
</head>
<body>

<div class="container">
<label class="row justify-content-md-center m-5"><h2 style="color: #4f4f4f;">소소한 마음이 모여 만드는 큰 희망</h2></label>
<nav class="navbar navbar-expand-lg rounded"  style="background:#f1f1e4;">
    <!-- <a class="navbar-brand" href="javascript:category('all');">전체</a> -->
    <button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#pjtList" aria-controls="#pjtList" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="navbar-collapse collapse justify-content-md-center" id="pjtList" style="font-size:1.2em;">
      <ul class="navbar-nav mr-auto text-center">
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == ''?'border border-success active':''}" href="javascript:category('all');">
    	<i class="fas fa-asterisk" style="font-size:1.5em;"></i>   <br>   
          전체 <span class="sr-only">(current)</span></a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '음식점'?'border border-success active':''}" href="javascript:category('음식점');">
          <i class="fas fa-utensils" style="font-size:1.5em;"></i><br>
       		   <strong>음식점</strong></a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '서비스/문화'?'border border-success active':''}" href="javascript:category('서비스/문화');">
          <i class="fas fa-user-friends" style="font-size:1.5em;"></i><br>
          	서비스/문화</a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '도소매'?'border border-success active':''}" href="javascript:category('도소매');">
    	<i class="fas fa-shopping-cart" style="font-size:1.5em;"></i><br>      
        	  도소매</a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '교육'?'border border-success active':''}" href="javascript:category('교육');">
    	<i class="fas fa-graduation-cap" style="font-size:1.5em;"></i><br>  
          	교육</a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '제조'?'border border-success active':''}" href="javascript:category('제조');">
    	<i class="fas fa-cogs" style="font-size:1.5em;"></i><br>      
          	제조</a>
        </li>
        <li class="nav-item" style="border-radius: 100px; background:#FFFfff; margin:10px;">
          <a id="c" class="nav-link ${pjtPageMaker.pjtCri.categoryType == '기타'?'border border-success active':''}" href="javascript:category('기타');">
    	<i class="fab fa-qq" style="font-size:1.5em;"></i><br>    
                    기타</a>
        </li>

      </ul>
      <form class="form-inline my-5 my-md-0">
	            <div class="input-group input-group-sm col-10">
	              <input class="form-control form-control-navbar col-9" style="width:180px;outline: 0;border-width: 0 0 2px;" type="search" placeholder="프로젝트 검색" aria-label="Search" onkeyup="enterkey();" >
	              <div class="input-group-append">
	                <button class="btn btn-navbar" type="button" id="searchBtn">
	                  <i class="fas fa-search"></i>
	                </button>
	              </div>
      </form>
	            </div>
    </div>
  </nav>
</div>            
                
		<div class="album py-5">
		  <div class="container">
		      <div class="row contents text-center">
		
		      </div>
		  </div>
		</div>
                
    <form id="jobForm">
		  <input type='hidden' name="page" value="${pjtPageMaker.pjtCri.page}" />
		  <input type='hidden' name="perPageNum" 
		  		 value="${pjtPageMaker.pjtCri.perPageNum}"/>
		  <input type='hidden' name="categoryType" 
		         value="${pjtPageMaker.pjtCri.categoryType }" />
		  <input type='hidden' name="keyword" 
		         value="${pjtPageMaker.pjtCri.keyword }" />
	</form>
	<form style="display: hidden" method="POST" id="detailform">
	  <input type="hidden" name="pjt_num" value=""/>
	</form>
            
<%@ include file="./list_js.jsp" %>
            
</body>

