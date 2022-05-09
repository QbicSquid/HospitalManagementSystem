<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>Doctor ID</td>
		<td>${ schedule.doctorID }</td>
	</tr>
	<tr>
		<td>Day of Week</td>
		<td>${ schedule.dayOfWeek }</td>
	</tr>
	<tr>
		<td>Doctor available from</td>
		<td>${ schedule.startTime }</td>
	</tr>
	<tr>
		<td>Doctor available until</td>
		<td>${ schedule.endTime }</td>
	</tr>
</table>
<form action="<%=request.getContextPath()%>/AppointmentPayUpdated" method="post">
	<input type="hidden" name="doctorID" value="${ schedule.doctorID }">
	<input type="hidden" name="dayOfWeek" value="${ schedule.dayOfWeek }">
	<input type="hidden" name="startTime" value="${ schedule.startTime }">
	<input type="hidden" name="endTime" value="${ schedule.endTime }">
	<input type="hidden" name="appointmentID" value="<%=request.getAttribute("appointmentID")%>"/>
	<label>Appointment Date:</label>
	<input type="date" name="date"><br/>
	<label>Remarks:</label>
	<textarea rows="4" cols="125" maxlength="500" name="remarks"></textarea><br/>
	<input type="submit" name="submit" value="submit"/>
</form>
</body>
</html>