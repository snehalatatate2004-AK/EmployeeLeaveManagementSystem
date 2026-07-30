package test;

import dataAccessObject.DepartmentDataAccessObject;
import entity.Department;

public class StoreDepartment {

	public static void main(String[] args) {

		// Create Department object
		Department department = new Department();

		// Set Department details
		department.setDepartmentName("IT");

		// Create DAO object
		DepartmentDataAccessObject departmentDataAccessObject =
				new DepartmentDataAccessObject();

		// Save Department
		departmentDataAccessObject.saveDepartment(department);

	}

}