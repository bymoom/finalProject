<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



  <h2 style="text-align:center;">프로젝트</h2><br><br>
<div style="width:70%; text-align:right;">



</div>
<section class="container">
<div style="float:right;">

</div>
<br>
	<div style="width:100%;">
      <!-- Default box -->
      </div>
      <div class="card" style="text-align:right;">
      		
			      		
        <div class="card-header" style="border:2px solid gray;">
          <h3 class="card-title">${count }건의 검색결과가 있습니다.</h3>

          <div class="card-tools">
            <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
              <i class="fas fa-minus"></i></button>
          </div>
        </div>
        <div class="card-body p-0">
        <br>
          
	                 	<c:if test="${empty projectList }">
	                 			<td colspan="5">검색 결과가 없습니다.</td>
	                 	</c:if>
                 <c:forEach items="${projectList }" var="list">
                 	<!-- Portfolio Item 1-->
                    <div class="col-md-6 col-lg-4 mb-5" style="float:left; height:400px;">
                        <div class="portfolio-item mx-auto" data-toggle="modal" data-target="#portfolioModal1">
	                            <img class="img-fluid" src="<%=request.getContextPath() %>/resources/bootstrap/assets/img/portfolio/cabin.png" alt="">
                        <div style="height:50px;"><a href="<%=request.getContextPath()%>/project/detail?pjt_num=${list.pjt_num}"><h4>${list.pjt_title }</h4></a></div>
                        <br><br>
                        <div>
                      	 	 <fmt:formatDate value="${list.pjt_regdate }" pattern="yyyy-MM-dd"></fmt:formatDate>
                        </div>
                        <div class="col-sm-12">
		                    <span class="irs irs--flat js-irs-3"><span class="irs">
		                    <span class="irs-line" tabindex="0"></span>
		                    <span class="irs-min" style="visibility: visible;">0%</span>
		                    <span class="irs-max" style="visibility: visible;">100%</span>
		                    <span class="irs-from" style="visibility: hidden;">0</span>
		                    <span class="irs-to" style="visibility: hidden;">0</span>
		                    </span><span class="irs-grid"></span>
		                    <span class="irs-bar irs-bar--single" style="left: 0px; width: 8.0%;"></span><span class="irs-shadow shadow-single" style="display: none;"></span>
		                    </span>
		                    <input id="range_6" type="text" name="range_6" value="" class="irs-hidden-input" tabindex="-1" readonly="">
		                  </div>
                            <div class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
                                <div class="portfolio-item-caption-content text-center text-white"><svg class="svg-inline--fa fa-plus fa-w-14 fa-3x" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="plus" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M416 208H272V64c0-17.67-14.33-32-32-32h-32c-17.67 0-32 14.33-32 32v144H32c-17.67 0-32 14.33-32 32v32c0 17.67 14.33 32 32 32h144v144c0 17.67 14.33 32 32 32h32c17.67 0 32-14.33 32-32V304h144c17.67 0 32-14.33 32-32v-32c0-17.67-14.33-32-32-32z"></path></svg><!-- <i class="fas fa-plus fa-3x"></i> --></div>
                            </div>
                        </div>
                        
                    </div>
                 </c:forEach>
             
        </div>
        <!-- /.card-body -->
      </div>
         
      <!-- /.card -->
	</div>
    </section>
    
