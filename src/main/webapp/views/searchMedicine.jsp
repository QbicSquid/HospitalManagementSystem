<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


 
 
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/views/css/style1.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, th, td {
  border: 1px solid black;
  
h4 {text-align: center;}
p {text-align: center;}
}
</style>
</head>
<body>
<div class = "container">
<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post">
	<label for="Search">Search Medicine:</label>
	<input type="text" name="medname" autofocus required/>
	<label for="qty">Add Quantity (between 1 and 30):</label>
	<input type="text" name="quantity" min="1" max="30"/>
	
	<input type="submit" name="submit" value="submit">
</form>


<h4>Searched Medicine</h4>
<table>
	<tr>
		<td>Medicine ID          </td>
		<td>${ medicineQty.id }</td>
		
	</tr>
	<tr>
		<td>Medicine Name        </td>
		<td>${ medicineQty.name }</td>
	</tr>
	<tr>
		<td>Cost per tablet      </td>
		<td>${ medicineQty.cost }</td>
	</tr>
	<tr>
		<td>Medicine Description </td>
		<td>${ medicineQty.description }</td>
	</tr>
	<tr>
		<td>Medicine Quantity    </td>
		<td>${ medicineQty.quantity }</td>
	</tr>
	<tr>
		<td>Total Price          </td>
		<td>${ medicineQty.totalPrice }</td>
		
	</tr>
	
</table>


    <form action="<%=request.getContextPath()%>/views/cart.jsp" method="post">
    
    	 
    	<input type="hidden" name="medicineID" value=${ medicineQty.id } />
    	<input type="hidden" name="medicineName" value=${ medicineQty.name } />
    	<input type="hidden" name="medicineQty" value=${ medicineQty.quantity } />
    	<input type="hidden" name="medicinePrice" value=${ medicineQty.totalPrice } />	<br><br>
    	
    	
        <input type="submit" value="order">
    </form>
</div>
</body>
</html>