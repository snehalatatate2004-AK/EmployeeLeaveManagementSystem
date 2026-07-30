package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Department implements Serializable {

	private static final long serialVersionUID = 1L;

	private int departmentId;
	private String departmentName;

	private Set<Employee> employees = new HashSet<>();


	//  Constructor
	public Department() {

	}



	public Department(int departmentId, String departmentName) {

		this.departmentId = departmentId;
		this.departmentName = departmentName;

	}


	// Getters and Setters

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {

		return "Department [departmentId=" + departmentId
				+ ", departmentName=" + departmentName + "]";

	}

}