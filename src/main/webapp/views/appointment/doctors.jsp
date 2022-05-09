<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.hosp.model.Doctor" %>
<%! Doctor[] doctors; %>
<%
doctors = (Doctor[])request.getAttribute("doctors");
for (Doctor d: doctors) {
%>
<form action="<%=request.getContextPath()%>/DocSchedule" method="post">
	<table>
		<tr>
			<td>
				<input type="submit" name="doctor" value="<%=d.getId()%>">
				<%= d.getFirstName() %> <%= d.getMiddleName() %> <%= d.getLastName() %>
			</td>
			<td><%= d.getSpecialization() %></td>
			<td><%= d.getGender() %></td>
			<td><%= d.getCost() %></td>
		</tr>
	</table>
</form>
<%
}
%>
</body>
</html>