<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	alert('출석체크시 포인트 지급을 시작합니다.');
	location.href="<%=request.getContextPath()%>/admin/point/main";
</script>