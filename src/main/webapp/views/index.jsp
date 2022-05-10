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

	<form action="<%=request.getContextPath()%>/views/updateOrder.jsp" method="post">

<button type="submit"   class="btn btn-warning" name="update"  value="submit">Update Order</button>
</form>



<form action="<%=request.getContextPath()%>/views/deleteOrder.jsp" method="post">
	<input type="hidden" name="ordrId" value= ${ id } />
	<input type="hidden" name="custId" value=${ custID } />
	<input type="hidden" name="paymentId"value=${ paymentID } />
<button type="submit"   class="btn btn-warning" name="delete" value="submit">Delete Order</button>
</form>



<form action="<%=request.getContextPath()%>/placeOrderServlet" method="post">
	
<button type="submit"  class="btn btn-warning" name="order" value="submit">Make Payment</button>
</form>
</body>
</html>