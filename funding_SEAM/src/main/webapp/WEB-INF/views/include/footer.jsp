<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer class="footer">
 			<div class="container noticeDiv">
				<div class="col-2" style="display:inline-block;">
				<span class="fa fa-bullhorn"></span> 공지사항
				</div>
				<div class="myclass col-10" style="float:right;">
					<ul class="notice-list">
						
					</ul>
				</div> 
				</div>
				<hr>
            <div class="container">
                <div class="row">
                    <!-- Footer Location-->
                    <div class="col-lg-9">
                    
                    <h6><small>FunSEAMding(주) | 대표이사 김대덕 | 사업자등록번호 306-82-05291 <br><br>
                                                      대전광역시 중구 중앙로 76 영민빌딩 2층 | 대표전화: 042-222-8202 | 팩스: 042-252-0678 | 개인정보관리책임자 : 리승재<br><br>
						Copyright ⓒ 2020 FunSEAMding All rights reserved</small></h6>
                    </div>
                                        <div class="col-lg-2">
                    <img src="<%=request.getContextPath()%>/resources/images/funseamding.png" style="width: 250px;">
                                        </div>
                </div>
            </div>
        </footer>
<!-- ./wrapper -->

<!-- REQUIRED SCRIPTS -->

<!--Start of Tawk.to Script-->

 <script type="text/javascript">


/* 실시간 상담 */
var Tawk_API=Tawk_API||{}, Tawk_LoadStart=new Date();
(function(){
var s1=document.createElement("script"),s0=document.getElementsByTagName("script")[0];
s1.async=true;
s1.src='https://embed.tawk.to/5eccaa688ee2956d73a49111/default';
s1.charset='UTF-8';
s1.setAttribute('crossorigin','*');
s0.parentNode.insertBefore(s1,s0);
})();


</script>
<!--End of Tawk.to Script-->

<%@ include file="./notice_js.jsp" %>
<!-- Bootstrap 4 --><!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>

<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/ion-rangeslider/js/ion.rangeSlider.min.js"></script>


<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap-slider/bootstrap-slider.min.js"></script>


<script src="<%=request.getContextPath() %>/resources/js/common.js"></script>

</body>

</html>
