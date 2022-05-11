<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/views/css/stockStyle.css"%></style>
<meta charset="ISO-8859-1">
<title>Insert Stock</title>
</head>
<body>
	<div class="container">
  	<h1 class="titletxt">ADD STOCK</h1>
	<form action="<%=request.getContextPath()%>/ManageStock" method="post">
		<table >
			<tr>
				<td>medicineID</td>
				<td><input type="text" name="medicineID" placeholder="Enter medicine ID" maxlength="5" minlength="5" required />
				<td>
			</tr>
			<tr>
				<td>manufacture Date</td>
				<td><input type="date" name="manuDate" id="manuDate" required />
				<td>
			</tr>
			<tr>
				<td>exp Date</td>
				<td><input type="date" name="expDate" id="expDate" required />
				<td>
			</tr>
			<tr>
				<td>amount</td>
				<td><input type="text" name="amount" placeholder="Enter amount stock" required />
				<td>
			</tr>
		</table>

		<br> <input type="submit" name="submit" value="addstock"
			class="btn" onclick="return myFunction()" /> <br>
	</form>
	</div>
	<br>
	<br>
	<br>
	<br>
	<div class="container">
	<form action="<%=request.getContextPath()%>/placeOrderServlet"
		method="post" class="search">
		Medicine Name <input type="text" name="medname" /> <input
			type="submit" name="submit" value="submit" class="Update-Delete">
		<br>
		<br>
		<table>
			<tr>
				<td>Medicine ID</td>
				<td><input type="text" name="medicineID" class="txt-box"
					value="${ medicineQty.id }" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td><input type="text" name="medname" class="txt-box"
					value="${ medicineQty.name }" /></td>
			</tr>
			<tr>
				<td>cost</td>
				<td><input type="text" name="cost" class="txt-box"
					value="${ medicineQty.cost }" /></td>
			</tr>
			<tr>
				<td>description</td>
				<td><input type="text" name="description" class="txt-box"
					value="${ medicineQty.description }" /></td>
			</tr>
		</table>
	</form>
	</div>
	<script>
		function myFunction() {
			var manuDate = document.getElementById("manuDate").value;
			var expDate = document.getElementById("expDate").value;
			var CurrentDate = new Date();
			var isValid = true;
			manuDate = new Date(manuDate);
			expDate = new Date(expDate);

			if (manuDate > CurrentDate) {
				alert('Please enter a valid Manufacture Date');
				isValid = false;
			} else if (expDate < CurrentDate) {
				alert('Please enter a valid Expiry Date');
				isValid = false;
			} else {
				isValid = true;
			}
			return isValid;
		}
	</script>

</body>
</html>