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
<input type="hidden" name="medicineID" value=${ medicineQty.id } />

<input type="hidden" name="medicinePrice" value=${ medicineQty.totalPrice } />
<input type="hidden" name="dosage" value=${ medicineQty.description }/>

<button type="submit"   class="btn btn-warning" name="insert" value="#">Place Order</button>
</form>

<button type="submit"   class="btn btn-warning" name="delete" value="#">Delete Order</button>

<button type="submit"   class="btn btn-warning" name="update" value="#">Update Order</button>

<button type="submit"  class="btn btn-warning" name="order" value="#">Add Medicine</button>


</body>
</html>