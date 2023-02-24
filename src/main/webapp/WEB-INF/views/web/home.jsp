<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chu</title>
</head>
<body>
	<!-- Body Section -->
	
	
		
		
		<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">
					<div class="carousel-inner">
					<c:forEach var="item" items="${slides}" varStatus="index">
					   <c:if test="${index.first}">
					     <div class="item active">
					     <img style="width: 100%" 
							src="template/web/img/${ item.img }"
							alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4>${item.caption}</h4>
								<p>
									<span>${item.content}</span>
								</p>
							</div>
					     </div>
					   </c:if>
					   <c:if test="${not index.first}">
					     <div class="item">
					     <img style="width: 100%" 
							src="template/web/img/${ item.img }"
							alt="bootstrap ecommerce templates">
							<div class="carousel-caption">
								<h4>${item.caption}</h4>
								<p>
									<span>${item.content}</span>
								</p>
							</div>
						</div>
					   </c:if>					   			
					</c:forEach>
				</div>
				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">&lsaquo;
				</a>
				<a class="right carousel-control"
					href="#myCarousel" data-slide="next">&rsaquo;
				</a>
			</div>
		</div>
			
<!--New Products-->
			<div class="well well-small">
				<h3>New Products</h3>
				<hr class="soften" />
				<div class="row-fluid">
					<div id="newProductCar" class="carousel slide">
						<div class="carousel-inner">
						
						 <c:if test="${ highlight.size() > 0 }">
							<div class="item active">
								<ul class="thumbnails">
								<c:forEach var="item" items="${ highlight }" varStatus="loop">
									<li class="span3">
										<div class="thumbnail">
											<a class="zoomTool" href="<c:url value="product_detail/${ item.id }" />"
												title="add to cart"><span "class="icon-search"></span>
												QUICK VIEW</a> <a href="product_detail/${ item.id }" class="tag"></a> 
											<a href="product_detail/${ item.id }"><img src="/template/web/img/${item.img}" alt="bootstrap-ring"></a>
										</div>
									</li>
									<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1)  == highlight.size() }">
											</ul>
										</div>
										<c:if test="${ (loop.index + 1) < highlight.size() }">
											<div class="item">
												<ul class="thumbnails">
										</c:if>
									</c:if>		
								</c:forEach>
						</c:if>
						</div>
						
						<a class="left carousel-control" href="#newProductCar"
							data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
							href="#newProductCar" data-slide="next">&rsaquo;</a>
					</div>
				</div>
			</div>
	<!-- Products-->
			<div class="well well-small">
				<h3>
					<a class="btn btn-mini pull-right" href="products.html"
						title="View more">VIew More<span class="icon-plus"></span></a>Products
				</h3>
				<hr class="soften" />
				<div class="row-fluid">

					 <c:if test="${ products.size() > 0 }"> 
						<ul class="thumbnails">
							<c:forEach var="item" items="${ products }" varStatus="loop">
								<li class="span4">
									<div class="thumbnail">
										<a class="zoomTool" href="product-detail/${ item.id }" title="add to cart"><span
											class="icon-search"></span> QUICK VIEW</a> 
										<a href="product-detail/${ item.id }">
											<img src="template/web/img/${ item.img }" alt=""></a>
										<div class="caption">
											<h5>${ item.name }</h5>
											<h4>
												<a class="defaultBtn" href="product-detail/${ item.id }"
													title="Click to view"><span class="icon-zoom-in"></span></a>
												<a class="shopBtn" href="<c:url value="/addCart/${item.id}" />" title="add to cart"><span class="icon-plus"></span></a> 
												<span class="pull-right">$ ${ item.price }</span>
											</h4>
										</div>
									</div>
								</li>
								<c:if test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1)  == products.size() }">
									</ul>
									<c:if test="${ (loop.index + 1) < products.size() }">
										<ul class="thumbnails">
									</c:if>
								</c:if>					 
							</c:forEach>
					</c:if>
				</div>
				<ul class="pagination" id="pagination"></ul>
			</div>
			<!-- <div class="well well-small">
				<a class="btn btn-mini pull-right" href="#">View more <span
					class="icon-plus"></span></a> Popular Products
			</div> -->
		</div> 
	
	
	<script type="text/javascript">
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: 35,
            visiblePages: 2,
            onPageClick: function (event, page) {
                console.info(page + ' (from options)');
            }
        });
    });
</script>

</body>
</html>