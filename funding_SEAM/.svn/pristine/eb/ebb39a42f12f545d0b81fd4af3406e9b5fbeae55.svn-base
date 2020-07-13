<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script>
	
	/* 수정버튼 클릭 */
	$(':button[name="FAQModify"]').on('click',function(){
		var faq_num=$(this).parents().prevAll('.faqnum').val();
		OpenWindow('modify?faq_num='+faq_num,'수정',1280,800);
	});
	
	/* 삭제버튼 클릭 */
	$(':button[name="FAQDelete"]').on('click',function(){
		
		var faq_num=$(this).parents().prevAll('.faqnum').val();
		var ask = confirm('정말 삭제하시겠습니까?');
		if(ask){
			location.href="<%=request.getContextPath()%>/FAQ/delete?faq_num="+faq_num;
		}
	});
	
</script>