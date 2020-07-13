<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script type="text/x-handlebars-template" id="pjt-list-template">
{{#each .}}
        <div class="col-md-4">

	{{#isType pjt_type_code}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="location.href ='/project/detail?pjt_num={{pjt_num }}'" style="cursor:pointer;">
   	{{else}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="location.href ='/project/loanDetail?pjt_num={{pjt_num }}'" style="cursor:pointer;">
   	{{/isType}}


               <img src="/project/picture/get?picture={{pjt_atc_sum_name}}" width="100%" height="225" />
                   <div class="card-body">
<text x="50%" y="50%" class="bg-success" dy=".3em">{{pjtType pjt_type_code}}</text> <br>
						{{comName }}&nbsp;&nbsp;&nbsp; {{pjt_category }}<br> 
		                  <div style="height: 70px;">
		                  <p class="font-weight-bold">{{pjt_title }}</p>
		                  </div>
							D-{{prettifyDate pjt_enddate}}
	                      <!-- 그래프 -->
						  <div class="col-sm-12">
		                    <span class="irs irs--flat js-irs-3"><span class="irs">
		                    <span class="irs-line" tabindex="0"></span>
		                    <span class="irs-min" style="visibility: visible;">0%</span>
		                    <span class="irs-max" style="visibility: visible;">100%</span>
		                    <span class="irs-from" style="visibility: hidden;">0</span>
		                    <span class="irs-to" style="visibility: hidden;">0</span>
		                    </span><span class="irs-grid"></span>
		                    <span class="irs-bar irs-bar--single" style="left: 0px; width: {{percentGrape pjtPaySum pjt_cash}}%;"></span><span class="irs-shadow shadow-single" style="display: none;"></span>
		                    </span>
		                    <input id="range_6" type="text" name="range_6" value="" class="irs-hidden-input" tabindex="-1" readonly="">
		                  </div>
		                	{{percent pjtPaySum pjt_cash}}% : 달성 금액 {{prettifyNumber pjtPaySum }}
            </div>
          </div>
        </div>

{{/each}}
</script>

<script>
function enterkey() {
    if (window.event.keyCode == 13) {
         search();
    }
}

Handlebars.registerHelper('isType', function(v1, options) {
	  var regexp = v1;
	  if (regexp == 1) {
	    return options.fn(this);
	  } else {
	    return options.inverse(this);
	  }
	});

Handlebars.registerHelper("prettifyNumber",function(x){

	return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");;
});

Handlebars.registerHelper("prettifyDate",function(timeValue){
	var nowDate=new Date();
	var nowObj=nowDate.getTime();
	
	var prettify=timeValue-nowObj;
	
	var gapDay=Math.ceil(prettify/(60*1000*60*24));
	return gapDay;
});

Handlebars.registerHelper("percent",function(paySum, cash){
	var percent = paySum/cash*100;
	return parseFloat(percent.toFixed(1));
});

Handlebars.registerHelper("percentGrape",function(paySum, cash){
	var percent = paySum/cash*100;
	if(percent >= 100){
		percent = 100;
	}
	return parseFloat(percent.toFixed(1));
});

Handlebars.registerHelper("pjtType",function(x){
	if(x==1){
		x="후원형";
	}
	if(x==2){
		x="대출형";
	}
	return x;
});

/* 페이징 */
var realEndPage='${mainPageMaker.realEndPage}';
getPage("<%=request.getContextPath()%>/getlist?page=1&whereType=newproject",$('.contents1'));
getPage("<%=request.getContextPath()%>/getlist?page=1&whereType=end",$('.contents2'));
getPage("<%=request.getContextPath()%>/getlist?page=1&whereType=thumbsup",$('.contents3')); 
getPage("<%=request.getContextPath()%>/getlist?page=1&whereType=highcount",$('.contents4'));

var printData=function(replyArr,target,templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);	
	target.append(html);
}

function getPage(pageInfo,why){
	$.ajax({
		url:pageInfo,
		type:"get",
		success:function(dataMap){
			printData(dataMap.projectList,why,$('#pjt-list-template'));
		},
		error:function(error){
			alert("서버 장애로 프로젝트 목록이 생략됩니다.");
		}
	});
}


</script>