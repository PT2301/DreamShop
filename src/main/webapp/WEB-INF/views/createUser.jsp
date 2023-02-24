<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/taglib.jsp"%>	
<c:url var="loginURL" value="/login" />
<c:url var="createURL" value="/createUser" />
<c:url var="createAPI" value="/api/createUser" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create</title>

</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${not empty message}">
					<div class="alert alert-danger }">
		  				${message}
					</div>
			  </c:if>
				<h2>Information</h2>
				<form:form  action="/createAccount" id="createSubmit" method="POST"  modelAttribute="user">
					<div class="form-group">
						<form:input type="text" class="form-control" id="email" name="email" path="email" placeholder="Email"/>
					</div>

					<div class="form-group">
						<form:input type="password" class="form-control" id="password" name="password" path="password" placeholder="Password"/>
					</div>
					<div class="form-group">
						<form:input type="text" class="form-control" id="username" name="username" path="username" placeholder="Username"/>
					</div>
					<button type="submit" id="create" class="btn btn-primary" >Create</button>					
				</form:form>
			</div>
		</div>
	</div>
<!-- <script type="text/javascript">
	$('#create').click(function(e){
		e.preventDefault();/* tránh  gọi nhâm url */
		var data={};
		var createData = $('#createSubmit').serializeArray();/* lấy dữ liệu thành 1 mảng theo name  */
		$.each(createData,function(i,v){
			data[""+v.name+""]=v.value;
		});
		createUser(data);
	});
	function createUser(data){
		$.ajax({
	        url: '${createAPI}',
	        type: 'POST',
	        contentType: 'application/json',//kiểu data từ clinet về servers
	        data: JSON.stringify(data),//convert từ object javascript sang json
	        dataType: 'json',//kiểu data trả về cho clinet,không khai báo datatyoe='text'
	        success: function (result) {
	        	window.location.href = "${loginURL}";
	        },
	        error: function (error) {
	        	window.location.href = "${createURL}";
	        }
	    });
	}

 </script> -->
</body>
</html>