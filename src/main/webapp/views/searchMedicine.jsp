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
		<td>quantity</td>
		<td>${ medicineQty.quantity }</td>
	</tr>
	<tr>
		<td>Total price</td>
		<td>${ medicineQty.totalPrice }</td>
	</tr>
	
	
</table>

<% String id="Customer";%>
    <form action="<%=request.getContextPath()%>/views/cart.jsp" method="post">
    <%session.setAttribute("id", id);%>
    	 
    	<input type="hidden" name="medicineID" value=${ medicineQty.id } />
    	<input type="hidden" name="medicineName" value=${ medicineQty.name } />
    	<input type="hidden" name="medicineQty" value=${ medicineQty.quantity } />
    	<input type="hidden" name="medicinePrice" value=${ medicineQty.totalPrice } />	
    	
    	
        <input type="submit" value="order">
    </form>

</body>
</html>