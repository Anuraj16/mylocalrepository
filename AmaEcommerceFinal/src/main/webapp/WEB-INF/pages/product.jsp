<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product</title>
<link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="styles/style.css">
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>

</head>
<body>
<c:if test="${not empty errorMessage }">
     <div class="error-message">
         ${errorMessage}
     </div>
   </c:if>
<form:form id="productFormID" class="form-horizontal" method="POST" modelAttribute="productForm" action="${pageContext.request.contextPath}/product" enctype="multipart/form-data">
  <fieldset>
    <div id="legend">
      <legend class="">Product</legend>
    </div>
    <div class="control-group">
      <form:label path="productCodeSku" class="control-label">Code </form:label>
      <div class="controls">
       			  <c:if test="${not empty productForm.productCodeSku}">
                       <form:hidden path="productCodeSku"/>
                       ${productForm.productCodeSku}
                  </c:if>
                  <c:if test="${empty productForm.productCodeSku}">
                       <form:input path="productCodeSku" name="productCodeSku" id="productCodeSku" class="input-xlarge"/>
                       <form:hidden path="newProduct" />
                  </c:if>
         <form:errors path="productCodeSku" class="error-message" />
      </div>
    </div>
 
    <div class="control-group">
      <form:label path="productName" class="control-label">Name </form:label>
      <div class="controls">
         <form:input path="productName"  name="productName" id="productName" class="input-xlarge"/>
      	 <form:errors path="productName" class="error-message" />
      </div>
    </div>
    
     <div class="control-group">
      <form:label path="productName" class="control-label">Product Description: </form:label>
      <div class="controls">
         <form:textarea path="productDescription"  name="productDescription" id="productDescription" class="input-xlarge"/>
      	 <form:errors path="productDescription" class="error-message" />
      </div>
    </div>
 
    <div class="control-group">
       <form:label path="unitPrice" class="control-label">Price </form:label>
      <div class="controls">
       <form:input path="unitPrice"  name="unitPrice" id="unitPrice" class="input-xlarge"/>
        <form:errors path="unitPrice" class="error-message" />
      </div>
    </div>
 
    <%-- <div class="control-group">
      <form:label path="fileData" class="control-label">Image </form:label> 
      <div class="controls">
         <img src="${pageContext.request.contextPath}/productImage?code=${productForm.productCodeSku}" width="100"/>
      </div>
    </div> --%>
    
     <div class="control-group">
      <form:label path="fileData" class="control-label">Upload Image </form:label>
      <div class="controls">
      <button id="addFiles">Choose Files</button>
      <ul class="list"></ul>
        <%-- <form:input type="file" path="fileData" /> --%>
        <!-- <input type="file" name="fileData" multiple="multiple"/> -->
      </div>
    </div>
 
    <div class="control-group">
      <div class="controls">
        <form:button id="submit" name="submit" class="btn btn-success"><span class="glyphicon glyphicon-off"></span>Save</form:button>
        <form:button id="reset" name="reset" class="btn btn-success"><span class="glyphicon glyphicon-off"></span>Reset</form:button>
      </div>
    </div>
  </fieldset>
  </form:form>
<script>
$('#addFiles').click(function(e) {
    e.preventDefault();
    var nb_attachments = $('form input').length;
    var $input = $('<input type="file" name=fileData>');
    $input.on('change', function(evt) {
        var f = evt.target.files[0];
        $('form').append($(this));
        $('ul.list').append('<li class="item">'+f.name+'('+f.size+')</li>');
    });
    $input.hide();
    $input.trigger('click');
});
</script>
</body>
</html>