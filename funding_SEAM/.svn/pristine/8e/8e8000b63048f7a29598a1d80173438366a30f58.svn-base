<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<br>
<div style="width:100%; text-align:center;">
	<h3>${propose.pjtprp_title }</h3>
</div>    



<div style="width:100%; text-align:right; margin-right:10px;">

	
</div>
<!-- Main content -->
<section class="content container-fluid">
	
	<div class="row justify-content-center">
		
		<div class="col-md-9" style="max-width:960px;">
							
				<div class="form-group" style="margin-right:40px;">
							<div class="form-group" style="text-align:right;">
								<c:if test="${loginUser.mem_name eq '관리자' }">
									<button id="success" type="button" class="btn btn-outline-success btn-flat">등록완료</button>
								</c:if>
								<c:if test="${propose.mem_name eq loginUser.mem_name }">
										<button id="proposeUpdate" type="button" class="btn btn-outline-success btn-flat">수정</button>
										<button id="proposeDelete" type="button" class="btn btn-outline-success btn-flat">삭제</button>
									</c:if>
							</div>
				</div>	
				<div class="">
						<hr>
					<form role="form" method="post" action="<%=request.getContextPath() %>/menu/proposeRegist" name="registForm">
						<div style="text-align:left;">
								<span><fmt:formatDate value="${propose.pjtprp_regdate }" pattern="yyyy-MM-dd"></fmt:formatDate></span>
								<span>${propose.mem_name }</span>
							</div>
						<div style="width:100%;text-align:right;">
							<a href="javascript:thumbUp();" id="like" class="link-black text-sm col-sm-2" for="0" style="color:black;margin-left:25px;"><i class="fas fa-thumbs-up mr-1"></i>응원하기</a><br><br>
						</div>
						<input type="text" id="writer" readonly name="mem_name" class="form-control" value="${propose.mem_name }" style="display:none;">
						<div class="form-group">
							<input type="text" id="title" name='pjtprp_title' class="form-control" value="${propose.pjtprp_title }" style="display:none;">
						</div>							
						<br>
						<div>${propose.pjtprp_contents }</div>
					</form>
					<br>
					<div class="border-top border-bottom row">
						<table>
							<tbody>
								<tr>
									<td><i class="fas fa-angle-up"></i>&nbsp;<a href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num=${preOrNext.pre_no}">이전글 : ${preOrNext.pre_title }</a></td>
								</tr>
								<tr style="height:5px;"><td></td></tr>								
								<tr>
									<td><i class="fas fa-angle-down"></i>&nbsp;<a href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num=${preOrNext.next_no}">다음글 : ${preOrNext.next_title }</a></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
					
					
	<div id="commentArea">
	
	<!-- 의견 쓰기 -->
	<form id="bbsCommentWebForm" class="form-horizontal" action="/bbs/read.htm?docId=2018042316273647&amp;bbsId=bbs00000000000004&amp;workType=1&amp;moduleId=00000000000000&amp;categoryId=&amp;searchRange=0&amp;listType=L&amp;searchKey=subject&amp;searchValue=" method="post">
<!-- 		<div class="panel panel-info" style="margin:5px 0px;"> -->
<!-- 	      <div class="panel-heading"> -->
<%-- 	        <h4 class="panel-title" style="font-size:14px; font-family: inherit;" id="panel-title">
	        	<i class="ace-icon fa fa-quote-left smaller-80"></i>
	        	댓글	- <span id="cmtnum" style="color:#FF6600;">${board.replycnt }</span> 개의 의견이 있습니다.
			 
	        </h4> --%>
<!-- 	      </div> -->
	      <div class="panel-body" style="padding: 5px;">			
			<div class="panel-body row">		
					<div class="input-group input-group-sm col-10">
						<textarea class="form-control" rows="3" wrap="hard" placeholder="Enter ..." id="pjtprp_cmts_contents" name="pjtprp_cmts_contents"></textarea>
						<br>
						<div class="input-group-append">
	                      <button type="button" class="btn btn-outline-success btn-flat" onclick="reply_regist_go();">댓글작성</button>
	                    </div>
					</div>
			      </div>
			<a id="editButton" style="display:none;" href="javascript:goCommentSubmit('edit','')">편집</a>		
			<font color="#656565">현재 <span id="tmptext">0</span>/최대 1000byte(한글 500자, 영문 1000자)</font><br>
			</div>
			<c:if test="${loginUser.mem_name eq '관리자' }">
				<div id="commentSave" style="margin:8px; text-align:left;">
					
					<button type="button" class="btn btn-outline-success btn-flat" onclick="proposeCmtDisabled();" title="disabled">
						댓글 블라인드
					</button>
				</div>
			</c:if>			
	      </div>
	      <br>
	      
		<!-- 	게시판 이미지 max-width 설정 2018-01-15 -->
		<style>
			img{max-width: 820px;}
		</style>
		
		<div id="comment-tab___" class="tab-pane___ active___" style="margin: 5px 10px;">
			<div class="comments___ ace-scroll___" style="position: relative;">
			<div class="scroll-track___ scroll-active___" style="display: block; sheight: 300px;">
			<div class="scroll-bar___" style="sheight: 232px; top: 0px;"></div>
			</div>
			<div id="repliesDiv" class="scroll-content___" style="smax-height: 300px;">				
			</div>
