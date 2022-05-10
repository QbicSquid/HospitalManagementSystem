<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.hosp.model.OrderedMedicine, com.hosp.dbutil.MedicineDAO" %>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/views/css/style1.css"%>

table, th, td {
  border: 1px solid black;
  
  
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<div class = "container">
<table>
	<tr>
		<td>Medicine ID</td>
		
		<td><%= request.getParameter("medicineID")%></td>
		
	</tr>
	<tr>
		<td>Medicine Name</td>
		<td><%= request.getParameter("medicineName")%></td>
	</tr>
	<tr>
		<td>Medicine Quantity</td>
		<td><%= request.getParameter("medicineQty")%></td>
	</tr>
	<tr>
		<td>Total Price</td>
		<td><%= request.getParameter("medicinePrice")%></td>
	</tr>
	
	
	
</table><br><br>


	<form action="<%=request.getContextPath()%>/medicineOrderServlet" method="post">
	<!--  
	<input type="hidden" name="medicineID" value="<%= request.getParameter("medicineID")%>" />
	<input type="hidden" name="medicineName" value="<%= request.getParameter("medicineName")%>" />
	<input type="hidden" name="quantity" value="<%= request.getParameter("medicineQty")%>" />
	<input type="hidden" name="medicinePrice" value="<%= request.getParameter("medicinePrice")%>" />
	-->
			<label for="custid"> Enter Customer ID                </label>
			<input type="text" name="custID" /><br><br>
			
			<label for="payid"> Enter Payment ID                  </label>
			<input type="text" name="paymentID" /><br><br>
			
			<label for="address"> Enter Customer Delivery Address </label>
			<input type="text" name="deliveryAddress" /><br><br>
			
			<label for="state"> Enter Customer Delivery State     </label>
	    	<input type="text" name="deliveryState" /><br><br>
	    	
	    	<label for="date"> Enter Date                         </label>
	    	<input type="date" name="Date" min="2022-05-10"/><br><br>
	
	<button type="submit"   class="btn btn-warning" name="insert" value="submit">Place Order</button>
	</form>
</div>
</body>
</html>