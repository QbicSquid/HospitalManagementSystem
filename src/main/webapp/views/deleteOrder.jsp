<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action = "<%=request.getContextPath() %>/deleteOrderServlet"method ="post">
	<table>
		<tr>
			<td>OrderId</td>
			<td><input type = "text" name = "ordrId" /></td>
			
		</tr>
		<tr>
			<td>custID</td>
			<td><input type = "text" name = "custId" /></td>
		</tr>
		<tr>
			<td>paymentID</td>
			<td><input type = "text" name = "paymentId" /></td>
		</tr>
		
		
		
	</table>
	<input type="hidden" name="ordrId" value= ${ id } />
	<input type="hidden" name="custId" value=${ custID } />
	<input type="hidden" name="paymentId"value=${ paymentID } />
	<button type="submit"   class="btn btn-warning" name="update"  value="update">Delete Order</button>
</form>
</body>
</html>