<%@ page import="entity.Employee"%>

<%
    Employee employee =
        (Employee) session.getAttribute("loggedInEmployee");
केलेला नसेल
    if (employee == null) {
        response.sendRedirect("login.html");
        return;
    }

    // Admin tried to open Employee Dashboard 
    if ("ADMIN".equals(employee.getRole())) {
        response.sendRedirect("admin-dashboard");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Employee Dashboard</title>

<link rel="stylesheet" href="dashboard.css">

</head>

<body>

    <!-- Header -->
    <header class="header">

        <h1>Employee Leave Management System</h1>

        <form action="logout" method="post">
            <button type="submit">Logout</button>
        </form>

    </header>


    <!-- Dashboard Container -->
    <div class="dashboard-container">

        <h2>
            Welcome,
            <%= employee.getEmployeeName() %>
        </h2>

        <p class="subtitle">Manage your leaves easily</p>


        <!-- Dashboard Cards -->
        <div class="dashboard-cards">


            <!-- Apply Leave -->
            <div class="card">

                <h3>Apply Leave</h3>

                <p>Apply for a new leave.</p>

                <a href="apply-leave.jsp">

                    <button type="button">Apply Leave</button>

                </a>

            </div>


            <!-- My Leaves -->
            <div class="card">

                <h3>My Leaves</h3>

                <p>View all your leave records.</p>

                <a href="my-leaves">

                    <button type="button">View Leaves</button>

                </a>

            </div>


            <!-- Leave Summary -->
            <div class="card">

                <h3>Leave Summary</h3>

                <p>View approved, rejected and pending leaves.</p>

                <a href="leave-summary">

                    <button type="button">View Summary</button>

                </a>

            </div>


            <!-- Leave Balance -->
            <div class="card">

                <h3>Leave Balance</h3>

                <p>Check your remaining leave balance.</p>

                <a href="leave-balance">

                    <button type="button">Check Balance</button>

                </a>

            </div>


        </div>

    </div>

</body>

</html>