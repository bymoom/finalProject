<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>
 <h2 style="margin-left:20px;color:#4f4f4f;" class="text-center">포인트 관리</h2>
 <br>
	<div class="container">
		<div style="text-align:right;">
			<button type="button" class="btn btn-secondary" id="saveBtn">저장</button>
		</div>
	 <table class="table table-head-fixed text-center">
	 	<tr>
	 		<th>유형</th>
	 		<th>사용유무</th>
	 		<th>포인트</th>
	 	</tr>
	 	
	 	<tr>
	 		
	 		<th>회원가입 포인트지급</th>
	 		<c:if test="${join.pointmng_enabled eq 1}">
	 			<td>
					<input type="radio" id="checkUse" name="check" value="사용" checked="checked" onclick="checkuse();"><b>사용</b> &nbsp;
					<input type="radio" id="checkNotUse" name="check" value="미사용" onclick="checkNotuse();"><b>미사용</b>
				</td>
				<td>	
					<input style="border-radius:10px;border:1px solid gray;background-color:lightgray;" type="text" id="point" value="${join.point }" readonly> <b>포인트</b>
				</td>
				</c:if>
				
				<c:if test="${join.pointmng_enabled eq 0}">
				<td>
					<input type="radio" id="checkUse" name="check" value="사용" onclick="checkuse();"><b>사용</b> &nbsp;
					<input type="radio" id="checkNotUse" name="check" value="미사용" checked="checked" onclick="checkNotuse();"><b>미사용</b><br>
				</td>
				<td>
					<input style="border-radius:10px;border:1px solid gray;background-color:lightgray;" type="text" id="point" placeholder="지급할 포인트를 입력.." readonly> <b>포인트</b>
				</td>
				</c:if>
			
	 	</tr>
	 	<tr>
	 		<th>출석체크 포인트지급</th>
	 		<c:if test="${attend.pointmng_enabled eq 1 }">
				<td>
					<input type="radio" id="checkUse2" name="check1" value="사용" checked="checked" onclick="checkuse1();"><b>사용</b> &nbsp;
					<input type="radio" id="checkNotUse2" name="check1" value="미사용" onclick="checkNotuse1();"><b>미사용</b><br>
				</td>
				<td>
					<input style="border-radius:10px;border:1px solid gray;background-color:lightgray;" type="text" id="pointAttend" value="${attend.point }" readonly> <b>포인트</b>
				</td>
				</c:if>
				<c:if test="${attend.pointmng_enabled eq 0 }">
				<td>
					<input type="radio" id="checkUse2" name="check1" value="사용" onclick="checkuse1();"><b>사용</b> &nbsp;
					<input type="radio" id="checkNotUse2" name="check1" value="미사용" checked="checked" onclick="checkNotuse1();" ><b>미사용</b><br>
				</td>					
				<td>
					<input style="border-radius:10px;border:1px solid gray;background-color:lightgray;" type="text" id="pointAttend" placeholder="지급할 포인트를 입력.." readonly> <b>포인트</b>
				</td>
			</c:if>
	 	</tr>
	 </table>
	 	

		
</div>
<%@include file="point_js.jsp"%>

<script>
	
</script>
