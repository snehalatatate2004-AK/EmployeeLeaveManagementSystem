package servlet;

import java.io.IOException;

import dataAccessObject.LeaveDataAccessObject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reject-leave")
public class RejectLeaveServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        // Get leave ID from URL
        int leaveId =
                Integer.parseInt(
                        request.getParameter(
                                "leaveId"
                        )
                );


        // Create DAO object
        LeaveDataAccessObject leaveDataAccessObject =
                new LeaveDataAccessObject();


        // Reject leave
        leaveDataAccessObject.rejectLeave(
                leaveId
        );


        // Redirect back to Admin Dashboard
        response.sendRedirect(
                "admin-dashboard"
        );
    }
}