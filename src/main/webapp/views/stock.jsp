<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div align = "center">
	<h1>Employee Register Form</h1>
	<form action="<%= request.getContextPath() %>/ManageStock" method = "post">
	<table style = "width: 80%">
	<tr>
	 <td>medicineID</td>
	 <td><input type = "text" name="medicineID" /><td>
	 </tr>
	 <tr> 
	 <td>manuDate</td>
	 <td><input type = "date" name="manuDate" /><td>
	 </tr>
	 <tr> 
	 <td>expDate</td>
	 <td><input type = "date" name="expDate" /><td>
	 </tr>
	 <tr> 
	 <td>amount</td>
	 <td><input type = "text" name="amount" /><td>
	 </tr>
	 </table>
	 <input type= "submit" value = "insert" />
	</form>
	</div>
</body>
</html>