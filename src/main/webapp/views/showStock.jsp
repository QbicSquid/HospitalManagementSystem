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
	<h2>STOCK DETAILS</h2>
	<br>
	<form action="<%= request.getContextPath() %>/addNewStock" method="post">
		<input type="submit" value="Add New Stock" class="newStock"/> 
	</form>
	<br><br>
	<%@page import="com.hosp.model.MedicineStock, com.hosp.dbutil.StockManagerDAO" %>
	<%!
	StockManagerDAO stockManagerDAO = new StockManagerDAO();
	MedicineStock[] medicineStock;
	%>

	
	<table class="tab1">
		<tr>
		    <th>Medicine ID</th>
		    <th>StockPile ID</th>
		    <th>Manufacture Date</th>
		    <th>Expiry Date</th>
		    <th>Amount</th>
		    <th>Update</th>
		    <th>Remove</th>
  		</tr>
<%
	medicineStock = stockManagerDAO.readStock();

	for(int i = 0; i < medicineStock.length; i++){
%>	
		<tr>
			<td><input type="text" name="medicineID" class="txt-box"
				 value="<%= medicineStock[i].getMedicineID() %>"/></td>
				
			<td><input type="text" name="stockpileID" class="txt-box"
				value="<%= medicineStock[i].getStockpileID() %>" /></td>
	
			<td><input type="text" name="manuDate" class="txt-box"
				value="<%= medicineStock[i].getManuDate() %>" /></td>

			<td><input type="text" name="expDate" class="txt-box"
				value="<%= medicineStock[i].getExpDate() %>" /></td>

			<td><input type="text" name="amount" class="txt-box"
				value="<%= medicineStock[i].getAmount() %>"/></td>
			<td>
			<form action="<%= request.getContextPath() %>/Edit" method="POST">
			
				<input type="submit" value="Edit" class="Update-Delete"/>
				<input type="hidden" name="medicineIDs" value="<%= medicineStock[i].getMedicineID() %>"/>
				<input type="hidden" name="stockpileIDs" value="<%= medicineStock[i].getStockpileID() %>" />
					
			</form>
			</td>
			<td>
			<form action="<%= request.getContextPath() %>/delete" method="POST">
			
				<input type="submit" value="Delete" class="Update-Delete"/>
				<input type="hidden" name="medicineIDs" value="<%= medicineStock[i].getMedicineID() %>"/>
				<input type="hidden" name="stockpileIDs" value="<%= medicineStock[i].getStockpileID() %>"/>
			
			</form>
			</td>
		</tr>
<% 
	}
	
%>
	</table>

</body>
</html>