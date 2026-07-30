<%@ page import="entity.Employee" %>

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

    <title>Apply Leave</title>

    <link rel="stylesheet"
          href="dashboard.css">

</head>

<body>

    <div class="apply-leave-container">

        <h2>Apply for Leave</h2>

        <form action="apply-leave"
              method="post">

            <label>Leave Type</label>

            <select name="leaveType"
                    required>

                <option value="">
                    Select Leave Type
                </option>

                <option value="Sick Leave">
                    Sick Leave
                </option>

                <option value="Casual Leave">
                    Casual Leave
                </option>

                <option value="Emergency Leave">
                    Emergency Leave
                </option>

            </select>


            <br><br>


            <label>Start Date</label>

            <input type="date"
                   name="startDate"
                   required>


            <br><br>


            <label>End Date</label>

            <input type="date"
                   name="endDate"
                   required>


            <br><br>


            <label>Reason</label>

            <textarea name="reason"
                      rows="4"
                      required></textarea>


            <br><br>


            <button type="submit" class="apply-leave-btn">
                Apply Leave
            </button>

        </form>

    </div>

</body>

</html>