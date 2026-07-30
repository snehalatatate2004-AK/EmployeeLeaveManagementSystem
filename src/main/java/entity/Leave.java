package entity;

import java.io.Serializable;

public class Leave implements Serializable {

	private static final long serialVersionUID = 1L;

	private int leaveId;

	// Employee relationship
	private Employee employee;

	private String leaveType;
	private String startDate;
	private String endDate;
	private String reason;
	private String status;


	// Default Constructor
	public Leave() {

	}


	// Parameterized Constructor
	public Leave(int leaveId, Employee employee, String leaveType,
			String startDate, String endDate, String reason, String status) {

		this.leaveId = leaveId;
		this.employee = employee;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.status = status;

	}


	// Getter and Setter for leaveId

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}


	// Getter and Setter for employee

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	// Getter and Setter for leaveType

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}


	// Getter and Setter for startDate

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	// Getter and Setter for endDate

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	// Getter and Setter for reason

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}


	// Getter and Setter for status

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {

		return "Leave [leaveId=" + leaveId
				+ ", employee=" + employee
				+ ", leaveType=" + leaveType
				+ ", startDate=" + startDate
				+ ", endDate=" + endDate
				+ ", reason=" + reason
				+ ", status=" + status + "]";

	}

}