<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="css/stock.css"%></style>
<title>showStock</title>
</head>
<body>
<form action="<%= request.getContextPath()%>/stockList" method = "post">
<table style = "border : 1px solid">
  <tr>
    <th>medicineID</th>
    <th>stockpileID</th>
    <th>manuDate</th>
    <th>expDate</th>
    <th>amount</th>
  </tr>
  <tr>
    <td>${stockpile.medicineID.get }</td>
    <td>${stockpile.stockpileID }</td>
    <td>${stockpile.manuDate }</td>
    <td>${stockpile.expDate }</td>
    <td>${stockpile.amount}</td>
  </tr>
</table>
</form>
</body>
</html>