<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/taglib.jsp"%>
<c:url var ="NewURL" value="/admin/product/list"/>
<c:url var ="NewAPI" value="/api/product"/>
<c:url var="editNewURL" value="/admin/product/edit"/>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Home</a></li>
				<li><a href="#">Forms</a></li>
				<li class="active">Form Elements</li>
			</ul>
			<!-- /.breadcrumb -->
		</div> 
		<div class="page-content">
			<div class="page-header">
				<h1>
					Form Elements <small> <i class="ace-icon fa fa-angle-double-right"></i> Common form elements and layouts</small>
				</h1>
			</div>
			<!-- /.page-header -->
			<c:if test="${not empty message}">
					<div class="alert alert-${alert }">
		  				${message}
					</div>
			</c:if>
			<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
					<div class="form-group">
						<label for="categoryId"class="col-sm-3 control-label no-padding-right">The loai</label>
						<div class="col-sm-9">
							<form:select path="categoryId" id="categoryId">
								<form:option value="" label="--Chon the loai--"/>
								<form:options items="${categories}"/>
							</form:select>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1"> Name product </label>
						<div class="col-sm-9">
							<form:input path="name" cssclass="col-xs-10 col-sm-5" id="name"/>
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1-1"> img	 </label>
						<div class="col-sm-9">
							<input type="file" id="img" name="img"placeholder="img" class="col-xs-10 col-sm-5" value="${model.img }"/>
						</div>
					</div>
					<div class="form-group">
						<label for="shortDescription"
							class="col-sm-3 control-label no-padding-right">detail</label>
						<div class="col-sm-5">
							<form:textarea path="detail" rows="5" cols="10" cssClass="form-control" id="detail"/>
						</div>
					</div>
					<div class="form-group">
						<label for="content"class="col-sm-3 control-label no-padding-right">price</label>
						<div class="col-sm-5">
							<form:textarea path="price" rows="5" cols="10" cssClass="form-control" id="price"/>
						</div>
					</div>

					<div class="form-group">
						<label for="content"class="col-sm-3 control-label no-padding-right">size</label>
						<div class="col-sm-5">
							<form:textarea path="size" rows="5" cols="10" cssClass="form-control" id="size"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1">quantity  </label>
						<div class="col-sm-9">
							<form:input path="quantity" cssclass="col-xs-10 col-sm-5" id="quantity"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1"> status </label>
						<div class="col-sm-9">
							<form:input path="status" cssclass="col-xs-10 col-sm-5" id="status"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1"> highlight </label>
						<div class="col-sm-9">
							<form:input path="highlight" cssclass="col-xs-10 col-sm-5" id="highlight"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1">newProduct </label>
						<div class="col-sm-9">
							<form:input path="newProduct" cssclass="col-xs-10 col-sm-5" id="newProduct"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label no-padding-right"for="form-field-1">sale </label>
						<div class="col-sm-9">
							<form:input path="sale" cssclass="col-xs-10 col-sm-5" id="sale"/>
						</div>
					</div>
					
					<!--duy trì ngầm,xuyên suốt id trong suốt time t đứng trong form  -->
					<form:hidden path="id" id="newId"/>
					
					<div class="clearfix form-actions">
						<div class="col-md-offset-3 col-md-9">
							<c:if test="${not empty model.id}">
								<button class="btn btn-info" type="button"
									id="btnAddOrUpdateNew">
									<i class="ace-icon fa fa-check bigger-110"></i> Cập nhật bài viết
								</button>
							</c:if>
							<c:if test="${empty model.id}">
								<button class="btn btn-info" type="button"
									id="btnAddOrUpdateNew">
									<i class="ace-icon fa fa-check bigger-110"></i> Thêm bài viết
								</button>
							</c:if>

							&nbsp; &nbsp; &nbsp;
							<button class="btn" type="reset">
								<i class="ace-icon fa fa-undo bigger-110"></i> Hủy
							</button>
						</div>
					</div>
				</form:form>
		</div>
      </div>
	</div>
	
	<script>
		$('#btnAddOrUpdateNew').click(function(e) {
			e.preventDefault();
			var data={};
			var formData = $('#formSubmit').serializeArray();/* lấy dữ liệu thành 1 mảng theo name  */
			$.each(formData,function(i,v){
				data[""+v.name+""]=v.value;
			});
			var id=$('#newId').val();
			if(id==""){
				addNew(data);
			}else{
				updateNew(data);
			}
		});
		function addNew(data) {
		    $.ajax({
		        url: '${NewAPI}',
		        type: 'POST',
		        contentType: 'application/json',//kiểu data từ clinet về servers
		        data: JSON.stringify(data),//convert từ object javascript sang json
		        dataType: 'json',//kiểu data trả về cho clinet,không khai báo datatyoe='text'
		        success: function (result) {
		        	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
		        },
		        error: function (error) {
		        	window.location.href = "${NewURL}?page=1&limit=5&message=error_system";
		        }
		    });
		}
		function updateNew(data) {
		    $.ajax({
		        url: '${NewAPI}',
		        type: 'PUT',
		        contentType: 'application/json',
		        data: JSON.stringify(data),
		        dataType: 'json',
		        success: function (result) {
		        	window.location.href ="${editNewURL}?id="+result.id+"&message=update_success";
		        },
		        error: function (error) {
		        	window.location.href ="${editNewURL}&id="+result.id+"&message=error_system";
		        }
		    });
		}
	</script>
</body>
</html>