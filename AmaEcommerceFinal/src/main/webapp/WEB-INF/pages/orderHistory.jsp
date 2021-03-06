<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Zariya! | Cart</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="styles/core-style.css">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/additionalStyles.css">

</head>

<body>
    <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="Type your keyword...">
                            <button type="submit"><img src="img/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Wrapper Area End -->

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">

        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logoz.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

        <!-- Header Area Start -->
        <jsp:include page="_header.jsp"></jsp:include>
        <!-- Header Area End -->

        <div class="cart-table-area section-padding-100">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-12 col-lg-12">
                        <div class="cart-title mt-50">
                            <h2>Order History</h2>
                        </div>

                        <div class="cart-table clearfix">
                       
                            <table class="table table-responsive">
                             <c:forEach items="${orderInfoList}" var="orderInfoList" varStatus="varstatus">
                                <thead>
                                	<tr>
                                        <th><span>Order Placed</span></th>
                                        <th><span>Total</span></th>
                                        <th><span>Order #</span></th>
                                	</tr>
                                    <tr>
                                        <th><span><c:out value="${orderInfoList.orderDate}"/></span></th>
                                        <th><span><c:out value="${orderInfoList.amount}"/></span></th>
                                        <th><span><c:out value="${orderInfoList.orderNum}"/></span></th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${orderInfoList.details}" var="details" varStatus="dVarstatus">
                                 	<tr>
                                 		<th style="width: 25%">&nbsp;&nbsp;</th>
                                        <th style="width: 25%"><span>Name</span></th>
                                        <th style="width: 25%"><span>Price</span></th>
                                        <th style="width: 25%"><span>Amount</span></th>
                                    </tr>
                                <tr>
                                        <td class="cart_product_img">
                                            <a href="#"><img src="${details.imageUrl}" alt="Product"></a>
                                        </td>
                                        <td class="cart_product_desc">
                                            <h5><c:out value="${details.productName}"/></h5>
                                        </td>
                                        <td class="price">
                                            <span><c:out value="${details.price}"/></span>
                                        </td>
                                        <td class="price">
                                            <span><c:out value="${details.amount}"/></span>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    </tbody> 
                                </c:forEach>
                                     <!-- <tr>
                                        <td class="cart_product_img">
                                            <a href="#"><img src="img/bg-img/cart2.jpg" alt="Product"></a>
                                        </td>
                                        <td class="cart_product_desc">
                                            <h5>Minimal Plant Pot</h5>
                                        </td>
                                        <td class="price">
                                            <span>$10</span>
                                        </td>
                                        <td class="qty">
                                            <div class="qty-btn d-flex">
                                                <p>Qty</p>
                                                <div class="quantity">
                                                    <span class="qty-minus" onclick="var effect = document.getElementById('qty2'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                    <input type="number" class="qty-text" id="qty2" step="1" min="1" max="300" name="quantity" value="1">
                                                    <span class="qty-plus" onclick="var effect = document.getElementById('qty2'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="cart_product_img">
                                            <a href="#"><img src="img/bg-img/cart3.jpg" alt="Product"></a>
                                        </td>
                                        <td class="cart_product_desc">
                                            <h5>Minimal Plant Pot</h5>
                                        </td>
                                        <td class="price">
                                            <span>$10</span>
                                        </td>
                                        <td class="qty">
                                            <div class="qty-btn d-flex">
                                                <p>Qty</p>
                                                <div class="quantity">
                                                    <span class="qty-minus" onclick="var effect = document.getElementById('qty3'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                                    <input type="number" class="qty-text" id="qty3" step="1" min="1" max="300" name="quantity" value="1">
                                                    <span class="qty-plus" onclick="var effect = document.getElementById('qty3'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>  -->
                                <%-- </c:if> --%>
                                    <h3 id="noItemsMessageId" style="color:red; display:none;" align="center"></h3>
                            </table>
                        </div>
                    </div>
                    <%-- <div class="col-12 col-lg-4">
                        <div class="cart-summary">
                            <h5>Cart Total</h5>
                            <ul class="summary-table">
                                <li><span>subtotal:</span> <span><c:out value="${cartInfo.subTotal}"/></span></li>
                                <li><span>delivery:</span> <span>Free</span></li>
                                <li><span>total:</span> <span><c:out value="${cartInfo.subTotal}"/></span></li>
                            </ul>
                            <div class="cart-btn mt-100">
                                <a href="${pageContext.request.contextPath}/checkout" class="btn amado-btn w-100">Checkout</a>
                            </div>
                        </div>
                    </div> --%>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
    <%-- <section class="newsletter-area section-padding-100-0">
        <div class="container">
            <div class="row align-items-center">
                <!-- Newsletter Text -->
                <div class="col-12 col-lg-6 col-xl-7">
                    <div class="newsletter-text mb-100">
                        <h2>Subscribe for a <span>25% Discount</span></h2>
                        <p>Nulla ac convallis lorem, eget euismod nisl. Donec in libero sit amet mi vulputate consectetur. Donec auctor interdum purus, ac finibus massa bibendum nec.</p>
                    </div>
                </div>
                <!-- Newsletter Form -->
                <div class="col-12 col-lg-6 col-xl-5">
                    <div class="newsletter-form mb-100">
                        <form action="#" method="post">
                            <input type="email" name="email" class="nl-email" placeholder="Your E-mail">
                            <input type="submit" value="Subscribe">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section> --%>
    <!-- ##### Newsletter Area End ##### -->

    <!-- ##### Footer Area Start ##### -->
    <jsp:include page="_footer.jsp"/>
    <!-- ##### Footer Area End ##### -->

    <!-- ##### jQuery (Necessary for All JavaScript Plugins) ##### -->
    <script src="script/jquery/jquery-2.2.4.min.js"></script>
    <!-- Popper js -->
    <script src="script/popper.min.js"></script>
    <!-- Bootstrap js -->
    <script src="script/bootstrap.min.js"></script>
    <!-- Plugins js -->
    <script src="script/plugins.js"></script>
    <!-- Active js -->
    <script src="script/active.js"></script>

	<c:if test="${not empty noItemsMsg}">
    <script> 
    $(window).on('load',function(){
    	var msg = "${noItemsMsg}";
    	$('#noItemsMessageId').show();
        $('#noItemsMessageId').append(msg);
    });
    </script>
</c:if>
</body>

</html>