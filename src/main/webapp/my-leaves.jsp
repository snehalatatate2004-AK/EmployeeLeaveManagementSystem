<%@ page import="java.util.List" %>
<%@ page import="entity.Employee" %>
<%@ page import="entity.Leave" %>

<%
    Employee employee =
            (Employee) session.getAttribute("loggedInEmployee");

    if (employee == null) {
        response.sendRedirect("login.html");
        return;
    }
%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>My Leaves</title>

    <link rel="stylesheet"
          href="dashboard.css">

</head>

<body>

    <div class="dashboard-container">

        <h2>My Leave Records</h2>

        <table border="1">

            <tr>

                <th>Leave ID</th>
                <th>Leave Type</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Reason</th>
                <th>Status</th>

            </tr>


            <%
                List<Leave> leaves =
                        (List<Leave>) request
                        .getAttribute("leaves");

                for (Leave leave : leaves) {
            %>

            <tr>

                <td>
                    <%= leave.getLeaveId() %>
                </td>

                <td>
                    <%= leave.getLeaveType() %>
                </td>

                <td>
                    <%= leave.getStartDate() %>
                </td>

                <td>
                    <%= leave.getEndDate() %>
                </td>

                <td>
                    <%= leave.getReason() %>
                </td>

                <td>
                    <%= leave.getStatus() %>
                </td>

            </tr>

            <%
                }
            %>

        </table>

        <br>

        <a href="employee-dashboard.jsp">
            Back to Dashboard
        </a>

    </div>

</body>

</html>