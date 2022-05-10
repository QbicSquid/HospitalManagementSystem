<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style><%@include file="/views/css/style1.css"%></style>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<h4>Order success</h4>
<div class ="container">
<form action="<%=request.getContextPath()%>/views/updateOrder.jsp" method="post">

	<button type="submit"   class="btn btn-warning" name="update"  value="submit">Update Order</button><br><br>

</form>



<form action="<%=request.getContextPath()%>/views/deleteOrder.jsp" method="post">
	<input type="hidden" name="ordrId" value= ${ id } />
	<input type="hidden" name="custId" value=${ custID } />
	<input type="hidden" name="paymentId"value=${ paymentID } />
	<button type="submit"   class="btn btn-warning" name="delete" value="submit">Delete Order</button><br><br>
</form>



<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post">
	
	<button type="submit"  class="btn btn-warning" name="order" value="submit">Make Payment</button><br><br>

</form>
</div>
</body>
</html>