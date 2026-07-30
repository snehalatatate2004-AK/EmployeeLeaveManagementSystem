package test;

import dataAccessObject.EmployeeDataAccessObject;
import dataAccessObject.LeaveDataAccessObject;

import entity.Employee;
import entity.Leave;

public class StoreLeave {

	public static void main(String[] args) {

		// Create DAO objects
		
		EmployeeDataAccessObject employeeDataAccessObject =
				new EmployeeDataAccessObject();

		LeaveDataAccessObject leaveDataAccessObject =
				new LeaveDataAccessObject();


		// 1. EMPLOYEE LOGIN

		Employee loggedInEmployee =
				employeeDataAccessObject.loginEmployee(
						"snehalata@gmail.com",
						"root123"
				);


		if (loggedInEmployee != null) {

			System.out.println("Login successful!");

			// Create and apply leave
			Leave leave = new Leave();

			leave.setEmployee(loggedInEmployee);

			leave.setLeaveType("Sick Leave");
			leave.setStartDate("2026-08-01");
			leave.setEndDate("2026-08-03");
			leave.setReason("Health issue");

			//leaveDataAccessObject.applyLeave(leave);


			// Employee ID automatically
			int employeeId =
					loggedInEmployee.getEmployeeId();


			// Fetch own leaves
			leaveDataAccessObject.getLeavesByEmployeeId(
					employeeId
			);


			// Leave summary
			leaveDataAccessObject.getLeaveSummary(
					employeeId
			);

		} else {

			System.out.println(
					"Invalid email or password!"
			);
		}
		// =====================================================
		// OTHER OPERATIONS
		// =====================================================

		// leaveDataAccessObject.getPendingLeaves();

		// leaveDataAccessObject.approveLeave(2);

		// leaveDataAccessObject.rejectLeave(3);

		// leaveDataAccessObject.getLeavesByEmployeeId(4);

		// leaveDataAccessObject.getLeaveSummary(4);

		// leaveDataAccessObject.getLeaveBalance(4);

		// leaveDataAccessObject.getUsedLeaveDays(4);
	}
}