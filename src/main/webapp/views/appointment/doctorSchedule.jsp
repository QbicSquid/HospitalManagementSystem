<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.hosp.model.DoctorSchedule" %>
<%! DoctorSchedule[] schedule; %>
<%
schedule = (DoctorSchedule[])request.getAttribute("schedule");
for (DoctorSchedule d: schedule) {
%>
<form action="<%=request.getContextPath()%>/DocAppointmentConfirm" method="post">
	<table>
		<tr>
			<td>
				<button
					type="submit"
					name="schedule"
					value="<%=d.getDoctorID()%> <%=d.getDayOfWeek()%> <%=d.getStartTime()%> <%=d.getEndTime()%>"
				><%=d.getDayOfWeek()%> <%=d.getStartTime()%> <%=d.getEndTime()%></button>
			</td>
		</tr>
	</table>
</form>
<%
}
%>
</body>
</html>