<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- <link rel="stylesheet" href="/views/css/login.css"> -->
<style><%@include file="/views/css/login.css"%></style>
<title>Login</title>
</head>
<body>
	<div class="container">
	<h1 class="titletxt">Login Page</h1>
	<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
		<label><b>User Name</b> </label><br>
		<input type="text" name="username" placeholder="Enter your username" required><br>
		<label><b>Password </b> </label><br>
		<input type="password" name="password" placeholder="Enter your password" required><br>
		<input type="submit" name="submit" class="btn" value="Login"><br>
		<a href ="/HospitalManagementSystem/RegistrationServlet"><h4>Create new Account</h4></a>
		
	</form>
	</div>
</body>
</html>