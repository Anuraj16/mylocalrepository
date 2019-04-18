<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
 <!--  Login popup -->
    <div class="modal fade" id="myModal" role="dialog" style="opacity:1.5 !important">
    <div class="modal-dialog">
    
      <!-- Login Modal content-->
      <div class="modal-content" id="loginModalId">
        <div class="modal-header" style="padding:35px 50px;">
        <h4><span class="glyphicon glyphicon-lock"></span> Login</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
        <h6 id="loginErrorMessage" style="color:red; display:none;">Invalid Credentials</h6>
        <h6 id="signUpSuccessMessage" style="color:green; display:none;"></h6>
        
           <form:form id="signInForm" name="signInForm" method="POST" modelAttribute="user"
           action="${pageContext.request.contextPath}/j_spring_security_check" onsubmit = "return(validate());">
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
      <!-- login modal ends -->
      
      <!-- signup window starts -->
      
      <div class="modal-content" id="signupModalId" style="display:none;">
        <div class="modal-header" style="padding:35px 50px;">
        <h4><span class="glyphicon glyphicon-lock"></span> Sign Up </h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body" style="padding:40px 50px;">
         	<h6 id="signUpErrorMessage" style="color:red; display:none;"></h6>
           <form:form id="signUpform" method="POST" modelAttribute="user"
           action="${pageContext.request.contextPath}/createUser">
           
           <div class="form-group">
           <%-- <form:label class="btn btn-primary" path="username">User <form:checkbox path="username" class="badgebox" name="username" id="username" /><span class="badge">&check;</span></form:label> --%>
          <!--  <label for="User" class="btn btn-primary">User <input type="checkbox" id="UsId" class="badgebox" checked="checked" disabled="disabled"><span class="badge">&check;</span></label> -->
            <form:label class="btn btn-primary" path="UserType">User <form:checkbox path="UserType" class="badgebox" name="UserType" id="UserTypeId" value="User" disabled="true" checked="checked"/><!-- <span class="badge">&check;</span> --></form:label>
           <form:label class="btn btn-primary" path="UserType">Vendor <form:checkbox path="UserType" class="badgebox" name="UserType" id="UserTypeId" value="Vendor"/><!-- <span class="badge">&check;</span> --></form:label>
           </div>
            <div class="form-group">
          
              <form:label path="username">Username <span style="color:red;">*</span></form:label>
             
              <form:input path="username" class="form-control" name="username" id="username" />
            </div>
            <div class="form-group">
          
               <form:label path="password">Password <span style="color:red;">*</span></form:label>
            
              <form:password path="password" class="form-control" name="password" id="password" />
            </div>

            <div class="form-group">
              
               <form:label path="firstName">First Name <span style="color:red;">*</span></form:label>
      
              <form:input path="firstName" class="form-control" name="firstName" id="firstName" />
            </div>
            <div class="form-group">
              
               <form:label path="lastName">Last Name <span style="color:red;">*</span></form:label>
             
              <form:input path="lastName" class="form-control" name="lastName" id="lastName" />
            </div>
            <div class="form-group">
              
               <form:label path="emailId">Email <span style="color:red;">*</span></form:label>
            
              <form:input path="emailId" class="form-control" name="emailId" id="emailId" />
            </div>
            
            <div class="form-group">
             
               <form:label path="phone">Phone</form:label>
          
              <form:input path="phone" class="form-control" name="phone" id="phone" />
            </div>
            
            
              <form:button id="register" name="register" class="btn btn-success btn-block"><span class="glyphicon glyphicon-off"></span>Register</form:button>
              </form:form>
         
        </div>
        <div class="modal-footer">
          <button type="submit" class="btn btn-danger btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
         
        </div>
      </div>
      
    </div>
    
  </div>