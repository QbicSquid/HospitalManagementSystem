<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.hosp.model.User,com.hosp.dbutil.Getuser" %>
<%! User user; %>
<%! Getuser getuser = new Getuser(); %>

<%
	user = getuser.getUser("U_001");
%>
<h1>User details!</h1>
<br />
<table>
	<tr>
		<td>User ID</td>
		<td><%= user.getId() %></td>
	</tr>
	<tr>
		<td>Username</td>
		<td><%= user.getUsername() %></td>
	</tr>
	<tr>
		<td>Password</td>
		<td><%= user.getPassword() %></td>
	</tr>
	<tr>
		<td>First Name</td>
		<td><%= user.getFirstName() %></td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><%= user.getMiddleName() %></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><%= user.getLastName() %></td>
	</tr>
</table>
</body>
</html>