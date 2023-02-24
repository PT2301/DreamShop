<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title><dec:title default="Master-layout"/></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- Bootstrap styles -->
<link href="<c:url value="/template/web/css/bootstrap.css" />" rel="stylesheet" />

<!-- Customize styles -->
<link href="<c:url value="/template/web/style.css" />" rel="stylesheet" />
<!-- font awesome styles -->
<link href="<c:url value="/template/web/font-awesome/css/font-awesome.css" />" rel="stylesheet">

<!-- Favicons -->
<link rel="shortcut icon" href="<c:url value="/template/web/ico/favicon.ico" />">

<dec:head/>
</head>
<body>
	<!-- 
	Upper Header Section 
-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="topNav">
			<div class="container">
				<div class="alignR">
					<div class="pull-left socialNw">
						<a href="#"><span class="icon-twitter"></span></a> <a href="#"><span
							class="icon-facebook"></span></a> <a href="#"><span
							class="icon-youtube"></span></a> <a href="#"><span
							class="icon-tumblr"></span></a>
					</div>
					<a class="active" href="<c:url value="/trang-chu"/>"> <span class="icon-home"></span>Home</a> 
					<c:if test="${ myUser==null }">
						<a href="<c:url value="/login"/>"><span class="icon-edit"></span>Login</a> 
					</c:if>
					<c:if test="${  myUser!=null }">
						<a href="register.html"><span class="icon-user"></span> ${myUser.username}</a>
						<a href="<c:url value="/logout"/>"><span class="icon-edit"></span>Logout</a> 
						<a href="<c:url value="/deleteAccount"/>"><span class="icon-edit"></span> Remove </a>  
					</c:if> 
						<a href="<c:url value="/cart"/>"><span class="icon-shopping-cart"></span> ${TotalProduct} Item(s) - <span
						class="badge badge-warning"> $${TotalMoney }</span></a>
				</div>
			</div>
		</div>
	</div>

	<!--
Lower Header Section 
-->
	<div class="container">
		<div id="gototop"></div>
		<%@include file="/decorators/web/header.jsp" %>
		<div class="row">
		<%@include file="/decorators/web/menu.jsp" %>
		
		<dec:body/>
		</div>
		<%@include file="/decorators/web/footer.jsp" %>
		
	</div>
	<!-- /container -->

	<div class="copyright">
		<div class="container">
			<p class="pull-right">
				<a href="#"><img src="<c:url value="/template/web/img/maestro.png"/>" alt="payment"></a>
				<a href="#"><img src="<c:url value="/template/web/img/mc.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/template/web/img/pp.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/template/web/img/visa.png"/>" alt="payment"></a> <a
					href="#"><img src="<c:url value="/template/web/img/disc.png"/>" alt="payment"></a>
			</p>
			<span>Copyright &copy; 2013<br> bootstrap ecommerce shopping template
			</span>
		</div>
	</div>
	<a href="#" class="gotop"><i class="icon-double-angle-up"></i></a>
	<!-- Placed at the end of the document so the pages load faster -->
	<script src=" <c:url value="/template/web/paging/jquery.twbsPagination.js" />"></script>
	<script src=" <c:url value="/template/web/js/jquery.js" />"></script>
	<script src="<c:url value="/template/web/js/bootstrap.min.js" />"></script>
	<script src="<c:url value="/template/web/js/jquery.easing-1.3.min.js" />"></script>
	<script src="<c:url value="/template/web/js/jquery.scrollTo-1.4.3.1-min.js" />"></script>
	<script src="<c:url value="/template/web/js/shop.js" /> "></script>
	<dec:getProperty property="page.script"></dec:getProperty>
</body>
