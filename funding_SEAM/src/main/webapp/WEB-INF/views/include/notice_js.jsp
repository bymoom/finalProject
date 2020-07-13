<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script type="text/x-handlebars-template" id="notice-list-template">
{{#each .}}
       <li style="list-style: none; color:white;"><a class="text-white" 
			href="<%=request.getContextPath() %>/board/notice/detail?notice_num={{notice_num}}">
				{{notice_title}}</a></li>

{{/each}}
</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery.vticker-min.js" ></script>
<script>
var printDataa=function(replyArr,target,templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);	
	target.append(html);
}

$(document).ready(function(){
	$.ajax({
		url:'/footerNotice',
		type:"get",
		success:function(data){
			printDataa(data.noticeList,$('.notice-list'),$('#notice-list-template'));
		},
		error:function(error){
			alert('서버장애로 공지사항 로드를 실패하였습니다.');
		}
	});
});

$('.myclass').vTicker({
	   speed: 500,
	   pause: 3000,
	   showItems: 1,
	   animation: 'fade',
	   mousePause: false,
	   height: 28,
	   direction: 'up'
	});

</script>