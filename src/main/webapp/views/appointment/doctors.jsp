<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="/views/css/style1.css"%></style>
<style><%@include file="/views/css/table1.css"%></style>
</head>
<body>
<%@ page import="com.hosp.model.Doctor" %>
<%! Doctor[] doctors; %>
<div class="container">
<h1 class="titletxt">Available Doctors</h1>
<table class="mtable">
	<tr>
		<th>Doctor ID</th>
		<th>Name</th>
		<th>Specialication</th>
		<th>Gender</th>
		<th>Cost (Rs)</th>
	</tr>
<%
doctors = (Doctor[])request.getAttribute("doctors");
for (Doctor d: doctors) {
%>
	<tr>
			<td>
				<form action="<%=request.getContextPath()%>/DocSchedule" method="post">
				<input type="submit" name="doctor" value="<%=d.getId()%>" class="btn2">
				</form>
			</td>
			<td>
				<%= d.getFirstName() %> <%= d.getMiddleName() %> <%= d.getLastName() %>
			</td>
			<td><%= d.getSpecialization() %></td>
			<td><%= d.getGender() %></td>
			<td><%= d.getCost() %></td>
	</tr>
<%
}
%>
		</table>
	</div>
</body>
</html>