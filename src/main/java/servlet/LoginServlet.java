package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dataAccessObject.EmployeeDataAccessObject;
import entity.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        // Get email and password from login form
        String email =
                request.getParameter("email");

        String password =
                request.getParameter("password");


        // Create Employee DAO object
        EmployeeDataAccessObject employeeDataAccessObject =
                new EmployeeDataAccessObject();


        // Login using Hibernate
        Employee employee =
                employeeDataAccessObject.loginEmployee(
                        email,
                        password
                );


        // Check login result
        if (employee != null) {


            // Create session
            HttpSession session =
                    request.getSession();


            // Store logged-in employee in session
            session.setAttribute(
                    "loggedInEmployee",
                    employee
            );


            // Check employee role
            if ("ADMIN".equals(employee.getRole())) {


                // Admin to Admin Dashboard
                response.sendRedirect(
                        "admin-dashboard"
                );


            } else {


                // Employee to Employee Dashboard
                response.sendRedirect(
                        "employee-dashboard.jsp"
                );
            }


        } else {

            response.sendRedirect(
                    "login.html?error=Invalid%20email%20or%20password"
            );
        }
    }
}