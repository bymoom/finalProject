<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.6/handlebars.js"></script>
<script type="text/x-handlebars-template" id="pjt-list-template">
{{#each .}}
        <div class="col-md-4">
	{{#isType pjt_type_code}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="detailGo(1,{{pjt_num }})" style="cursor:pointer;">
   	{{else}}
          <div class="card mb-4 shadow-sm  projectCard" OnClick="detailGo(2,{{pjt_num }})" style="cursor:pointer;">
   	{{/isType}}


               <img src="/project/picture/get?picture={{pjt_atc_sum_name}}" width="100%" height="150" />
                   <div class="card-body">
		                
		                  <div style="height: 70px;">
		                  <p class="font-weight-bold">{{pjt_title }}</p>
		                  </div>

							<span class="endD" state="{{pjt_calculate_code}}" enabled="{{pjt_enabled}}">{{prettifyDate pjt_enddate}}</span>
								
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
	                           
		                	<span class="percentPay">{{percent pjtPaySum pjt_cash}}</span>%<br> 달성 금액 {{prettifyNumber pjtPaySum }}
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
		gapDay='성공';
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

function endProject(){
	alert('종료된 프로젝트 입니다.');
}
function enabledPjt(){
	alert('비노출된 프로젝트 입니다. 관리자에게 문의해주세요.');
}
/* 페이징 */
var realEndPage='${pjtPageMaker.realEndPage}';
getPage("<%=request.getContextPath()%>/mypage/project/getlist?page=1&categoryType=${pjtPageMaker.pjtCri.categoryType}&keyword=${pjtPageMaker.pjtCri.keyword}&mem_num=${loginUser.mem_num}");

var printData=function(replyArr,target,templateObject){
	var template=Handlebars.compile(templateObject.html());
	var html = template(replyArr);	
	target.append(html);
}

var count=1;
var flag = true;
function getPage(pageInfo,why){
	$.ajax({
		url:pageInfo,
		type:"get",
		success:function(dataMap){
			printData(dataMap.projectList,$('.contents'),$('#pjt-list-template'));
			
			count++;
			flag = true;
			
			$('.endD').each(function(){
				if($(this).text()=='성공'){
					$(this).text('성공(정산처리중)');
					$(this).parent().parent().attr('OnClick','endProject();');
					if($(this).attr('state')=="2"){
						$(this).text('성공(정산 완료)');
					}
					if($(this).attr('state')=="3"){
						$(this).text('성공(상환 미완료)');
					}
					if($(this).attr('state')=="4"){
						$(this).text('성공(상환 완료)');
					}
					
					if($(this).siblings('.percentPay').text()<100){
						$(this).text('실패');
					}
				}
				
				if($(this).attr('enabled')=="0"){
					$(this).text('비노출');
					$(this).parent().parent().attr('OnClick','enabledPjt();');
				}
			});
			
			
			
			
		},
		error:function(error){
			alert("서버 장애로 프로젝트 목록이 생략됩니다.");
		}
	});
}

/* 스크롤 이벤트 */
window.onscroll = function(ev) {
    if ((window.innerHeight + window.scrollY)+400 >= document.body.offsetHeight) {
		if(count<=realEndPage && flag == true){
			flag = false;
			console.log(count);
			
       	 	getPage("<%=request.getContextPath()%>/mypage/project/getlist?page="+count+"&categoryType=${pjtPageMaker.pjtCri.categoryType}&keyword=${pjtPageMaker.pjtCri.keyword}&mem_num=${loginUser.mem_num}");
			
			
			return;
		}
    }
};

/* 카테고리별 조회 */
function category(menu){
	if(menu=='all'){
		location.href="/project/list";
		return;		
	}
	var jobForm=$('#jobForm');
	jobForm.find("[name='page']").val(1);
	jobForm.find("[name='categoryType']").val(menu);
	jobForm.find("[name='keyword']").val($('input[name="keyword"]').val());
	jobForm.attr("action","list").attr("method","post");
	jobForm.submit();
}


function search(){
	$('input[name="keyword"]').val($('[aria-label="Search"]').val());
	category($('input[name="categoryType"]').val());
}
$('#searchBtn').on('click',function(){
	search();
});



</script>