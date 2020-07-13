<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--  onclick="javascript:location.href='/qna/registForm';" -->
<div class="container">
<!-- 상단 우측버튼 -->
<br>
	<div class="row justify-content-md-center">

		<a href="<%=request.getContextPath()%>/board/notice/notice_list">
			<button class="btn btn-outline-success btn-flat" style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">공지사항</button>
		</a> 
		<a href="<%=request.getContextPath()%>/FAQ/list">
			<button class="btn btn-outline-success btn-flat" style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">F A Q</button>
		</a>
		 <a href="<%=request.getContextPath()%>/qna/list">
			<button class="btn btn-outline-success btn-flat" style="width: 150px; border-radius: 25px; border: 3px double green; margin: 5px;" type="button">Q & A</button>
		</a>
	</div>

	<!-- Page Path Begins -->
<div class="container" style="min-height:800px;">
	<div class="justify-content-md-center" style="padding:40px;">
		<h2 class="page-section-heading text-center text-primary text-secondary mb-0">Q & A</h2>
	</div>
	<div class="col-sm-12" >
		<c:if test="${loginUser.mem_num eq 1}">
			<button type="button" class="btn btn-outline-success btn-flat" id="checkBtn" onclick="enabled();">게시글 활성</button>&nbsp;
			<button type="button" class="btn btn-outline-success btn-flat" id="checkBtn" onclick="dis();">비활성</button>&nbsp;
			<span>체크박스를 클릭하여 게시물의 활성/비활성을 관리하세요(체크: 비활성/ 해제: 활성) </span>&nbsp;
		</c:if>	
		</div>
	<div class="row" style="padding: 20px;">
	<div class="col-sm-3">
			<button type="button" class="btn btn-outline-success btn-flat float-left" id="registBtn">질문등록</button>
	</div>
	<div class="col-sm-9" >
			<div id="keyword" class="input-group" style="width:400px;float:right;" >
					<select class="form-control" name="searchType" id="searchType" style="border:none;">
						<option value="tcw"  ${pageMaker.cri.searchType eq 'tcw' ? 'selected':'' }>전 체</option>
						<option value="t" ${pageMaker.cri.searchType eq 't' ? 'selected':'' }>제 목</option>
						<option value="w" ${pageMaker.cri.searchType eq 'w' ? 'selected':'' }>작성자</option>
						<option value="c" ${pageMaker.cri.searchType eq 'c' ? 'selected':'' }>내 용</option>
						<option value="tc" ${pageMaker.cri.searchType eq 'tc' ? 'selected':'' }>제목+내용</option>
						<option value="cw" ${pageMaker.cri.searchType eq 'cw' ? 'selected':'' }>작성자+내용</option>							
					</select>							
					<input  class="form-control" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${pageMaker.cri.keyword }" style="width:150px;outline: 0;border-width: 0 0 2px;"/>
					<span class="input-group-append">
						<button class="btn" type="button" onclick="searchList_go(1,'list');" data-card-widget="search"><i class="fas fa-search"></i></button>
					</span>
				</div>
		</div>	
		
	</div>
		<br>			
