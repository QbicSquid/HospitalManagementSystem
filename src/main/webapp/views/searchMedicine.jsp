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
		<td><input type="text" name="medicineID" class="txt-box" value= "${ medicineQty.id }"/></td>
	</tr>
	<tr>
		<td>name</td>
		<td><input type ="text" name="medicineName" class="txt-box" value = "${ medicineQty.name }"/></td>
	</tr>
	<tr>
		<td>cost</td>
		<td><input type ="text" name="medicineCost" class="txt-box" value = "${ medicineQty.cost }"/></td>
	</tr>
	<tr>
		<td>description</td>
		<td><input type ="text" name="medicineDes" class="txt-box" value = "${ medicineQty.description }"/></td>
	</tr>
	<tr>
		<td>Total price</td>
		<td><input type ="text" name="medicinePrice" class="txt-box" value = "${ medicineQty.totalPrice }"/></td>
	</tr>
	
	
</table>

<% String id="Customer";%>
    <form action="<%=request.getContextPath()%>/views/cart.jsp" method="post">
    <%session.setAttribute("id", id);%>
    
        <input type="submit" value="order">
    </form>

</body>
</html>