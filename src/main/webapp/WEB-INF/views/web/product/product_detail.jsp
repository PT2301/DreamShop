<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Detail</title>
<style>
	.product-content{
		overflow-x: hidden;
	}
</style>
</head>
<body>
	<!-- Body Section -->
	<h1> ${totalMoney}</h1>
	<h1> ${cart.size()}</h1>
	<div class="span9">
			<ul class="breadcrumb">
				<li><a href="index.html">Home</a> <span class="divider">/</span></li>
				<li><a href="products.html">Product</a> <span class="divider">/</span></li>
				<li class="active">Preview</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img src="/template/web/img/${ product.img }" alt=""
										style="width: 100%"></a>
								</div>
							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						
						<h3>${product.name }</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get" action="<c:url value="/addCart/${product.id}" />">
							<div class="control-group">
							<label class="control-label"><span>$ ${product.price}</span></label>
								<div class="controls">
									<input type="number" class="span6" min="1" value="${quantity }" placeholder="1" id="quantity" name="quantity">									
								</div>																			
							</div>

							<div class="control-group">
								<label class="control-label"><span>Color</span></label>
								<div class="controls">
									<select class="span11">
										<option>Red</option>
										<option>Purple</option>
										<option>Pink</option>
										<option>Red</option>
									</select>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"><span>Materials</span></label>
								<div class="controls">
									<select class="span11">
										<option>Material 1</option>
										<option>Material 2</option>
										<option>Material 3</option>
										<option>Material 4</option>
									</select>
								</div>
							</div>
							<h4>${product.detail }</h4>
							
								<button type="submit" id="shopBtn" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Add to cart
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Product
							Details</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Related
							Products </a></li>
				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						<h4>Product Information</h4>
						
						  <p>${product.detail }</p>
						
					</div>
					<!-- san pham tg tu -->
					<div class="tab-pane fade" id="profile">
						<c:set var="count" value="${allProductById.size()}"/>
							<c:if test="${ count>6 }">
									<c:set var="count" value="6"/>
						    </c:if>
						<c:forEach var="item" items="${allProductById}" begin="0" end="${count}" varStatus="loop">
						<c:if test="${ item.id!=product.id }">
						<div class="row-fluid" >
							<div class="span2" >
								<a href="<c:url value="/product-detail/${ item.id }"/>">
									<img src="/template/web/img/${ item.img }" alt="">	
								</a>
							</div>
							<div class="span6">
								<h5>${ item.name }</h5>
								<p>${ item.detail }</p>
							</div>
							<div class="span4 alignR">
								<form class="form-horizontal qtyFrm">
									<h3>$ ${ item.price }</h3>
									<div class="btn-group">
										<a href="product_details.html" class="defaultBtn"><span
											class=" icon-shopping-cart"></span> Add to cart</a> <a
											href="<c:url value="/product-detail/${ item.id }"/>" class="shopBtn">VIEW</a>
									</div>
								</form>
							</div>
						</div>
						<hr class="soften" />
						 </c:if>	
						</c:forEach>
					</div>					
				</div>
			</div>
		</div>
		<content tag="script">
			<script >
			$('#shopBtn').on("click",function() {
	    	var quantity=$("#quantity").val();
	    	var id=${product.id};
	    	if(quantity=="null"){
	    		quantity=1;
	    	}
	    	window.location= "/addCart/"+id+"/?quantity="+quantity;
	    });
	</script>
		</content>	
		
	
</body>
</html>