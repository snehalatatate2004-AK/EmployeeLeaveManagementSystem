package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dataAccessObject.LeaveDataAccessObject;
import entity.Employee;
import entity.Leave;

@WebServlet("/apply-leave")
public class LeaveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        // Get logged-in employee from session
        HttpSession session =
                request.getSession();

        Employee employee =
                (Employee) session.getAttribute(
                        "loggedInEmployee"
                );


        // If employee is not logged in
        if (employee == null) {

            response.sendRedirect(
                    "login.html"
            );

            return;
        }


        // Get form data
        String leaveType =
                request.getParameter("leaveType");

        String startDate =
                request.getParameter("startDate");

        String endDate =
                request.getParameter("endDate");

        String reason =
                request.getParameter("reason");


        // Create Leave object
        Leave leave =
                new Leave();


        // Set leave data
        leave.setEmployee(employee);

        leave.setLeaveType(leaveType);

        leave.setStartDate(startDate);

        leave.setEndDate(endDate);

        leave.setReason(reason);

        leave.setStatus("Pending");


        // Create DAO
        LeaveDataAccessObject leaveDataAccessObject =
                new LeaveDataAccessObject();


        // Save leave
        leaveDataAccessObject.applyLeave(
                leave
        );


        // Success message
        response.setContentType(
                "text/html"
        );

        response.getWriter().println(
                "<h1>Leave Applied Successfully!</h1>"
        );

        response.getWriter().println(
                "<p>Your leave is currently Pending.</p>"
        );

        response.getWriter().println(
                "<a href='employee-dashboard.jsp'>"
                + "Back to Dashboard"
                + "</a>"
        );
    }
}