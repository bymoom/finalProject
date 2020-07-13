<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script>
	alert("회원가입 축하 포인트가 지급되었습니다.\n${member.mem_email}님 회원등록이 정상적으로 완료되었습니다.");
	window.location.href="<%=request.getContextPath()%>/main";
</script>