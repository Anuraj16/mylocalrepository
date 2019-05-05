<!DOCTYPE html>
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
    <title>Zariya! | Checkout</title>

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
            <form:form id="customerInfo" name="customerInfo" method="POST" commandName="cartInfo" 
                             action="${pageContext.request.contextPath}/checkoutConfirmation" onsubmit = "return(validate());">
                <div class="row">
                    <div class="col-12 col-lg-8">
                        <div class="checkout_details_area mt-50 clearfix">

                            <div class="cart-title">
                                <h2>Checkout</h2>
                            </div>
                            <h6 id="errorMessage" style="color:red;">All fields are mandatory</h6>
                                <div class="row">
                                    <div class="col-md-6 mb-3">
                                        <!-- <input type="text" class="form-control" id="first_name" value="" placeholder="First Name" required> -->
                                        <form:input path="customerInfo.firstName" class="form-control" placeholder="First Name" name="firstName" id="firstName" />
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <!-- <input type="text" class="form-control" id="last_name" value="" placeholder="Last Name" required> -->
                                        <form:input path="customerInfo.lastName" class="form-control" placeholder="Last Name" name="lastName" id="lastName" />
                                    </div>
                                    <!-- <div class="col-12 mb-3">
                                        <input type="text" class="form-control" id="company" placeholder="Company Name" value="">
                                    </div> -->
                                    <div class="col-12 mb-3">
                                       <!--  <input type="email" class="form-control" id="email" placeholder="Email" value=""> -->
                                       <form:input path="customerInfo.emailId" class="form-control" placeholder="Email" name="emailId" id="emailId" type="email" />
                                    </div>
                                    <div class="col-12 mb-3">
                                    <form:input path="customerInfo.country" class="form-control" placeholder="Country" name="country" id="country" />
                                    </div>
                                    <div class="col-12 mb-3">
                                        <!-- <input type="text" class="form-control mb-3" id="street_address" placeholder="Address" value=""> -->
                                        <form:input path="customerInfo.address" class="form-control" placeholder="Address" name="address" id="address" />
                                    </div>
                                    <div class="col-12 mb-3">
                                        <!-- <input type="text" class="form-control" id="city" placeholder="Town" value=""> -->
                                        <form:input path="customerInfo.city" class="form-control" placeholder="City" name="city" id="city" />
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <!-- <input type="text" class="form-control" id="zipCode" placeholder="Zip Code" value=""> -->
                                        <form:input path="customerInfo.pinCode" class="form-control" placeholder="Pin Code" name="pinCode" id="pinCode" />
                                    </div>
                                    <div class="col-md-6 mb-3">
                                       <!--  <input type="number" class="form-control" id="phone_number" min="0" placeholder="Phone No" value=""> -->
                                       <form:input path="customerInfo.phone" class="form-control" placeholder="Phone" name="phone" id="phone" />
                                    </div>
                                    <div class="cart-btn mt-100">
                               			 <form:button id="submit" name="submit" class="btn amado-btn w-100">Submit</form:button>
                           			</div>
                                    <!-- <div class="col-12 mb-3">
                                        <textarea name="comment" class="form-control w-100" id="comment" cols="30" rows="10" placeholder="Leave a comment about your order"></textarea>
                                    </div> -->

                                </div>
                           
                        </div>
                    </div>
                </form:form>
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
    
    <script>
	function validate(){
		if( document.customerInfo.firstName.value == "" ||  document.customerInfo.lastName.value == "" ||  document.customerInfo.emailId.value == "" ||  document.customerInfo.country.value == "" 
			||  document.customerInfo.address.value == "" ||  document.customerInfo.city.value == "" ||  document.customerInfo.pinCode.value == "" ||  document.customerInfo.phone.value == "" ) {
			 $('#errorMessage').text("Please fill out all fields"); 
			if(document.customerInfo.firstName.value == ""){
        	   document.customerInfo.firstName.style.border = "1px solid red";
           }else{
        	   document.customerInfo.firstName.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.lastName.value == ""){
        	   document.customerInfo.lastName.style.border = "1px solid red";
           }else{
        	   document.customerInfo.lastName.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.emailId.value == ""){
        	   document.customerInfo.emailId.style.border = "1px solid red";
           }else{
        	   document.customerInfo.emailId.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.country.value == ""){
        	   document.customerInfo.country.style.border = "1px solid red";
           }else{
        	   document.customerInfo.country.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.address.value == ""){
        	   document.customerInfo.address.style.border = "1px solid red";
           }else{
        	   document.customerInfo.address.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.city.value == ""){
        	   document.customerInfo.city.style.border = "1px solid red";
           }else{
        	   document.customerInfo.city.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.pinCode.value == ""){
        	   document.customerInfo.pinCode.style.border = "1px solid red";
           }else{
        	   document.customerInfo.pinCode.style.border = "1px solid #ced4da";
           }
           if(document.customerInfo.phone.value == ""){
        	   document.customerInfo.phone.style.border = "1px solid red";
           }else{
        	   document.customerInfo.phone.style.border = "1px solid #ced4da";
           }
           
           
            return false;
         }
		return true;
	}
</script>
<c:if test="${not empty emptyError}">
    <script> 
    $(window).on('load',function(){
    	var msg = "${emptyError}";
    	 $('#errorMessage').text(msg); 
    });
    </script>
</c:if>
</body>

</html>