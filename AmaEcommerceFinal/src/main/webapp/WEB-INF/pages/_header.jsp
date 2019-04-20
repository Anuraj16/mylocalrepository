<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logoz.png" alt=""></a>
            </div>
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                	<!-- <li class="active">
                	</li> -->
                	<li><a href="${pageContext.request.contextPath}/index">Home</a></li>
                	<c:choose>
                	<c:when test="${pageContext.request.userPrincipal.name != null}">
                	<li><span style="color:#131212;font-size:14px;">Welcome ${pageContext.request.userPrincipal.name}</span></li>
                	<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                	<security:authorize  access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                	<li><a href="${pageContext.request.contextPath}/orderHistory">Orders</a></li>
                	</security:authorize>
                	<security:authorize  access="hasRole('ROLE_VENDOR')">
                	<li><a href="${pageContext.request.contextPath}/product">Create Product</a></li>
                	</security:authorize>
                	</c:when>
                	<c:otherwise>
                	<li>
						<a href="#" data-toggle="modal" data-target="#myModal" onClick="$('#loginModalId').show(); $('#signupModalId').hide()">Login/Signup</a>
                	</li>
                	</c:otherwise>
                	</c:choose>
                    <%-- <li><a href="${pageContext.request.contextPath}/shop">Shop</a></li> --%>
                    <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
                </ul>
            </nav>
            <!-- Button Group -->
            <!-- <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div> -->
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="${pageContext.request.contextPath}/cart" class="cart-nav"><img src="img/core-img/cart.png" alt=""> Cart <span>0</span></a>
              <!--   <a href="#" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> Favourite</a>
                <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a> -->
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>