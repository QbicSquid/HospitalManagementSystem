<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post">
	<input type="text" name="medname" />
	<input type="text" name="quantity" />
	<input type="submit" name="submit" value="submit">
</form>

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
		<td>cost</td>
		<td>${ medicineQty.cost }</td>
	</tr>
	<tr>
		<td>description</td>
		<td>${ medicineQty.description }</td>
	</tr>
	<tr>
		<td>Total price</td>
		<td>${ medicineQty.totalPrice }</td>
	</tr>
	
	
</table>
<form action = "<%=request.getContextPath()%>/cartServlet" method = "post">
<input type="submit" name="add" value="order">

</form>


 
</body>
</html>