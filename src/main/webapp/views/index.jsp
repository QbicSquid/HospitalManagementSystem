<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h1>Order success</h1>
<form action="<%=request.getContextPath()%>/deleteOrderServlet" method="post">
<button type="submit"   class="btn btn-warning" name="delete" value="submit">Delete Order</button>
</form>

<form action="<%=request.getContextPath()%>/updateMedicineServlet" method="post">
<button type="submit"   class="btn btn-warning" name="update" onclick="alert('Update success!')" value="submit">Update Order</button>
</form>
	
</body>
</html>