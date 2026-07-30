package servlet;

import java.io.IOException;

import org.hibernate.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import entity.Employee;
import utility.HibernateUtil;

@WebServlet("/leave-summary")
public class LeaveSummaryServlet extends HttpServlet {

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


        Long totalLeaves =
                session.createQuery(
                        "select count(l) " +
                        "from Leave l " +
                        "where l.employee.employeeId = :employeeId",
                        Long.class
                )
                .setParameter(
                        "employeeId",
                        employee.getEmployeeId()
                )
                .uniqueResult();


        Long approvedLeaves =
                session.createQuery(
                        "select count(l) " +
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


        Long rejectedLeaves =
                session.createQuery(
                        "select count(l) " +
                        "from Leave l " +
                        "where l.employee.employeeId = :employeeId " +
                        "and l.status = 'Rejected'",
                        Long.class
                )
                .setParameter(
                        "employeeId",
                        employee.getEmployeeId()
                )
                .uniqueResult();


        Long pendingLeaves =
                session.createQuery(
                        "select count(l) " +
                        "from Leave l " +
                        "where l.employee.employeeId = :employeeId " +
                        "and l.status = 'Pending'",
                        Long.class
                )
                .setParameter(
                        "employeeId",
                        employee.getEmployeeId()
                )
                .uniqueResult();


        session.close();


        request.setAttribute(
                "totalLeaves",
                totalLeaves
        );

        request.setAttribute(
                "approvedLeaves",
                approvedLeaves
        );

        request.setAttribute(
                "rejectedLeaves",
                rejectedLeaves
        );

        request.setAttribute(
                "pendingLeaves",
                pendingLeaves
        );


        request.getRequestDispatcher(
                "leave-summary.jsp"
        )
        .forward(
                request,
                response
        );
    }
}