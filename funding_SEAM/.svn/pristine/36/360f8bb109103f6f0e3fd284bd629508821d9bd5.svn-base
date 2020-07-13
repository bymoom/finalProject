<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>공지사항 ${notice.notice_num }번 편집하기</title>

<body>
	
	<!-- Page Content Begins -->
	<div class="justify-content-center" style="padding-bottoms:8px;">
	

		
<!-- <body style="margin:1px;"> -->
<!-- <div id="pageScroll" class="wrapper"> -->
<form role="form" id="modify" class="form-horizontal" action="modify" enctype="multipart/form-data" method="post">
	
	 <input type='hidden' name='notice_num' value ="${notice.notice_num}"> 
	 <input type='hidden' name='notice_num' value ="${notice.mem_num}"> 
<div class="row col-12">
	<div class="form-group bbsId" style="display:visible;">
		<label for="dms.subject" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label">
		구&nbsp;&nbsp;&nbsp;분</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<select id="point" name="point" >				
				<option value="0" ${notice.notice_point eq 0 ? 'selected':'' }>일반</option>
				<option value="1" ${notice.notice_point eq 1 ? 'selected':'' }>중요</option>
			</select>
		</div>
	</div> 
			<!-- 상단 우측버튼 -->
		<div class="row col-md-9">
			<div class="card-tools" style="width:100%;text-align:right;">
				<button type="button" class="btn btn-outline-success btn-flat" onclick="cancel_go();">
					<i class="grey ace-icon fa fa-times bigger-120"></i>&nbsp;<b>취소</b>
				</button>
					&nbsp;&nbsp;&nbsp;				
				<button type="button" class="btn btn-outline-success btn-flat" onclick="modify_go();">
					<i class="red ace-icon fa fa-check bigger-120"></i>&nbsp;<b>저장</b>
				</button>
			</div>
		</div>
	</div>
		<!-- 상단 우측버튼 -->	
	<div class="form-group">
		<label for="title" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">
		제&nbsp;&nbsp;&nbsp;목</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<input id="title" name="notice_title" class="form-control required" required="required" type="text" value="${notice.notice_title }"/>
		</div>
	</div>  
	<div class="form-group">
		<label for="content" class="col-xs-4 col-sm-2 control-label no-padding-right bolder g_label required">내 용</label>
		<div class="col-xs-8 col-sm-10 g_value">
			<textarea  rows="10" cols="" id="contents" name="notice_contents" class="form-control required" >${notice.notice_contents }</textarea>			
		</div>
	</div>  
	<br/>

 	<div class="form-group col-12">
		<i class="ace-icon fa fa-folder-open" style="font-size:18px;"></i>
		<!-- <i class="ace-icon fa fa-level-down" style="font-size:16px;"></i> -->
		<span style="">이곳에 파일을 끌어다 놓으십시오</span>
		<div class="fileDrop col-9">
		<ul class="mailbox-attachments clearfix uploadedList"></ul>
		</div>
	</div>		
	 
</form>

</div>


<%@ include file="/WEB-INF/views/board/notice/notice_modify_js.jsp" %>
<%@ include file="/WEB-INF/views/commons/summernote_js.jsp" %>

</body>







