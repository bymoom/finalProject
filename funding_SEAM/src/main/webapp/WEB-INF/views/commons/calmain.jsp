<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
	
<!-- Tell the browser to be responsive to screen width -->
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <!-- Font Awesome -->
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
 <!-- Ionicons -->
 <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
 <!-- fullCalendar -->
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar/main.min.css">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-interaction/main.min.css">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-daygrid/main.min.css">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-timegrid/main.min.css">
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-bootstrap/main.min.css">
 <!-- Theme style -->
 <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
 <!-- Google Font: Source Sans Pro -->
 <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">	
	
	
	
	
<!-- jQuery -->
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/moment.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar/main.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-daygrid/main.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-timegrid/main.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-interaction/main.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/fullcalendar-bootstrap/main.min.js"></script>

<title>calendar - FUN&#36;&#123;SEAM&#125;DING</title>

</head>

<script>
$(function () {
  var Calendar = FullCalendar.Calendar;
  var calendarEl = document.getElementById('calendar');

  var calendar = new Calendar(calendarEl, {
    plugins: [ 'bootstrap', 'interaction', 'dayGrid', 'timeGrid' ],
    header    : {
      left  : 'prev,next dailyChk',
      center: 'title',
      right : 'dayGridMonth,timeGridWeek,timeGridDay'
    },
    customButtons: {
    	dailyChk: {
    		text: '출석체크',
    		id: 'check',
    		click: function() {
				//ajax통신으로 출석정보 저장    
// 				alert("cal click!");
				$.ajax({
					url: '/mypage/info/dailycheck',
					type: "POST",
					data: {"mem_email" : mem_email},
					dataType: "text",
					success: function(data) {
						
					}
				});
    		}
    	},
    	eventSources: [
    		{
// 				//ajax 로 달력정보 가져오기    			
//     			$.ajax({
// 					url: '/mypage/info/dailycheck',
// 					type: "GET",
// 					dataType: "JSON",
// 					success: function(data) {	},
// 					error: function(data) {
// 						alert('event');
// 					}
// 				});
    		}
    	]
    },
    events    : [
      {
        title : 'All Day Event',
        start : "2020-06-14",
        end : "2020-05-14"
      }
    ]
  });
  calendar.render();
})
</script>


<body>
	<div id="calendar"></div>
</body>
</html>