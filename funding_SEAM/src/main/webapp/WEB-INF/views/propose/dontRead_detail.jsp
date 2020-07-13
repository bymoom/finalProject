<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>

	alert("해당 게시글은 비활성화 된 글 입니다..");
	if(window.open){
		window.close();
	}else{
		history.go(-1);
	}
</script>