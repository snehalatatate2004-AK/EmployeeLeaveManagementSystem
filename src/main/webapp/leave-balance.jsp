<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Leave Balance</title>

    <link rel="stylesheet"
          href="dashboard.css">

</head>

<body>

    <div class="dashboard-container">

        <h2>Leave Balance</h2>

        <div class="dashboard-cards">

            <div class="card">

                <h3>Total Allowed Leave Days</h3>

                <p>
                    <%= request.getAttribute(
                            "totalAllowedDays"
                       )
                    %>
                </p>

            </div>


            <div class="card">

                <h3>Used Leave Days</h3>

                <p>
                    <%= request.getAttribute(
                            "usedLeaveDays"
                       )
                    %>
                </p>

            </div>


            <div class="card">

                <h3>Remaining Leave Days</h3>

                <p>
                    <%= request.getAttribute(
                            "remainingLeaveDays"
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