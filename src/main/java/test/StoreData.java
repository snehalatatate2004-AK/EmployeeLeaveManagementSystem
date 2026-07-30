package test;

import entity.Leave;
import dataAccessObject.LeaveDataAccessObject;

import dataAccessObject.EmployeeDataAccessObject;
import dataAccessObject.DepartmentDataAccessObject;

import entity.Department;
import entity.Employee;

public class StoreData {

	public static void main(String[] args) {

		// Create Employee object
		Employee employee = new Employee();

		employee.setEmployeeName("Snehalata");
		employee.setEmployeeEmail("snehalata@gmail.com");
		employee.setEmployeePassword("root123");
		employee.setEmployeeDepartment("IT");
		employee.setEmployeeDesignation("Java Developer");
		employee.setEmployeeSalary(50000);

		// Create EmployeeDataAccessObject object
		EmployeeDataAccessObject employeeDataAccessObject = new EmployeeDataAccessObject();
		
		LeaveDataAccessObject leaveDataAccessObject =
				new LeaveDataAccessObject();

		// 1. SAVE EMPLOYEE

		// employeeDataAccessObject.saveEmployee(employee);

		// 2. FETCH ALL EMPLOYEES

		// employeeDataAccessObject.getAllEmployees();

		// 3. FETCH EMPLOYEE BY ID
		/*
		 * Employee employeeById = employeeDataAccessObject.getEmployeeById(1);
		 * 
		 * System.out.println(employeeById);
		 */

		// 4. UPDATE EMPLOYEE

		/*
		 * Employee employeeById = employeeDataAccessObject.getEmployeeById(1);
		 * 
		 * System.out.println("Before Update:"); System.out.println(employeeById);
		 * 
		 * // Update salary employeeById.setEmployeeSalary(60000);
		 * 
		 * // Update employee in database
		 * employeeDataAccessObject.updateEmployee(employeeById);
		 * 
		 * System.out.println("After Update:"); System.out.println(employeeById);
		 */

		// 5. DELETE EMPLOYEE

		/*
		 * Employee employeeById = employeeDataAccessObject.getEmployeeById(1);
		 * 
		 * System.out.println("Employee to be deleted:");
		 * System.out.println(employeeById);
		 * 
		 * // Delete employee employeeDataAccessObject.deleteEmployee(employeeById);
		 */

		/*
		 * Employee employeeWithLeaves =
		 * employeeDataAccessObject.getEmployeeWithLeaves(4);
		 * 
		 * System.out.println(employeeWithLeaves);
		 * 
		 * System.out.println("Employee Leaves:");
		 * 
		 * for (Leave leave : employeeWithLeaves.getLeaves()) {
		 * 
		 * System.out.println(leave);
		 * 
		 * }
		 */

		//EmployeeDataAccessObject employeeDataAccessObject = new EmployeeDataAccessObject();

		//employeeDataAccessObject.assignDepartment(4, 1);
		
		

		/*DepartmentDataAccessObject departmentDataAccessObject =
				new DepartmentDataAccessObject();

		Department department =
				departmentDataAccessObject.getDepartmentWithEmployees(2);

		System.out.println(department);

		System.out.println("Department Employees:");

		for (Employee emp : department.getEmployees()) {

			System.out.println(emp);

		}*/
	
		//departmentDataAccessObject.getAllDepartments();
		
		/*Department departmentById =
				departmentDataAccessObject.getDepartmentById(1);

		System.out.println("Before Update:");
		System.out.println(departmentById);

		// Update Department Name
		departmentById.setDepartmentName("Information Technology");

		// Update Department
		departmentDataAccessObject.updateDepartment(departmentById);

		System.out.println("After Update:");
		System.out.println(departmentById);*/
		
		/*Department departmentToDelete =
				departmentDataAccessObject.getDepartmentById(1);

		System.out.println("Department to be deleted:");
		System.out.println(departmentToDelete);

		departmentDataAccessObject.deleteDepartment(departmentToDelete);*/
		

		Employee loggedInEmployee =
				employeeDataAccessObject.loginEmployee(
						"snehalata@gmail.com",
						"root123"
				);

		if (loggedInEmployee != null) {

			System.out.println("Login successful!");

			
				if (loggedInEmployee.getRole().equals("ADMIN")) {

					System.out.println("Welcome Admin!");

					// Fetch all pending leaves
					leaveDataAccessObject.getPendingLeaves();


					// Approve Leave ID 4
					leaveDataAccessObject.approveLeave(4);

					//leaveDataAccessObject.rejectLeave(5);
				

			} else {

				System.out.println("Welcome Employee!");

				leaveDataAccessObject.getLeavesByEmployeeId(
						loggedInEmployee.getEmployeeId()
				);
			}

		} else {

			System.out.println("Invalid email or password!");
		}
	}
	
}
