<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	$(function(){
		/* 
		if($('#like').attr('for','0')){
			$('#like').css('color','');
		}
		if($('#like').attr('for','1')){
			$('#like').css('color','green');
		} */
		
		
		
		var mem_num = "${loginUser.mem_num}";
		var pjtprp_num = "${propose.pjtprp_num}";
		/* var likeButtonTag = '<a href="javascript:likeClick();" id="like" class="link-black text-sm col-sm-2"><i class="fas fa-thumbs-up mr-1"></i>${pps.pjtprp_like }</a>';
		var likeYetButtonTag = '<a href="javascript:likeYetClick();" id="likeYet" class="link-black text-sm col-sm-2"><i class="far fa-thumbs-up mr-1"></i>${pps.pjtprp_like }</a>'; */
		
		if(mem_num != ""){
			$.ajax({
				url : '<%= request.getContextPath() %>/propose/thumbUpSelect',
				type : 'post',
				data : {'mem_num' : mem_num,'pjtprp_num':pjtprp_num},
				success : function(data){
					if(data == "OK"){
						$('#like').css('color','green');
						$('#like').attr('for','1');
						$('#like').attr('title','응원하기 완료상태');
					}else{
						$('#like').css('color','black');
						$('#like').attr('title','응원하기');
						$('#like').attr('for','0');
					}
				},
				error : function(error){
					alert('다시 시도해주세요!');
				}
			})
		}
	}); 

	function thumbUp(){
		var loginUser = '${loginUser.mem_name}';
		if(loginUser==""){
			alert('로그인 후 이용가능합니다.');
			return false;
		}
		
		var pjtprp_num = "${propose.pjtprp_num}";
		var mem_num = "${loginUser.mem_num}";
		
		if($('#like').attr('for') == '1'){
			$.ajax({
				url :"<%=request.getContextPath()%>/propose/thumbUpCancel",
				type : 'post',
				data : {'pjtprp_num':pjtprp_num,'mem_num':mem_num},
				success : function(data){
					$('#like').css('color','black');
					$('#like').attr('title','응원하기');
					$('#like').attr('for','0');
				},
				error : function(error){
					alert('삭제실패..');
				}
				
			});
			return;
		}else{
		
		$.ajax({
			url :"<%=request.getContextPath()%>/propose/thumbUp",
			type : 'post',
			data : {'pjtprp_num':pjtprp_num,'mem_num':mem_num},
			success : function(data){
				$('#like').css('color','green');
				$('#like').attr('title','응원하기 완료상태');
				$('#like').attr('for','1');
				
			},
			error : function(error){
				alert('응원하기 실패..');
			}
			
			});
			
		}
		
	}
</script>