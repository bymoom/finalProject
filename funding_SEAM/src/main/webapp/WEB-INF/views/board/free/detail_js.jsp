<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script type="text/javascript">

	var free_num = ${freeBoard.free_num};
	var mem_num = "${loginUser.mem_num}";

	var likeButtonTag = '<a href="javascript:likeClick();" id="like" class="link-black text-sm col-sm-2"><i class="fas fa-thumbs-up fa-2x"></i>${freeBoard.free_like } Like</a>';
	var likeYetButtonTag = '<a href="javascript:likeYetClick();" id="likeYet" class="link-black text-sm col-sm-2"><i class="far fa-thumbs-up fa-2x"></i>${freeBoard.free_like } Like</a>';
	
	$(document).ready(function(){
		//좋아요 버튼 세팅(success : 좋아요 누른 상태 / error : 좋아요 안 누른 상태)
		if(mem_num != ""){
			$.ajax({
				url : '<%= request.getContextPath() %>/board/free/thumbUpSelect/',
				type : 'POST',
				data : {'mem_num' : mem_num, 'free_num' : free_num},
				success : function(data){
					if(data == "like"){
						$(".thumbUpDiv").append(likeButtonTag);
						//alert('like?');
					}else if(data == "likeYet"){
						$(".thumbUpDiv").append(likeYetButtonTag);
						//alert('likeYet?')
					}
				},
				error : function(error){
					alert('다시 시도해주세요!');
				}
			})
		}
		
	});
	
	//아직 안 누른 좋아요 버튼 클릭시
	function likeYetClick(){
		$.ajax({
			url : '<%= request.getContextPath() %>/board/free/thumbUpRegist/',
			type : 'POST',
			data : {'mem_num' : mem_num, 'free_num' : free_num},
			success : function(free_like){
				$("#likeYet").remove();
				$("#like").remove();
				$(".thumbUpDiv").append(likeButtonTag);
				$("#like").html('<i class="fas fa-thumbs-up fa-2x"></i>' + free_like + " Like");
			},
			error : function(error){
				alert('다시 시도해주세요!');
			}
		})
	}
	
	//눌렀었던 좋아요 버튼 클릭시
	function likeClick(){
		$.ajax({
			url : '<%= request.getContextPath() %>/board/free/thumbUpRemove/',
			type : 'POST',
			data : {'mem_num' : mem_num, 'free_num' : free_num},
			success : function(free_like){
				$("#like").remove();
				$("#likeYet").remove();
				$(".thumbUpDiv").append(likeYetButtonTag);
				$("#likeYet").html('<i class="far fa-thumbs-up fa-2x"></i>' + free_like + " Like");
			},
			error : function(error){
				alert('다시 시도해주세요!');
			}
		})
	}
	
	function modify_go(){
		location.href="<%= request.getContextPath() %>/board/free/modifyForm/" + free_num;
	}
	
	function remove_go(){
		var con = confirm('글을 삭제하시겠습니까?');
		if(con){
			$.ajax({
				url : '<%= request.getContextPath() %>/board/free/remove/',
				type : 'POST',
				data : {'free_num' : free_num},
				success : function(data){
					alert('삭제되었습니다!');
					location.href="<%= request.getContextPath() %>/board/free/list";
				},
				error : function(error){
					alert('글 삭제에 실패하였습니다!');
				}
			})
		}else{
			alert('글 삭제를 취소하였습니다.');					
		}
	}
	
	$("#checkAll").on('click', function(){
        $("input[name='check']").prop("checked", true);
        $(this).hide();
        $("#checkClearAll").show();
    });
	$("#checkClearAll").on('click', function(){
        $("input[name='check']").prop("checked", false);
        $(this).hide();
        $("#checkAll").show();
    });
	
	function enabled(event){
		/* if($("input:checkbox[name='check']").is(":checked") == false){
			alert("비활성화할 글을 선택해주세요!");
			return;
		} */
		
		var checkedTrueList = new Array();
		var checkedFalseList = new Array();
		
		if($("input:checkbox[name='check']").is(":checked") == true){
			$(":checkbox[name='check']:checked").each(function(i,e){
				//alert("check된거 : " + e.value);
				checkedTrueList.push(e.value);
			});
        }

		if($("input:checkbox[name='check']").not(":checked")){
			$(":checkbox[name='check']:not(:checked)").each(function(i,e){
				//alert("check안된거 : " + e.value);
				checkedFalseList.push(e.value);
			});
        }

			
		var json = { 'checkedTrueList' : checkedTrueList,
					 'checkedFalseList' : checkedFalseList		
					};
		  
		$.ajax({
			url : '<%= request.getContextPath() %>/freeBoard/replies/enabled',
			type : 'post',
			data: JSON.stringify(json),
	        contentType:'application/json',
			success : function(result){
				alert("글 숨기기에 성공했습니다!");
			},
			error : function(error){
				alert("서버 오류로 글 숨기기에 실패했습니다. 다시 시도해주세요.");
			}
		})	

	}
	
	function movePreOrNextPage(flag, num){
		if(flag == 'nextForMem' || flag == 'nextForAdmin'){
			if(num != 0){
				location.href="<%= request.getContextPath() %>/board/free/detail?free_num="+num;
			}else{
				alert('다음 글이 없습니다.');
				return;
			}
		}

		if(flag == 'preForMem' || flag == 'preForAdmin'){
			if(num != 0){
				location.href="<%= request.getContextPath() %>/board/free/detail?free_num="+num;
			}else{
				alert('이전 글이 없습니다.');
				return;
			}
		}
		
	}
	
</script>