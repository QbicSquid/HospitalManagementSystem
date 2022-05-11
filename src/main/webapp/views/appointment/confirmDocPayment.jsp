<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style><%@include file="/views/css/style1.css"%></style>
<style><%@include file="/views/css/table1.css"%></style>
</head>
<body>
<div class="container">

<h1 class="titletxt">Awaiting payment...</h1>
<form action="<%=request.getContextPath()%>/AppointmentPayConfirm">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<label>Select payment method:  </label>
	<select name="method" required>
    	<option value="Debit card">Debit card</option>
   		<option value="Credit card">Credit card</option>
    	<option value="Fund transfer">Fund transfer</option>
  	</select></br></br>
	<button type="submit" name="submit" class="btn">Proceed to payment</button>
</form>
</br></br>

<form action="<%=request.getContextPath()%>/CancelAppointment" method="post">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<button type="submit" name="submit" class="btn">Cancel Appointment</button>
</form>
</br></br>

<form action="<%=request.getContextPath()%>/UpdateAppointment" method="post">
	<input type="hidden" name="doctorID" value="${ schedule.doctorID }">
	<input type="hidden" name="dayOfWeek" value="${ schedule.dayOfWeek }">
	<input type="hidden" name="startTime" value="${ schedule.startTime }">
	<input type="hidden" name="endTime" value="${ schedule.endTime }">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<button type="submit" name="submit" class="btn">Update Appointment Details</button>
</form>
</div>
</body>
</html>