<!-- 			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">
	
				</ul>
			</div> -->									
		</div>		
	</div>	
	<br>
	<div style="width:100%;text-align:center;">
						<button type="button" class="btn btn-outline-success btn-flat" onclick="goList();">목록</button>
					</div>	  
					<br>    
<!-- </div> -->
     
</form>

</div>
<!-- 간단한 의견 목록 끝 -->
</div>

<!-- 댓글 Modal -->
<div id="modifyModal" class="modal fade in" >
  <div class="modal-dialog">
    Modal content
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title"></h4>
        <button type="button" class="close" data-dismiss="modal">&times;</button>        
      </div>
      <div class="modal-body" data-pjtprp_cmts_num>
        <p><input type="text" id="modal_pjtprp_cmts_contents" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">수정완료</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">삭제</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>            
				<div class="card-footer" style="display:none">
				
				</div><!--end card-footer  -->
			</div><!-- end card -->				
		</div><!-- end col-md-12 -->
	</div><!-- end row -->
</section>
<!-- /.content -->
<%@ include file="reply.jsp" %>
<%@include file="detail_js.jsp" %>
<script>
/* 수정 버튼 클릭 */
$('#proposeUpdate').on('click',function(){
	location.href="/menu/modify?pjtprp_num=${propose.pjtprp_num}";
});

/* 삭제버튼 클릭 */
$('#proposeDelete').on('click',function(){
	var answer = confirm("정말 삭제하시겠습니까?");
	
	if(answer){
		location.href="/menu/delete?pjtprp_num=${propose.pjtprp_num}";
	}
});

$('#success').on('click',function(){
	
	var ask = confirm('프로젝트 등록완료 처리 하시겠습니까?');
	
	if(ask){
		location.href="<%=request.getContextPath()%>/propose/success?pjtprp_num=${propose.pjtprp_num}";
	}
	
});

$('#prev').on('click',function(){
	var pjtprp_num = ${propose.pjtprp_num} -1;
	
	if(pjtprp_num < 1){
		alert('이전글이 없습니다.');
		return false;
	}
	
	$.ajax({
		url:'<%=request.getContextPath()%>/propose/prev?pjtprp_num='+pjtprp_num,
		type:'post',
		success:function(){
			location.href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num="+pjtprp_num;
		},
		error:function(){
			var ask = confirm('이전글이 없습니다.\n그 이전글로 이동 하시겠습니까?');
			pjtprp_num -= 1;
			if(ask){
				$.ajax({
					url:'<%=request.getContextPath()%>/propose/prev?pjtprp_num='+pjtprp_num,
					type:'post',
					success:function(){
						location.href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num="+pjtprp_num;
					},
					error:function(){
						alert('이전글이 없습니다.');
					}
				});
			}
		}
	});
	
});
$('#next').on('click',function(){
	var pjtprp_num = ${propose.pjtprp_num} +1;
	$.ajax({
		url:'<%=request.getContextPath()%>/propose/prev?pjtprp_num='+pjtprp_num,
		type:'post',
		success:function(){
			location.href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num="+pjtprp_num;
		},
		error:function(){
			var ask = confirm('다음글이 없습니다.\n그 다음글로 이동 하시겠습니까?');
			pjtprp_num += 1;
			if(ask){
				$.ajax({
					url:'<%=request.getContextPath()%>/propose/prev?pjtprp_num='+pjtprp_num,
					type:'post',
					success:function(){
						location.href="<%=request.getContextPath()%>/menu/proposeDetailForEnabled?pjtprp_num="+pjtprp_num;
					},
					error:function(){
						alert('다음글이 없습니다.');
					}
				});
			}
		}
	});
});

function goList(){
	location.href="<%=request.getContextPath()%>/menu/propose";
}




</script>