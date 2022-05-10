<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.hosp.model.*" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%	User user = (User)session.getAttribute("user");
	Customer customer = (Customer) session.getAttribute("customer");
	List<MedicalCondition> medicalConditions=(List<MedicalCondition>) request.getAttribute("medicalCondition");
	
%>

	<form action="<%=request.getContextPath()%>/UpdateCusInfoServlet" method="post">
	<table>
			<tr>
				<td>Customer ID</td>
				<td><%=user.getId() %></td>
			</tr>
			<tr>
				<td>User name</td>
				<td><%=user.getUsername()%></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type = "text" name="firstname" value="<%=user.getFirstName() %>"/></td>
			</tr>
			<tr>
				<td>Middle Name</td>
				<td><input type = "text" name="middlename" value="<%=user.getMiddleName() %>"/></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type = "text" name="lastname" value="<%=user.getLastName() %>"/></td>
			</tr>
			<tr>
				<td>Contact</td>
				<td><input type = "tel" name="contact" value="<%=customer.getContact() %>"/></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type = "email" name="email" value="<%=customer.getEmail() %>"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type = "text" name="address" value="<%=customer.getAddress() %>"/></td>
			</tr>
			<tr>
				<td>Date of Birth</td>
				<td><input type = "date" name="dob" value="<%=customer.getDob() %>"/></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>Gender</td> -->
<!-- 				<td> -->
<%-- 					<input type = "radio" name="gender" value="M" <%= customer.getGender().equals("M")  ?  "checked":"" %> />M --%>
<%-- 					<input type = "radio" name="gender" value="F" <%= customer.getGender().equals("F")  ?  "checked":"" %> />F --%>
<%-- 						<%=customer.getGender() %> --%>
<!-- 				</td> -->
<!-- 			</tr> -->
			
		</table>
		<input type="submit" name="update" value="update">
	</form>
	
<form action="<%=request.getContextPath()%>/MedicalConditionServelet" method="post">
<table>

			<tr>
			
				<td>Add New Medical Condition</td>
			</tr>
			<tr>
			<td><input type="text" name="medcon" placeholder="Add A New Medical Condition Here"/></td>
			<td><input type="submit" name="ADD" value="ADD" /></td>
			</tr>
</table>
</form>
<table border="1">

<%
	for(int i = 0; i < medicalConditions.size(); i++){
%>
				<tr>
					<td><%=i+1 %></td>
					<td><%=medicalConditions.get(i).getDescription() %></td>
					<td>
						<a href="<%=request.getContextPath()%>/MedicalConditionServelet?conId=<%=medicalConditions.get(i).getConditionId()%>"><button>Delete</button></a>
					</td>
				</tr>
<% 
	}
	
%>
			</table>
		
		<a href='/HospitalManagementSystem/LogoutServlet'>Log Out</a>
		
		
<%-- 		<h1>Medical Conditions records: <%=medicalConditions.size() %></h1> --%>

</body>
</html>