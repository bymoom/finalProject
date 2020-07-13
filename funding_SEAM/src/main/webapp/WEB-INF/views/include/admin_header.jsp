<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html lang="en">
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta property="og:site_name" content=""/>
	<meta property="og:title" content="FunSEAMding - "/>    
	<meta property="og:description" content="" />
	<meta property="article:author" content="" />
	<meta property="og:url" content="" />
	<meta property="og:image" content="http://placeimg.com/600/400/any" />
	
  <title>FunSEAMding</title>

  <!-- jQuery -->
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>

  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/ion-rangeslider/css/ion.rangeSlider.min.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap-slider/css/bootstrap-slider.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/styles.css">
	
	<!-- Date Picker css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery-ui/jquery-ui.css">
	
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	
	<!-- Date Picker -->
	<!-- jquery UI CDN -->
	<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!-- 언어 별 CDN -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.9.2/i18n/jquery.ui.datepicker-ko.min.js"></script>
	<!-- Date 라이브러리 -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
	
</head>


                    <nav class="navbar navbar-expand navbar-dark bg-dark" style="height: 40px;">
                    	<div class="container">
				        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample10" aria-controls="navbarsExample10" aria-expanded="false" aria-label="Toggle navigation">
				          <span class="navbar-toggler-icon"></span>
				        </button>
				        <div class="collapse navbar-collapse justify-content-md-end" id="navbarsExample10">
					        <ul class="navbar-nav">
		                        <c:if test="${!empty loginUser }">
		                        	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">${loginUser.mem_name }님</a></li>
		                        </c:if>
<%-- 		                        <c:if test="${loginUser.mem_num eq 1 }">
		                        	<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath() %>/admin/main">관리자 페이지</a></li>
		                        </c:if>
		                        <c:if test="${!empty loginUser }">
		                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#portfolio">MYPAGE</a></li>
		                        </c:if> --%>
		                        <li class="nav-item mx-0 mx-lg-1">
					              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="https://dashboard.tawk.to/#/dashboard/5eccaa688ee2956d73a49111" target="_blank">실시간 상담</a>
					            </li>
		                         <c:if test="${empty loginUser }">
		                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath() %>/commons/loginForm">LOGIN</a></li>
		                        </c:if>
		                         <c:if test="${!empty loginUser }">
		                        <li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="<%=request.getContextPath() %>/commons/logout">LOGOUT</a></li>
		                        </c:if>
	                    	</ul>
				          </div>
				        </div>
				      </nav>
				      
				<nav class="navbar navbar-expand-lg rounded">
				      <div class="container">
				        <a class="navbar-brand js-scroll-trigger" href="<%=request.getContextPath()%>/admin/main">
				        	<img src="<%=request.getContextPath()%>/resources/images/funseamding3.png" style="width: 250px;">
				        </a>
				        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample09" aria-controls="navbarsExample09" aria-expanded="false" aria-label="Toggle navigation">
				          <span class="navbar-toggler-icon"></span>
				        </button>
				
				        <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample09">
				          <ul class="navbar-nav p-4" style="font-size:1.1em; color:success;">
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/member/list">회원 관리</a>
				            </li>
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/project/list">프로젝트 관리</a>
				            </li>
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/pay/list">결제 내역 관리</a>
				            </li>
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/point/main">포인트 관리</a>
				            </li>
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/popup/list">팝업 관리</a>
				            </li>
				            <li class="nav-item m-2">
				              <a class="nav-link font-weight-bold" href="<%=request.getContextPath()%>/admin/banner/list">배너 관리</a>
				            </li>
				          </ul>
				        </div>
				        </div>
				      </nav>
	
            
<body class="hold-transition sidebar-mini">
<hr>            
