<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Cart</title>
</head>
<body>
	<!-- Body Section -->
			<div class="span9">
				<ul class="breadcrumb">
					<li><a href="index.html">Home</a> <span class="divider">/</span></li>
					<li class="active">Cart</li>
				</ul>
				<div class="well well-small">
					<h1>
						Cart <small class="pull-right">
								<c:if test="${TotalProduct!=0}"> ${TotalProduct} Items are in the cart </c:if> 
								<c:if test="${TotalProduct==0}"> No items are in the cart </c:if>
							</small>
							    
					</h1>
					<hr class="soften" />

					<table class="table table-bordered table-condensed">
						<thead>
							<tr>
								<th>Product</th>
								<th>Description</th>								
								<th>Color</th>
								<th>Unit price</th>
								<th>Quantity</th>
								<th>Edit</th>
								<th>Delete</th>
								<th>Total</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${cart }" varStatus="loop">
								<tr>
								<td><img width="100" src="<c:url value="/template/web/img/${item.value.product.img }"/>" alt=""></td>
								<td>${item.value.product.name}<br>${item.value.product.size}</td>								
								<td>
									<c:forEach var="color" items="${item.value.product.color}" varStatus="loop">
										${color.name}<br>
									</c:forEach>
								</td>
								<td>${item.value.product.price }</td>
								<td><input type="number" min="1" max="100" class="span1" style="max-width: 34px" placeholder="1" id="appendedInputButtons" size="10" type="text"
									value="${item.value.quantity }"></td>
								<td><a class="btn btn-mini btn-danger" href="<c:url value="/editCart/${item.value.product.id }"/>" type="button">
										<span class="icon-edit"></span>
									</a></td>
								<td><a class="btn btn-mini btn-danger" href="<c:url value="/deleteCart/${item.value.product.id }"/>" type="button">
										<span class="icon-remove"></span>
									</a>										
								</td>
								<td>${item.value.totalPrice }</td>
								</tr>						
							</c:forEach>
							<tr>
								<td colspan="7.3" class="alignR">Total products:</td>
								<td class="label label-primary">${TotalMoney}</td>
							</tr>							
						</tbody>
					</table>
					<br />
					
					<a href="products.html" class="shopBtn btn-large"><span class="icon-arrow-left"></span> Continue Shopping </a> 
					<a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Order <span class="icon-arrow-right"></span></a>

				</div>
			</div>
</body>
</html>