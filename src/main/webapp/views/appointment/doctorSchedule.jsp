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
<h1 class="titletxt">Available Schedules for the Doctor</h1>
<div class="container">
	<table class="mtable">
		<tr>
			<th>Select</th>
			<th>Day Of Week</th>
			<th>Start Time</th>
			<th>End Time</th>
		</tr>
<%@ page import="com.hosp.model.DoctorSchedule" %>
<%! DoctorSchedule[] schedule; %>
<%
schedule = (DoctorSchedule[])request.getAttribute("schedule");
for (DoctorSchedule d: schedule) {
%>
		<tr>
			<td>
				<form action="<%=request.getContextPath()%>/DocAppointmentConfirm" method="post">
				<button class="btn"
					type="submit"
					name="schedule"
					value="<%=d.getDoctorID()%> <%=d.getDayOfWeek()%> <%=d.getStartTime()%> <%=d.getEndTime()%>"
				>Select Time Slot</button>
				</form>
			</td>
			<td><%=d.getDayOfWeek()%></td>
			<td><%=d.getStartTime()%></td>
			<td><%=d.getEndTime()%></td>
		</tr>
<%
}
%>
	</table>
</div>
</body>
</html>