<div class="table-responsive">

	<table class="table table-head-fixed border-bottom">
		<colgroup>

			<col style="width:5%;" />
			
			<col style="width:8%;" />

			<col style="width:auto; align:left;" />

			<col style="width:10%;" />

			<col style="width:12%;" />

			<col style="width:8%;" />
			<col style="width:10%;" />

		</colgroup>
	<thead class="">
	<tr>
	 <th><input type='checkbox' id='checkAll' name='checkAll'></th>
	 <th>번호</th>
	 <th>제&nbsp;&nbsp;목</th>
	 <th>작성자</th>
	 <th>작성일</th>
	 <th>조회수</th>
	 <th>공개</th>
	 </tr>
	 </thead>
	<tbody>
		<c:choose>
			<c:when test="${empty list }">
				<tr>
					<td colspan="7" align="center">no data</td>
				</tr>
			</c:when>

			<c:when test="${!empty list }">
			<c:if test="${loginUser.mem_num ne 1}">
				<c:forEach items="${list }" var="qna">
					<c:if test="${qna.qna_enabled eq 1}"> 

									<tr>
										<td></td>
										<td>${qna.qna_num }</td>
										<%-- 								<c:if test="${qna.qna_secret eq 1 or 관리자 }"> --%>
										<c:if test="${qna.qna_secret eq 1 }">
											<td id="qnatitle"><a href="<%= request.getContextPath() %>/qna/detail?qna_num=${qna.qna_num }">
													<span>${qna.qna_title }</span>
											</a></td>
										</c:if>
										<%-- 								<c:if test="${qna.qna_secret eq 0 and 관리자가 아니고}"> --%>
										<c:if test="${qna.qna_secret eq 0 }">
											<td id="qnatitle"><a href="/qna/pwdChk?qna_num=${qna.qna_num }"> <span>${qna.qna_title }</span>
											</a></td>
										</c:if>
									
										<td>${qna.mem_name }</td>
										<td><fmt:formatDate value="${qna.qna_regdate }" pattern="yyyy-MM-dd"></fmt:formatDate>
										</td>
										<td>${qna.qna_view_cnt }</td>

										<c:if test="${qna.qna_secret eq 1 }">
											<td><img alt=""
												src="<%=request.getContextPath()%>/resources/images/unlock.png"
												style="width: 30px; height: 30px;"></td>
										</c:if>
										<c:if test="${qna.qna_secret eq 0 }">
											<td><img alt=""
												src="<%=request.getContextPath()%>/resources/images/lock.png"
												style="width: 30px; height: 30px;"></td>
										</c:if>


									</tr>
							</c:if> 
									</c:forEach>
						</c:if>
							
						<c:if test="${loginUser.mem_num eq 1}">
						<c:forEach items="${list }" var="qna">
						
						<tr style='font-size:0.85em;'>
						
								<c:if test="${qna.qna_enabled eq 1 }">
									<td><input type='checkbox' name='check' value='${qna.qna_num }'></td>
								</c:if>
								<c:if test="${qna.qna_enabled eq 0 }">
									<td><input type='checkbox' name='check' value='${qna.qna_num }' checked></td>
								</c:if>
							
							
							<td>${qna.qna_num }<input type="hidden" name="qna_num" value="${qna.qna_num }"></td>
							
										<%-- 								<c:if test="${qna.qna_secret eq 1 or 관리자 }"> --%>
										<c:if test="${qna.qna_secret eq 1 or loginUser.mem_num eq 1}">
											<td id="qnatitle"><a
												href="<%= request.getContextPath() %>/qna/detail?qna_num=${qna.qna_num }">
													<span>${qna.qna_title }</span>
											</a></td>
										</c:if>
										<%-- 								<c:if test="${qna.qna_secret eq 0 and 관리자가 아니고}"> --%>
										<c:if test="${qna.qna_secret eq 0 and loginUser.mem_num ne 1 }">
											<td id="qnatitle"><a
												href="/qna/pwdChk?qna_num=${qna.qna_num }"> <span>${qna.qna_title }</span>
											</a></td>
										</c:if>
								
							
										<td>${qna.mem_name }</td>
										<td><fmt:formatDate value="${qna.qna_regdate }"></fmt:formatDate>
										</td>
										<td>${qna.qna_view_cnt }</td>

										<c:if test="${qna.qna_secret eq 1 }">
											<td><img alt=""
												src="<%=request.getContextPath()%>/resources/images/unlock.png"
												style="width: 30px; height: 30px;"></td>
										</c:if>
										<c:if test="${qna.qna_secret eq 0 }">
											<td><img alt=""
												src="<%=request.getContextPath()%>/resources/images/lock.png"
												style="width: 30px; height: 30px;"></td>
										</c:if>

							</tr>
						</c:forEach>
							</c:if>
			
			</c:when>
		</c:choose>
		
	</tbody>
	
</table>
</div>
<%@include file="/WEB-INF/views/qna/pagination.jsp" %>
</div>
</div>

	<script>
//	alert('${qna.mem_num}');
		$("#registBtn").on('click', function(){
			if("${loginUser}"==""){
				alert('로그인이 필요한 기능입니다')
				location.href='/commons/loginForm';
				return;
			}else{
				location.href='/qna/registForm';
				return;
				
			}
	//		alert('registBtn clicked')
	//		OpenWindow('regist','질문작성',600,400);
		});
		
		$('#checkAll').on('click',function(){
			if($('#checkAll').is(":checked")){
				 $("input[name='check']").prop("checked", true);
		     }else{
		         $("input[name='check']").prop("checked", false);
				
			}
		});
		
		function enabled(){
			var falseChecked = new Array();
    		
    		if($(':checkbox[name="check"]').is(':checked')){
    				$(':checkbox[name="check"]:checked').each(function(i,e){
    					falseChecked.push(e.value);
    				});
    			} else {
    				alert("선택된 글이 없습니다.");
    				return;
    			}
    		
    		var json={"falseChecked":falseChecked};
    				  
			$.ajax({
				url:"enabled",
				type:'post',
				data:JSON.stringify(json),
				contentType:'application/json',
				success:function(){
					alert('해당 게시물이 활성화되었습니다');
				},
				error:function(){
					
				}
			});
    		
		}
			

		function dis() {
			var trueChecked = new Array();

			if($(':checkbox[name="check"]').is(':checked')){
				$(':checkbox[name="check"]:checked').each(function(i,e){
					trueChecked.push(e.value);
				});
			} /* else {
				alert("선택된 글이 없습니다.");
				return;
			} */
			var json = {"trueChecked" : trueChecked};

			$.ajax({
				url: 'disabled',
				type: 'post',
				data: JSON.stringify(json),
				contentType: 'application/json',
				success: function() {
					alert('해당 게시물이 비활성화 처리 되었습니다');
				},
				error : function() {

				}
			});

		}
	</script>
	<div class="card-footer" style="display:none"></div>
