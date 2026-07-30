package entity;
import java.util.Set;

import java.util.HashSet;
import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private String employeePassword;
	private String employeeDepartment;
	private String employeeDesignation;
	private double employeeSalary;
	private Department department;
	private String role;
	
	private Set<Leave> leaves = new HashSet<>();

	// Default Constructor
	public Employee() {

	}

	// Parameterized Constructor
	public Employee(int employeeId, String employeeName, String employeeEmail, String employeePassword,
			String employeeDepartment, String employeeDesignation, double employeeSalary) {

		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeePassword = employeePassword;
		this.employeeDepartment = employeeDepartment;
		this.employeeDesignation = employeeDesignation;
		this.employeeSalary = employeeSalary;
	}

	// Getters and Setters

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeDepartment() {
		return employeeDepartment;
	}

	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}

	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	public double getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Set<Leave> getLeaves() {
		return leaves;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}

	// toString()

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmail="
				+ employeeEmail + ", employeePassword=" + employeePassword + ", employeeDepartment="
				+ employeeDepartment + ", employeeDesignation=" + employeeDesignation + ", employeeSalary="
				+ employeeSalary + "]";
	}

}