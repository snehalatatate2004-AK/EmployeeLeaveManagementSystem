<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Leave Summary</title>

    <link rel="stylesheet"
          href="dashboard.css">

</head>

<body>

    <div class="dashboard-container">

        <h2>Leave Summary</h2>

        <div class="dashboard-cards">

            <div class="card">

                <h3>Total Leaves</h3>

                <p>
                    <%= request.getAttribute(
                            "totalLeaves"
                       )
                    %>
                </p>

            </div>


            <div class="card">

                <h3>Approved Leaves</h3>

                <p>
                    <%= request.getAttribute(
                            "approvedLeaves"
                       )
                    %>
                </p>

            </div>


            <div class="card">

                <h3>Rejected Leaves</h3>

                <p>
                    <%= request.getAttribute(
                            "rejectedLeaves"
                       )
                    %>
                </p>

            </div>


            <div class="card">

                <h3>Pending Leaves</h3>

                <p>
                    <%= request.getAttribute(
                            "pendingLeaves"
                       )
                    %>
                </p>

            </div>

        </div>


        <br>

        <a href="employee-dashboard.jsp">
            Back to Dashboard
        </a>

    </div>

</body>

</html>