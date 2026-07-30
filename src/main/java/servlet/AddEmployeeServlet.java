package servlet;

import java.io.IOException;

import entity.Department;
import dataAccessObject.EmployeeDataAccessObject;
import entity.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-employee")
public class AddEmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {


		// Get data from form

		String employeeName =
				request.getParameter(
						"employeeName"
				);

		String employeeEmail =
				request.getParameter(
						"employeeEmail"
				);

		String employeePassword =
				request.getParameter(
						"employeePassword"
				);

		int departmentId =
				Integer.parseInt(
						request.getParameter(
								"departmentId"
						)
				);

		String employeeDesignation =
				request.getParameter(
						"employeeDesignation"
				);

		double employeeSalary =
				Double.parseDouble(
						request.getParameter(
								"employeeSalary"
						)
				);

		String role =
				request.getParameter(
						"role"
				);


		// Create Employee object

		Employee employee =
				new Employee();


		employee.setEmployeeName(
				employeeName
		);

		employee.setEmployeeEmail(
				employeeEmail
		);

		employee.setEmployeePassword(
				employeePassword
		);


		employee.setEmployeeDesignation(
				employeeDesignation
		);

		employee.setEmployeeSalary(
				employeeSalary
		);

		employee.setRole(
				role
		);


		// Create DAO object

		EmployeeDataAccessObject
				employeeDataAccessObject =
				new EmployeeDataAccessObject();


		// Get Department

		Department department =
				employeeDataAccessObject
						.getDepartmentById(
								departmentId
						);


		// Set Department object

		employee.setDepartment(
				department
		);


		// Set Department Name

		employee.setEmployeeDepartment(
				department
						.getDepartmentName()
		);


		// Save Employee

		employeeDataAccessObject
				.saveEmployee(
						employee
				);


		// Redirect to Login Page

		response.sendRedirect(
				"login.html"
		);

	}

}