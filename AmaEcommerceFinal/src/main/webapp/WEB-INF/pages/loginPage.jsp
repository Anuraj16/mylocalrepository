<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/styles/style.css" />">
<link
	href="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
	rel="stylesheet">
<script
	src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" />"></script>
<script
	src="<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" />"></script>
<title>Status Tracker</title>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-offset-5 col-md-3">
				<div class="form-login">
					<header>
						<h4>Login</h4>
					</header>

					<!-- /login?error=true -->
					<c:if test="${param.error == 'true'}">
						<div style="color: red; margin: 10px 0px;">

							Login Failed!!!<br /> Reason :
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

						</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div style="color: #337ab7; margin: 10px 0px;">${msg}</div>
					</c:if>

					<form name='f'
						action="${pageContext.request.contextPath}/j_spring_security_check"
						method='POST'>

						<label>User:</label> <br> <input type='text' name='username'
							value='' class='form-control input-sm chat-input' /> <br> <label>Password:</label>
						<br> <input type='password' name='password'
							class='form-control input-sm chat-input' /> <br>
						<div class="wrapper">
							<span class="group-btn"> <input
								class="btn btn-primary btn-md" name="submit" type="submit"
								value="Login" />
							</span>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-5">
				<div style="text-align: center;">
					<img src="image/comicbg.jpg"
						alt="I told you I want weekly status report. What is it that you dont understand?" />
				</div>
			</div>
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<div style="text-align: center;">
					<img src="image/comicbg2.jpg" style="height: 360px;" alt="Lol" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>