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
		<td>${ medicine.id }</td>
	</tr>
	<tr>
		<td>name</td>
		<td>${ medicine.name }</td>
	</tr>
	<tr>
		<td>cost</td>
		<td>${ medicine.cost }</td>
	</tr>
	<tr>
		<td>description</td>
		<td>${ medicine.description }</td>
	</tr>
	<tr>
		<td>Total price</td>
		<td>${ quantity.tprice }</td>
	</tr>
	
	
</table>

<form id="form1" action="addtocart" method="post">
<button type="submit" form="form1"  class="btn btn-warning" name="cartid" value="submit">Add to cart </button>
</form>
</body>
</html>