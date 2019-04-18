<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Zariya! | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="styles/core-style.css">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/additionalStyles.css">
    <!--bootstrap css inclusion  -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
    <fmt:setBundle basename="validator" />

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

        <!-- Product Catagories Area Start -->
        <div class="products-catagories-area clearfix">
            <div class="amado-pro-catagory clearfix">

				<c:forEach items="${productinfoList}" var="prodInfo">
				<div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/productDetails?code=${prodInfo.productCodeSku}">
                        <img src="${prodInfo.imageUrl}" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From ${prodInfo.unitPrice}</p>
                            <h4>${prodInfo.productName}</h4>
                        </div>
                    </a>
                </div>
                <div style="z-index: 1" class="clearfix">
                   <button type="button" class="btn btn-primary">Primary</button>
                 </div>
				</c:forEach>
            </div>
        </div>
        <!-- Product Catagories Area End -->
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
    <%-- <section class="newsletter-area section-padding-100-0">
        <div class="container">
            <div class="row align-items-center">
                <!-- Newsletter Text -->
                <div class="col-12 col-lg-6 col-xl-7">
                    <!-- <div class="newsletter-text mb-100">
                        <h2>Subscribe for a <span>25% Discount</span></h2>
                        <p>Nulla ac convallis lorem, eget euismod nisl. Donec in libero sit amet mi vulputate consectetur. Donec auctor interdum purus, ac finibus massa bibendum nec.</p>
                    </div> -->
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
    <footer class="footer_area clearfix">
        <div class="container">
            <div class="row align-items-center">
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-4">
                    <div class="single_widget_area">
                        <!-- Logo -->
                        <div class="footer-logo mr-50">
                            <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logoz.png" alt=""></a>
                        </div>
                        <!-- Copywrite Text -->
                        <p class="copywrite">
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved
</p>
                    </div>
                </div>
                <!-- Single Widget Area -->
                <div class="col-12 col-lg-8">
                    <div class="single_widget_area">
                        <!-- Footer Menu -->
                        <div class="footer_menu">
                            <nav class="navbar navbar-expand-lg justify-content-end">
                                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#footerNavContent" aria-controls="footerNavContent" aria-expanded="false" aria-label="Toggle navigation"><i class="fa fa-bars"></i></button>
                                <div class="collapse navbar-collapse" id="footerNavContent">
                                    <ul class="navbar-nav ml-auto">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/index">Home</a>
                                        </li>
                                        <%-- <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/shop">Shop</a>
                                        </li> --%>
                                      <%--   <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/productDetails">Product</a>
                                        </li> --%>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/cart">Cart</a>
                                        </li>
                                        <%-- <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/checkout">Checkout</a>
                                        </li> --%>
                                    </ul>
                                </div>
                            </nav>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- ##### Footer Area End ##### -->
   <jsp:include page="_loginPopup.jsp"/>

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
    
<!-- login error -->
<c:if test="${param.error != null}">
    <script> 
    $(window).on('load',function(){
        $('#myModal').modal('show');
        $('#signUpSuccessMessage').hide(); 	
        $('#loginErrorMessage').show(); 	
    });
    </script>
</c:if>

<!-- user creation error -->
<c:if test="${not empty regError}">
    <script> 
    $(window).on('load',function(){
    	var error = "${regError}";
        $('#myModal').modal('show');
        $('#loginModalId').hide(); $('#signupModalId').show();
        $('#signUpErrorMessage').text(error);
        $('#signUpErrorMessage').show(); 	
    });
    </script>
</c:if>
<!-- user created successfully -->
<c:if test="${not empty regSuccess}">
    <script> 
    $(window).on('load',function(){
    	var success = "${regSuccess}";
        $('#myModal').modal('show');
        $('#signupModalId').hide(); $('#loginModalId').show(); 
        $('#signUpSuccessMessage').text(success);
        $('#loginErrorMessage').hide(); 	
        $('#signUpSuccessMessage').show(); 	
    });
    </script>
</c:if>

<!-- user created successfully -->
<c:if test="${not empty showLogin}">
    <script> 
    $(window).on('load',function(){
    	var msg = "${showLogin}";
        $('#myModal').modal('show');
        $('#signupModalId').hide(); $('#loginModalId').show(); 
        $('#signUpSuccessMessage').text(msg);
        $('#loginErrorMessage').hide(); 	
        $('#signUpSuccessMessage').show(); 	
    });
    </script>
</c:if>

<script>
	function validate(){
		if( document.signInForm.username.value == "" && document.signInForm.password.value == "" ) {
            document.signInForm.username.focus() ;
            document.signInForm.password.focus() ;
            $('#loginErrorMessage').text("Username and password required"); 
            $('#loginErrorMessage').show(); 
            return false;
         }
		if( document.signInForm.password.value == "" ) {
            document.signInForm.password.focus() ;
            $('#loginErrorMessage').text("Password required"); 
            $('#loginErrorMessage').show(); 
            return false;
         }
		if( document.signInForm.username.value == "" ) {
            document.signInForm.username.focus() ;
            $('#loginErrorMessage').text("Username required"); 
            $('#loginErrorMessage').show(); 
            return false;
         }
		return true;
	}
</script>
</body>

</html>