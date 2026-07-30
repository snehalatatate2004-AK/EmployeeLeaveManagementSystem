package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dataAccessObject.LeaveDataAccessObject;
import entity.Leave;

@WebServlet("/all-leaves")
public class AllLeavesServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        LeaveDataAccessObject leaveDataAccessObject =
                new LeaveDataAccessObject();

        List<Leave> leaves =
                leaveDataAccessObject.getAllLeaves();

        request.setAttribute(
                "leaves",
                leaves
        );

        request.getRequestDispatcher(
                "all-leaves.jsp"
        )
        .forward(
                request,
                response
        );
    }
}