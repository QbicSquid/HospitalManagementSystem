<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
  
<%@page import="com.hosp.model.OrderedMedicine, com.hosp.dbutil.MedicineDAO" %>
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
		
		<td><%= request.getParameter("medicineID")%></td>
		
	</tr>
	<tr>
		<td>name</td>
		<td><%= request.getParameter("medicineName")%></td>
	</tr>
	<tr>
		<td>Quantity</td>
		<td><%= request.getParameter("medicineQty")%></td>
	</tr>
	<tr>
		<td>Total price</td>
		<td><%= request.getParameter("medicinePrice")%></td>
	</tr>
	
	
	
</table>

<form action="<%=request.getContextPath()%>/medicineOrderServlet" method="post">
<!--  
<input type="hidden" name="medicineID" value="<%= request.getParameter("medicineID")%>" />
<input type="hidden" name="medicineName" value="<%= request.getParameter("medicineName")%>" />
<input type="hidden" name="quantity" value="<%= request.getParameter("medicineQty")%>" />
<input type="hidden" name="medicinePrice" value="<%= request.getParameter("medicinePrice")%>" />
-->
		<input type="text" name="custID" />
		<input type="text" name="paymentID" />
		<input type="text" name="deliveryAddress" />
    	<input type="text" name="deliveryState" />
    	<input type="text" name="Date" />

<button type="submit"   class="btn btn-warning" name="insert" value="submit">Place Order</button>
</form>





</body>
</html>