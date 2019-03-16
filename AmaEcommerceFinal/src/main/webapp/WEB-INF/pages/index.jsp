<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Amado - Furniture Ecommerce Template | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="styles/core-style.css">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="styles/bootstrap.min.css">
    <link rel="stylesheet" href="styles/additionalStyles.css">
    <!--bootstrap css inclusion  -->
    <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"> -->
    

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
                <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logo.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

        <!-- Header Area Start -->
        <header class="header-area clearfix">
            <!-- Close Icon -->
            <div class="nav-close">
                <i class="fa fa-close" aria-hidden="true"></i>
            </div>
            <!-- Logo -->
            <div class="logo">
                <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logo.png" alt=""></a>
            </div>
            <!-- Amado Nav -->
            <nav class="amado-nav">
                <ul>
                	<!-- <li class="active">
                	</li> -->
                	<c:choose>
                	<c:when test="${pageContext.request.userPrincipal.name != null}">
                	<li><span>Welcome ${pageContext.request.userPrincipal.name}</span></li>
                	<li><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
                	<security:authorize  access="hasRole('ROLE_USER')">
                	<li><a href="${pageContext.request.contextPath}/orders">Orders</a></li>
                	</security:authorize>
                	</c:when>
                	<c:otherwise>
                	<li>
						<a href="#" data-toggle="modal" data-target="#myModal" onClick="$('#loginModalId').show(); $('#signupModalId').hide()">Login/Signup</a>
                	</li>
                	</c:otherwise>
                	</c:choose>
                    <%-- <li class="active"><a href="${pageContext.request.contextPath}/index">Home</a></li> --%>
                    <li><a href="${pageContext.request.contextPath}/shop">Shop</a></li>
                    <li><a href="${pageContext.request.contextPath}/productDetails">Product</a></li>
                    <li><a href="${pageContext.request.contextPath}/cart">Cart</a></li>
                    <li><a href="${pageContext.request.contextPath}/checkout">Checkout</a></li>
                </ul>
            </nav>
            <!-- Button Group -->
            <div class="amado-btn-group mt-30 mb-100">
                <a href="#" class="btn amado-btn mb-15">%Discount%</a>
                <a href="#" class="btn amado-btn active">New this week</a>
            </div>
            <!-- Cart Menu -->
            <div class="cart-fav-search mb-100">
                <a href="${pageContext.request.contextPath}/cart" class="cart-nav"><img src="img/core-img/cart.png" alt=""> Cart <span>(0)</span></a>
                <a href="#" class="fav-nav"><img src="img/core-img/favorites.png" alt=""> Favourite</a>
                <a href="#" class="search-nav"><img src="img/core-img/search.png" alt=""> Search</a>
            </div>
            <!-- Social Button -->
            <div class="social-info d-flex justify-content-between">
                <a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
            </div>
        </header>
        <!-- Header Area End -->

        <!-- Product Catagories Area Start -->
        <div class="products-catagories-area clearfix">
            <div class="amado-pro-catagory clearfix">

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/1.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $180</p>
                            <h4>Modern Chair</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/2.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $180</p>
                            <h4>Minimalistic Plant Pot</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/3.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $180</p>
                            <h4>Modern Chair</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/4.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $180</p>
                            <h4>Night Stand</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/5.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $18</p>
                            <h4>Plant Pot</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/6.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $320</p>
                            <h4>Small Table</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/7.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $318</p>
                            <h4>Metallic Chair</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/8.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $318</p>
                            <h4>Modern Rocking Chair</h4>
                        </div>
                    </a>
                </div>

                <!-- Single Catagory -->
                <div class="single-products-catagory clearfix">
                    <a href="${pageContext.request.contextPath}/shop">
                        <img src="img/bg-img/9.jpg" alt="">
                        <!-- Hover Content -->
                        <div class="hover-content">
                            <div class="line"></div>
                            <p>From $318</p>
                            <h4>Home Deco</h4>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <!-- Product Catagories Area End -->
    </div>
    <!-- ##### Main Content Wrapper End ##### -->

    <!-- ##### Newsletter Area Start ##### -->
    <section class="newsletter-area section-padding-100-0">
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
    </section>
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
                            <a href="${pageContext.request.contextPath}/index"><img src="img/core-img/logo2.png" alt=""></a>
                        </div>
                        <!-- Copywrite Text -->
                        <p class="copywrite"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
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
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/shop">Shop</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/productDetails">Product</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/cart">Cart</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="${pageContext.request.contextPath}/checkout">Checkout</a>
                                        </li>
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
    <!--  Login popup -->
    <div class="modal fade" id="myModal" role="dialog" style="opacity:1.5 !important">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" id="loginModalId">
        <div class="modal-header" style="padding:35px 50px;">
        <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
           <form:form id="signInForm" method="POST" modelAttribute="user"
           action="${pageContext.request.contextPath}/j_spring_security_check">
            <div class="form-group">
               <form:label path="username"><span class="glyphicon glyphicon-user"></span>Username</form:label>
              <!-- <input type="text" class="form-control" name="username" placeholder="Enter email"> -->
              <form:input path="username" class="form-control" name="username" id="username" />
            </div>
            <div class="form-group">
              <form:label path="password"><span class="glyphicon glyphicon-eye-open"></span> Password</form:label>
              <form:password path="password" class="form-control" name="password" id="password" />
            </div>
            <!-- commented for now will be added later -->
           <%--  <div class="checkbox">
              <!-- <label><input type="checkbox" value="" checked>Remember me</label> -->
               <form:label path="rememberMe"><form:input path="rememberMe" type="checkbox" class="form-control" id="rememberMe" /> Password</form:label>
            </div> --%>
             <!--  <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button> -->
              
               <form:button id="submit" name="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</form:button>
         </form:form>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
          <p>Not a member? 
          	<a href="#" onClick="$('#loginModalId').hide(); $('#signupModalId').show()">
                                            Sign Up Here
                                        </a>
          </p>
          <p>Forgot <a href="#">Password?</a></p>
        </div>
      </div>
      
      
      <!-- signup window starts -->
      
      <div class="modal-content" id="signupModalId" style="display:none;">
        <div class="modal-header" style="padding:35px 50px;">
        <h4><span class="glyphicon glyphicon-lock"></span> Sign Up </h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
          <!-- <form role="form" action="LoginUser" name="Customers" method="post"> -->
          <%-- <form method="POST"
           action="${pageContext.request.contextPath}/j_spring_security_check"> --%>
           <form:form id="signUpform" method="POST" modelAttribute="user"
           action="${pageContext.request.contextPath}/createUser">
            <div class="form-group">
             <!--  <label for="usrname"><span class="glyphicon glyphicon-user"></span> Username</label> -->
              <form:label path="username"><span class="glyphicon glyphicon-user"></span>Username</form:label>
              <!-- <input type="text" class="form-control" name="username" placeholder="Enter email"> -->
              <form:input path="username" class="form-control" name="username" id="username" />
            </div>
            <div class="form-group">
              <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
               <form:label path="password"><span class="glyphicon glyphicon-eye-open"></span> Password</form:label>
             <!--  <input type="text" class="form-control" name="password" placeholder="Enter password"> -->
              <form:password path="password" class="form-control" name="password" id="password" />
            </div>
           <!--  <div class="checkbox">
              <label><input type="checkbox" value="" checked>Remember me</label>
            </div> -->
            
            
            
            <div class="form-group">
              <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
               <form:label path="firstName"><span class="glyphicon glyphicon-eye-open"></span> First Name</form:label>
             <!--  <input type="text" class="form-control" name="password" placeholder="Enter password"> -->
              <form:input path="firstName" class="form-control" name="firstName" id="firstName" />
            </div>
            <div class="form-group">
              <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
               <form:label path="lastName"><span class="glyphicon glyphicon-eye-open"></span> Last Name</form:label>
             <!--  <input type="text" class="form-control" name="password" placeholder="Enter password"> -->
              <form:input path="lastName" class="form-control" name="lastName" id="lastName" />
            </div>
            <div class="form-group">
              <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
               <form:label path="emailId"><span class="glyphicon glyphicon-eye-open"></span> Email</form:label>
             <!--  <input type="text" class="form-control" name="password" placeholder="Enter password"> -->
              <form:input path="emailId" class="form-control" name="emailId" id="emailId" />
            </div>
            
            <div class="form-group">
              <!-- <label for="psw"><span class="glyphicon glyphicon-eye-open"></span> Password</label> -->
               <form:label path="phone"><span class="glyphicon glyphicon-eye-open"></span> Phone</form:label>
             <!--  <input type="text" class="form-control" name="password" placeholder="Enter password"> -->
              <form:input path="phone" class="form-control" name="phone" id="phone" />
            </div>
            
              <!-- <button type="submit" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span> Login</button> -->
              <form:button id="register" name="register" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Register</form:button>
              </form:form>
          <%-- </form> --%>
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         <!--  <p>Not a member? 
          	<a href="#" onClick="$('#loginbox').hide(); $('#signupbox').show()">
                                            Sign Up Here
                                        </a>
          </p>
          <p>Forgot <a href="#">Password?</a></p> -->
        </div>
      </div>
      
    </div>
    
  </div>

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

</body>

</html>