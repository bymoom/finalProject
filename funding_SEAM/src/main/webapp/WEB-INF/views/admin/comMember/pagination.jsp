<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.1.2/handlebars.min.js" ></script>
<script id="table-template" type="text/x-handlebars-template">
		{{#each .}}
				<tr style='font-size:0.85em;'>
					<td>{{mem_num}}</td>
					<td>{{code_state}}</td>
					<td><a href="#" onclick="OpenWindow('detail?mem_num={{mem_num}}','일반 회원 상세 보기','1400','900')">{{mem_name}}</a></td>
					<td>{{mem_email}}</td>
					<td><img src="https://source.unsplash.com/category/nature" style="width:100px;height:100px;"></td>
					<td>{{mem_phone}}</td>
					<td>
						<span class="description">{{prettifyDate mem_regdate}}</span>
					</td>
				</tr>
		{{/each}}
</script>
--%>

<nav aria-label="member list Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(1);">
			<i class="fas fa-angle-double-left"></i>
			</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.prev ? pageMaker.startPage-1 : 1}				
			);"><i class="fas fa-angle-left"></i></a>
		</li>
		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">						
		<li class="page-item 
			<c:out value="${pageMaker.cri.page == pageNum?'active':''}"/>">
			<a class="page-link page-num" href="javascript:searchList_go(${pageNum});" >${pageNum }</a>
		</li>
		</c:forEach>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
			${pageMaker.next ? pageMaker.endPage+1 : pageMaker.cri.page}			
			);"><i class="fas fa-angle-right" ></i></a>
		</li>
		<li class="page-item">
			<a class="page-link" href="javascript:searchList_go(
				${pageMaker.realEndPage});">
				<i class="fas fa-angle-double-right"></i></a>
		</li>	
	</ul>
</nav>

<form id="jobForm">
	<input type='hidden' name="page" value="${pageMaker.cri.page}" />
	<input type='hidden' name="perPageNum" value="${pageMaker.cri.perPageNum}"/>
	<input type='hidden' name="searchType" value="${pageMaker.cri.searchType }" />
	<input type='hidden' name="keyword" value="${pageMaker.cri.keyword }" />
	<input type='hidden' id="codeStateInput" name="code_state" value="${pageMaker.cri.code_state }" />
	<input type='hidden' name="first_mem_regdate" value="${pageMaker.cri.first_mem_regdate }" />
	<input type='hidden' name="last_mem_regdate" value="${pageMaker.cri.last_mem_regdate }" />
	<input type='hidden' name="com_state_code_val" value="${pageMaker.cri.com_state_code_val }" />
</form>


<script>
/**
 * 날짜 출력
 */
/* Handlebars.registerHelper("prettifyDate",function(mem_regdate){
	var dateObj=new Date(mem_regdate);
	var year=dateObj.getFullYear();
	var month=dateObj.getMonth()+1;
	var date=dateObj.getDate();
	return year+"/"+month+"/"+date;
}); */

/* 
$(document).ready(function() {
    $('#codeState').change(codeStateChange);
    alert("시작할 때 파라미터 값 : ${param.code_state}");
})

function codeStateChange() {
    var codeState = $('#codeState option:selected').val();
    alert("codeState : " + codeState);
    $('#codeStateInput').val(codeState);
}; */

/**
 * 소상공인 가입 승인 대기자 리스트 출력
 */
function roleComHoldList_go(page, url){
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val("all");
	jobForm.find("[name='keyword']").val("");
	jobForm.find("[name='code_state']").val("");
	jobForm.find("[name='first_mem_regdate']").val("");
	jobForm.find("[name='last_mem_regdate']").val("");
	jobForm.find("[name='com_state_code_val']").val("미승인"); //미승인(대기중)

	jobForm.attr("method","post");
	
	if(url){
		jobForm.attr("action",url);		
	}else{
		jobForm.attr("action",'list');		
	}
	
	jobForm.submit();
}

/**
 * 검색 버튼 누른 경우
 */
function searchList_go(page,url){

	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(page);
	jobForm.find("[name='searchType']").val($('select[name="searchType"]').val());
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	jobForm.find("[name='code_state']").val($('select[name="code_state"]').val());
	jobForm.find("[name='first_mem_regdate']").val($('input[name="first_mem_regdate"]').val());
	jobForm.find("[name='last_mem_regdate']").val($('input[name="last_mem_regdate"]').val());
	jobForm.find("[name='com_state_code_val']").val($('select[name="com_state_code_val"]').val());

	jobForm.attr("method","post");
	
	if(url){
		jobForm.attr("action",url);		
	}else{
		jobForm.attr("action",'list');		
	}
	
	jobForm.submit();
	
	
<%-- 	if(url == "stateList"){
		var jobForm=$('#jobForm');
		jobForm.find("[name='page']").val(page);
		jobForm.find("[name='searchType']").val($('#stateCode').val());
		
		
		/* alert("선택된 값 : " + $('select[name="stateCode"]').val());
		alert("저장한 값 : " + jobForm.find("[name='searchType']").val()); */
		$.ajax({
			url : '<%= request.getContextPath() %>/admin/member/stateList',
			type : 'post',
			data : jobForm.serialize(),
			dataType : 'json',
			success : function(data){
				//alert("성공");
				var htmlStr = "<tr><td colspan='7'><strong>해당 내용이 없습니다.</strong></td></tr>";
				console.log(data.memberList.length);
				alert(typeof data.memberList);
				if(data.memberList.length > 0){
					var template=Handlebars.compile($('#table-template').html());
					var html=template(data.memberList);
					alert("aaaa" + html);
					$("tbody").empty();
					$("tbody").append(html);
					
					$(".page-num").attr('href', 'javascript:searchList_go(1,"stateList");');
				}else {
					alert("bbbb"+htmlStr);
					$("tbody").empty();
					$("tbody").append(htmlStr);
					$("")
				}
				
				/* Handlebars.registerHelper("nullCheck",function(list){
					
					var result=1;
					
					if(list == null || list.length == 0){
						result=null;
					}
					console.log(result);
					return result;
				}); */
				
				
			},
			error : function(error){
				alert("에러");
			}
			
		})
	} --%>

}
</script>