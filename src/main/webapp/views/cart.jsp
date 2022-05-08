<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
 <%@ page import ="java.util.ArrayList"%>
 <%@ page import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>id</td>
		<td>${ medicineQty.id }</td>
	</tr>
	<tr>
		<td>name</td>
		<td>${ medicineQty.name }</td>
	</tr>
	<tr>
		<td>Total price</td>
		<td>${ medicineQty.totalPrice }</td>
	</tr>
	
	
</table>

</body>
</html>