<%@ page import="java.util.List"%>
<%@ page import="entity.Leave"%>
<%@ page import="entity.Employee"%>

<%
    Employee employee =
        (Employee) session.getAttribute("loggedInEmployee");

    if (employee == null) {
        response.sendRedirect("login.html");
        return;
    }

    if (!"ADMIN".equals(employee.getRole())) {
        response.sendRedirect("employee-dashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

<title>Admin Dashboard</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dashboard.css">

</head>

<body>

	<div class="dashboard-container">

		<form action="logout" method="post">
			<button type="submit"
				style="background-color: red; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 16px; cursor: pointer;">
				Logout</button>
		</form>

		<h2>Admin Dashboard</h2>

		<h3>Pending Leave Requests</h3>

		<%
		List<Leave> pendingLeaves = (List<Leave>) request.getAttribute("pendingLeaves");
		%>

		<%
		if (pendingLeaves == null || pendingLeaves.isEmpty()) {
		%>

		<p>No pending leave requests</p>

		<%
		} else {
		%>

		<table>

			<tr>
				<th>Leave ID</th>
				<th>Employee</th>
				<th>Leave Type</th>
				<th>Start Date</th>
				<th>End Date</th>
				<th>Reason</th>
				<th>Status</th>
				<th>Action</th>
			</tr>

			<%
			for (Leave leave : pendingLeaves) {
			%>

			<tr>

				<td><%=leave.getLeaveId()%></td>

				<td><%=leave.getEmployee().getEmployeeName()%></td>

				<td><%=leave.getLeaveType()%></td>

				<td><%=leave.getStartDate()%></td>

				<td><%=leave.getEndDate()%></td>

				<td><%=leave.getReason()%></td>

				<td><%=leave.getStatus()%></td>

				<td style="white-space: nowrap;"><a
					href="approve-leave?leaveId=<%=leave.getLeaveId()%>"
					style="display: inline-block; background-color: #28a745; color: white; padding: 8px 12px; margin-right: 5px; border-radius: 5px; text-decoration: none; font-weight: bold;">
						Approve </a> <a href="reject-leave?leaveId=<%=leave.getLeaveId()%>"
					style="display: inline-block; background-color: #dc3545; color: white; padding: 8px 12px; border-radius: 5px; text-decoration: none; font-weight: bold;">
						Reject </a></td>

			</tr>

			<%
			}
			%>

		</table>

		<%
		}
		%>


		<!-- View All Leave Records -->

		<div class="view-records-container">

			<a href="all-leaves">
				<button type="button" class="view-all-btn">View All Leave
					Records</button>
			</a> <br> <br> <a href="add-employee.jsp">
				<button type="button" class="add-employee-btn">Add Employee
				</button>
			</a>

		</div>

	</div>

</body>

</html>