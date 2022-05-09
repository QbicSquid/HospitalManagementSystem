<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/AppointmentPayConfirm">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<label>Select payment method</label>
	<select name="method">
    	<option value="Debit card">Debit card</option>
   		<option value="Credit card">Credit card</option>
    	<option value="Fund transfer">Fund transfer</option>
  	</select>
	<button type="submit" name="submit">Proceed to payment</button>
</form>

<form action="<%=request.getContextPath()%>/CancelAppointment" method="post">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<button type="submit" name="submit">Cancel Appointment</button>
</form>

<form action="<%=request.getContextPath()%>/UpdateAppointment" method="post">
	<input type="hidden" name="doctorID" value="${ schedule.doctorID }">
	<input type="hidden" name="dayOfWeek" value="${ schedule.dayOfWeek }">
	<input type="hidden" name="startTime" value="${ schedule.startTime }">
	<input type="hidden" name="endTime" value="${ schedule.endTime }">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<button type="submit" name="submit">Update Appointment Details</button>
</form>

</body>
</html>