<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/ion-rangeslider/css/ion.rangeSlider.min.css">
	
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap-slider/css/bootstrap-slider.min.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/styles.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/write.css">
	
	<!-- Date Picker css -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery-ui/jquery-ui.css">
	
	<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  <!-- jQuery -->
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
  <script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>

<title></title>
<style>
	#cnts {
    width: 990px;
    height: 401px;
    padding-top: 188px;
    margin: 40px auto;
    text-align: center;
    background: #fff url(http://s.nx.com/S2/p3/etc/2016/ico_error.gif) no-repeat center 91px;
}
</style>
</head>
<body>
	<div class="container">
       <div id="cnts">
            <h1 id="ErrorMessage">서버 장애로 처리할 수 없습니다.</h1>
            <p id="ErrorMessageInfo">이용에 불편을 드려 죄송합니다.<br>다시 시도해주세요.</p>
                같은 문제가 계속해서 발생하면 고객센터로 문의해주세요.<br><hr>
            <p class="bt">
                <a href="#" onclick="history.go(-1); return false;" a2s="click" obj="P_error" opt="{&quot;Name&quot;:&quot;Pre&quot;}"><img src="http://s.nx.com/S2/p3/etc/2016/bt_prev.gif" width="175" height="48" alt="이전페이지"></a>
                <a href="<%=request.getContextPath() %>/main" a2s="click" obj="P_error" opt="{&quot;Name&quot;:&quot;Home&quot;}"><img src="http://s.nx.com/S2/p3/etc/2016/bt_home.gif" width="175" height="48" alt="홈으로 이동"></a>
            </p>
        </div>
	</div>
</body>
</html>