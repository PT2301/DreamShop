<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>information</title>
</head>
<body>
<div class="span9">
<div class="well">
<h2>Information checkout</h2>
	<form:form class="form-horizontal" method="POST" modelAttribute="order" action="/checkout">		
		<div class="control-group">
			<label class="control-label">Name <sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" placeholder=" Field name " path="username" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">PhoneNumber <sup>*</sup></label>
			<div class="controls">
			  <form:input type="text" placeholder=" 0***	" path="phone"/>
			</div>
		</div>
		 <div class="control-group">
			<label class="control-label">Address<sup>*</sup></label>
			<div class="controls">
			  <form:textarea path="address"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">Note <sup>*</sup></label>
			<div class="controls">
			  <form:textarea path="note"/>
			</div>
		</div>	
		 <a class="btn btn-primary" href="<c:url value='/listOrder?page=1&limit=5'/>" type="submit" id="submitOrder">
				<i class="ace-icon fa fa-check bigger-110"></i> Payment
		 </a>		
	</form:form>
</div>
</div>

</body>
</html>