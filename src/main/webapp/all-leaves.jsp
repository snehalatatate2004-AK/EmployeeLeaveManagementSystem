<%@ page import="java.util.List"%>
<%@ page import="entity.Leave"%>

<!DOCTYPE html>
<html>

<head>

<title>All Leave Records</title>

<link rel="stylesheet" href="dashboard.css">

</head>

<body>

	<div class="dashboard-container">

		<h2>All Leave Records</h2>

		<table>

			<tr>

				<th>Leave ID</th>
				<th>Employee</th>
				<th>Leave Type</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Reason</th>
				<th>Status</th>

			</tr>

			<%
			List<Leave> leaves = (List<Leave>) request.getAttribute("leaves");

			for (Leave leave : leaves) {
			%>

			<tr>

				<td><%=leave.getLeaveId()%></td>

				<td><%=leave.getEmployee().getEmployeeName()%></td>

				<td><%=leave.getLeaveType()%></td>

				<td><%=leave.getStartDate()%></td>

				<td><%=leave.getEndDate()%></td>

				<td><%=leave.getReason()%></td>

				<td><%=leave.getStatus()%></td>

			</tr>

			<%
			}
			%>

		</table>

	</div>

</body>

</html>