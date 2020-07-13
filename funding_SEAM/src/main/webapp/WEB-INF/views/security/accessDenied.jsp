<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>권한이 유효하지 않습니다.</h1>
	<br/>
	<a href="javascript:go_back();">[뒤로 가기]</a>
	
	<script>
		function go_back(){
			if(window.opener && history.length==1){				
				window.close();
			}else{
				history.go(-1);
			}
		}
	</script>
</body>
</html>