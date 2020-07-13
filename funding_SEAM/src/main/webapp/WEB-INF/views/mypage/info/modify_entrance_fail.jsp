<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("아이디 또는 패스워드가 일치하지 않습니다.");
	window.location.href="<%=request.getContextPath()%>/mypage/info/beforeDetail";
</script>