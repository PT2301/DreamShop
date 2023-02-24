<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order</title>
</head>
<body>
<div class="span9">
<div class="main-content">
<form action="<c:url value='/admin/product/list'/>"   id="formSubmit" method="get">
	<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Order</a>
					</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
				  <div class="col-xs-12">
					<c:if test="${not empty message}">
					     <div class="alert alert-${alert }">
		  					 ${message}
						</div>
					</c:if>
						
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>											    
											    <th>name</th>											   
												<th>quantity</th>
												<th>totalmoney</th>
												<th>status</th>																									
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td>${item.username }</td>	
												<td>${item.quantity }</td>												
												<td>${item.totalMoney }</td>
												<td>${item.status_id }</td>										
											</tr>								
											</c:forEach>									
										</tbody>
									</table>
									<ul class="pagination" id="pagination"></ul>	
									<input type="hidden" value="" id="page" name="page"/>
									<input type="hidden" value="" id="limit" name="limit"/>	
								</div>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
	</div>
</div>
	<!-- /.main-content -->
	<script>
	var totalPages = ${model.totalPage};
	var currentPage = ${model.page};
    var limit =${model.limit};
	$(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            onPageClick: function (event, page) {
            	if (currentPage != page) {
            		$('#limit').val(limit);
					$('#page').val(page);
					$('#formSubmit').submit();
				}
            }
        });
    });
	</script>
</body>
</html>