package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dataAccessObject.LeaveDataAccessObject;
import entity.Employee;
import entity.Leave;

@WebServlet("/my-leaves")
public class MyLeavesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession();

        Employee employee =
                (Employee) session.getAttribute(
                        "loggedInEmployee"
                );

        if (employee == null) {

            response.sendRedirect(
                    "login.html"
            );

            return;
        }

        LeaveDataAccessObject leaveDataAccessObject =
                new LeaveDataAccessObject();

        List<Leave> leaves =
                leaveDataAccessObject
                .getLeavesByEmployeeId(
                        employee.getEmployeeId()
                );

        request.setAttribute(
                "leaves",
                leaves
        );

        request.getRequestDispatcher(
                "my-leaves.jsp"
        ).forward(
                request,
                response
        );
    }
}