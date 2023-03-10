<%@include file="/taglib.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:url var="newAPI" value="/api/product"/>
<c:url var="newURL" value="/admin/product/list"/>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<div class="main-content">
<form action="<c:url value='/admin/product/list'/>"   id="formSubmit" method="get">
	<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li>
						<i class="ace-icon fa fa-home home-icon"></i>
						<a href="#">Trang chủ</a>
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
					<div class="widget-box table-filter">
									<div class="table-btn-controls">
										<div class="pull-right tableTools-container">
											<div class="dt-buttons btn-overlap btn-group">
												<a flag="info"
												   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
												   title='New Product' href="<c:url value='/admin/product/edit'/>" >
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
												</a>
												<button id="btnDelete" type="button" onclick="warningBeforeDelete()"
														class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
														<span>
															<i class="fa fa-trash-o bigger-110 pink"></i>
														</span>
												</button>
											</div>
										</div>
									</div>
								</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
											    <th><input type="checkbox" id="checkAll"></th>
											    <th>id</th>											   
												<th>name</th>
												<th>price</th>
												<th>detail</th>
												<th>img</th>
												<th>categoryId</th>
												<th>color</th>								
												<th>Edit</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${model.listResult}">
											<tr>
												<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}"></td>
												<td>${item.id }</td>	
												<td>${item.name }</td>												
												<td>${item.price }</td>
												<td>${item.detail }</td>
												<td>${item.img }</td>	
												<td>${item.categoryId }</td>											
												<td><c:forEach var="color" items="${item.color }">
												          ${color.name} <br>
													</c:forEach>												
												</td>
												<td>
													<c:url  var="updateNewURL" value="/admin/product/edit">
														<c:param name="id" value="${item.id}"/>															
													</c:url>															
													<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
														 title="Cập nhật bài viết" href='${updateNewURL}'>
														 <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
													</a>
											   </td>
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
		</div>
	</form>
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
	function warningBeforeDelete(){
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
			  if (result.isConfirmed) {
				  var ids = $('tbody input[type=checkbox]:checked').map(function () {
			            return $(this).val();
			        }).get();
					deleteNew(ids);
			    
			  }
			});
		
	} 
	function deleteNew(data) {
        $.ajax({
            url: '${newAPI}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${newURL}?page=1&limit=5&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${newURL}?page=1&limit=5&message=error_system";
            }
        });
    }
	</script>

</body>
</html>