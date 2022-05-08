<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "css/showStock.css" />
<meta charset="ISO-8859-1">
<title>Update Stock</title>
</head>
<h2>Stock Update Form</h2>
<body>
	<form action="<%= request.getContextPath() %>/Update" method = "post">
		<table class="update">
			<tr>
				<td>medicineID</td>
	 			<td><input type = "text" name="medicineID" value="<%= request.getParameter("medicineIDs")%>"/></td>
	 		</tr>
	 		<tr>
	 			<td>stockpileID</td>
	 			<td><input type = "text" name="stockpileID" value="<%= request.getParameter("stockpileIDs")%>"/></td>
	 		</tr>
	 		<tr>
				<td>amount</td>
				<td><input type="text" name="amount" class="textBox"/></td>
			</tr>
			<tr>
				<td colspan="4">
				<input type="hidden" name="stockpileID"/> 
				<input type="submit"value="Update" class="Update-Delete"/></td>
			</tr>
		</table>
	</form>
</body>
</html>