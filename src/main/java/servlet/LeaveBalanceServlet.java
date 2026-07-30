package servlet;

import java.io.IOException;

import org.hibernate.Session;

import entity.Employee;
import utility.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/leave-balance")
public class LeaveBalanceServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession httpSession =
                request.getSession();

        Employee employee =
                (Employee) httpSession
                .getAttribute("loggedInEmployee");

        if (employee == null) {

            response.sendRedirect(
                    "login.html"
            );

            return;
        }

        Session session =
                HibernateUtil
                .getSessionFactory()
                .openSession();


        Long usedLeaveDays =
                session.createQuery(
                        "select coalesce(sum(" +
                        "function('datediff', " +
                        "l.endDate, l.startDate) + 1), 0) " +
                        "from Leave l " +
                        "where l.employee.employeeId = :employeeId " +
                        "and l.status = 'Approved'",
                        Long.class
                )
                .setParameter(
                        "employeeId",
                        employee.getEmployeeId()
                )
                .uniqueResult();


        session.close();


        int totalAllowedDays = 12;

        long remainingLeaveDays =
                totalAllowedDays
                - usedLeaveDays;


        request.setAttribute(
                "totalAllowedDays",
                totalAllowedDays
        );

        request.setAttribute(
                "usedLeaveDays",
                usedLeaveDays
        );

        request.setAttribute(
                "remainingLeaveDays",
                remainingLeaveDays
        );


        request.getRequestDispatcher(
                "leave-balance.jsp"
        )
        .forward(
                request,
                response
        );
    }
}