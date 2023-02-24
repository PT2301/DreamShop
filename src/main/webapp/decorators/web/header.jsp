<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="DreamShop.utill.SecurityUtill"  %>
<%@ include file="/taglib.jsp"%>

<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="index.html"><span>Twitter Bootstrap ecommerce template</span> <img
					src="<c:url value="/template/web/img/logo-bootstrap-shoping-cart.png" />"
					alt="bootstrap sexy shop"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML template is available @ $14
				</h1>
			</div>
		</div>
		<div class="span4 alignR">			
			<ul class="nav ace-nav">
                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        Xin chào
                        
                    </a>
                </li>
                 <li class="light-blue dropdown-modal">
                     <a href="<c:url value='/logout'/>">
                         <i class="ace-icon fa fa-power-off"></i>
                          logout
                     </a>
                 </li>
            </ul>
			
			<a href="<c:url value="/cart"/>" class="btn btn-mini">[ ${TotalProduct} ] <span  class="icon-shopping-cart"></span></a> 
			<span class="btn btn-warning btn-mini">$</span> 
			<span class="btn btn-mini">&pound;</span>
			<span class="btn btn-mini">&euro;</span>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav" >
				<c:forEach var="item" items="${menus}" varStatus="index">
					   <c:if test="${index.first}">
					     <li class="active"><a href="index.html" >  ${item.name}</a></li>
					   </c:if>
					   <c:if test="${not index.first}">
					     <li class=""><a href="index.html">  ${item.name}</a></li>
					   </c:if>					   			
					</c:forEach>
				</ul>
				
				<form action="/search" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="s span2"id="key"name="key">
				</form>
				
				<ul class="nav pull-right">
					<li class="dropdown"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"><span class="icon-lock"></span>
							Login <b class="caret"></b></a>
						<div class="dropdown-menu">
							<form class="form-horizontal loginFrm">
								<div class="control-group">
									<input type="text" class="span2" id="inputEmail"
										placeholder="Email">
								</div>
								<div class="control-group">
									<input type="password" class="span2" id="inputPassword"
										placeholder="Password">
								</div>
								<div class="control-group">
									<label class="checkbox"> <input type="checkbox">
										Remember me
									</label>
									<button type="submit" class="shopBtn btn-block">Sign
										in</button>
								</div>
							</form>
						</div></li>
				</ul>
			</div>
		</div>
	</div>
</div>
