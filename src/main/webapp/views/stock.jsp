<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/showStock.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h2>ADD STOCK</h2>
	<form action="<%=request.getContextPath()%>/ManageStock"
		method="post">
		<table class="tab1">
			<tr>
				<td>medicineID</td>
				<td><input type="text" name="medicineID" required />
				<td>
			</tr>
			<tr>
				<td>manuDate</td>
				<td><input type="date" name="manuDate" id="manuDate" required />
				<td>
			</tr>
			<tr>
				<td>expDate</td>
				<td><input type="date" name="expDate" id="expDate" required />
				<td>
			</tr>
			<tr>
				<td>amount</td>
				<td><input type="text" name="amount" required />
				<td>
			</tr>
		</table>

		<br> <input type="submit" name="submit" value="addstock"
			class="Update-Delete" onclick="return myFunction()" /> <br>
		<br>
		<br>
		<br>
		<br>
	</form>

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