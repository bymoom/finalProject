<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<script type="text/x-handlebars-template" id="pjt-list-template">
{{#each .}}
        <div class="col-md-4">

	{{#isType pjt_type_code}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="detailGo(1,{{pjt_num }})" style="cursor:pointer;">
   	{{else}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="detailGo(2,{{pjt_num }})" style="cursor:pointer;">
   	{{/isType}}


               <img src="/project/picture/get?picture={{pjt_atc_sum_name}}" width="100%" height="175" />
                   <div class="card-body">
<text x="50%" y="50%" class="bg-success" dy=".3em">{{pjtType pjt_type_code}}</text> <br>
						{{comName }}&nbsp;&nbsp;&nbsp; {{pjt_category }}<br> 
		                  <div style="height: 70px;">
		                  <p class="font-weight-bold">{{pjt_title }}</p>
		                  </div>
							<span class="endD">{{prettifyDate pjt_enddate}}</span>
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
	
	if(gapDay<0){
		gapDay='종료';
	}else{
		gapDay='D-'+gapDay;
	}
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
function endProject(){
	alert('종료된 프로젝트 입니다.');
}
/* 페이징 */
var realEndPage='${mainPageMaker.realEndPage}';
getPage("<%=request.getContextPath()%>/mypage/getlist?page=1&mem_num=${loginUser.mem_num}",$('.contents1'));


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
			
			$('.endD').each(function(){
				if($(this).text()=='종료'){
					$(this).parent().parent().attr('OnClick','endProject();');
				}
			});
		},
		error:function(error){
			alert("서버 장애로 프로젝트 목록이 생략됩니다.");
		}
	});
}

/* 디테일 이동 */
function detailGo(no,pjt_num){
	
	var jobForm=$('#detailform');
	jobForm.find("[name='pjt_num']").val(pjt_num);
	
	if(no=='1'){
		jobForm.attr("action","/project/detail").attr("method","post");
		jobForm.submit();
	}
	if(no=='2'){
		jobForm.attr("action","/project/loanDetail").attr("method","post");
		jobForm.submit();
	}
	
}


</script>