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
	<div class="login">
	<h1 id="logtxt">Login Page</h1>
	<form action="LoginServlet" method="post">
		<label><b>User Name</b> </label><br>
		<input type="text" name="username" placeholder="Enter your username"><br>
		<label><b>Password </b> </label><br>
		<input type="password" name="password" placeholder="Enter your password"><br>
		<input type="submit" name="submit" id="log" value="Login">
	</form>
	</div>
</body>
</html>