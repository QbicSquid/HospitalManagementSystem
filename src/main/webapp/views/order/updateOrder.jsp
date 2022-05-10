<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.hosp.model.OrderedMedicine, com.hosp.dbutil.MedicineDAO" %>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/views/css/style1.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class = "container">

<form action = "<%=request.getContextPath() %>/updateMedicineServlet"method ="post">
	<table>
		<tr>
			<td>OrderId</td>
			<td><input type = "text" name = "ordrId" maxlength="5" size="5"/></td>
			
		</tr>
		<tr>
			<td>custID</td>
			<td><input type = "text" name = "custId" maxlength="5" size="5"/></td>
		</tr>
		<tr>
			<td>paymentID</td>
			<td><input type = "text" name = "paymentId" maxlength="5" size="5"/></td>
		</tr>
		<tr>
			<td>deliveryAddress</td>
			<td><input type="text" name="deliveryAddress" required /></td>
		</tr>
		
		
	</table>
	<input type="hidden" name="ordrId" value= ${ id } />
	<input type="hidden" name="custId" value=${ custID } />
	<input type="hidden" name="paymentId"value=${ paymentID } />
	<button type="submit"   class="btn btn-warning" name="update"  value="update">Update Order</button>
</form>
</div>
</body>
</html>