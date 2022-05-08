<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   	type = "text/css"
   	href = "css/showStock.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>ADD STOCK</h2>
	<form action="<%= request.getContextPath() %>/ManageStock" method = "post">
		<table class="tab1" >
			<tr>
			 <td>medicineID</td>
			 <td><input type = "text" name="medicineID" required/><td>
			 </tr>
			 <tr> 
			 <td>manuDate</td>
			 <td><input type = "date" name="manuDate" required/><td>
			 </tr>
			 <tr> 
			 <td>expDate</td>
			 <td><input type = "date" name="expDate" required/><td>
			 </tr>
			 <tr> 
			 <td>amount</td>
			 <td><input type = "text" name="amount" required/><td>
			 </tr>
	 	</table>
	 </form>
	 <br>
	 <form action="<%= request.getContextPath() %>/views/showStock.jsp" method="post">
	 	<input type= "submit" value = "Add Stock" class ="newStock" />
	 	<br><br><br><br><br>
	</form>
	
	<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post" class="search">
		Medicine Name
		<input type="text" name="medname" />
		<input type="submit" name="submit" value="submit" class= "Update-Delete">
		<br><br>
		<table>
			<tr>
				<td>Medicine ID</td>
				<td><input type="text" name="medicineID" class="txt-box"
					value="${ medicineQty.id }"/></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="medname" class="txt-box"
					value="${ medicineQty.name }"/></td>
			</tr>
			<tr>
				<td>cost</td>
				<td><input type="text" name="cost" class="txt-box"
					value="${ medicineQty.cost }"/></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" class="txt-box"
					value="${ medicineQty.description }"/></td>
			</tr>
		</table>
	</form>
</body>
</html>