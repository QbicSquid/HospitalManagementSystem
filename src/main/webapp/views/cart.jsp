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

<%String id = session.getAttribute("id").toString(); %>
Hello<%=id%>

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
	<tr>
		<td>dosage</td>
		
		<td><%= request.getParameter("dosage")%></td>
		
	</tr>
	
	
</table>

<form action="<%=request.getContextPath()%>/insertMedicineServlet" method="post">

<input type="hidden" name="medicineID" value=${ medicineQty.id } /> //insert medicine servlet ekata me data pass wennone string widiytaa
<input type="hidden" name="medicineName" value=${ medicineQty.name } />
<input type="hidden" name="medicinePrice" value=${ medicineQty.totalPrice } />
<input type="hidden" name="medicineDes" value=${ medicineQty.description }/>

<button type="submit"   class="btn btn-warning" name="insert" value="submit">Place Order</button>
</form>

<form action="<%=request.getContextPath()%>/deleteOrderServlet" method="post">
<button type="submit"   class="btn btn-warning" name="delete" value="submit">Delete Order</button>
</form>

<form action="<%=request.getContextPath()%>/updateOrderServlet" method="post">
<button type="submit"   class="btn btn-warning" name="update" value="submit">Update Order</button>
</form>

<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post">
<button type="submit"  class="btn btn-warning" name="order" value="submit">Add Medicine</button>
</form>

</body>
</html>