package dataAccessObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Department;
import entity.Employee;
import utility.HibernateUtil;

public class EmployeeDataAccessObject {

	public void saveEmployee(Employee employee) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(employee);

		transaction.commit();

		session.close();

		System.out.println("Employee data saved successfully!");

	}

	public void getAllEmployees() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();

		for (Employee employee : employees) {

			System.out.println(employee);

		}

		session.close();

	}

	public Employee getEmployeeById(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Employee employee = session.get(Employee.class, employeeId);

		session.close();

		return employee;

	}

	public void updateEmployee(Employee employee) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.update(employee);

		transaction.commit();

		session.close();

		System.out.println("Employee data updated successfully!");

	}

	public void deleteEmployee(Employee employee) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(employee);

		transaction.commit();

		session.close();

		System.out.println("Employee data deleted successfully!");

	}

	public Employee getEmployeeWithLeaves(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Employee employee = session.get(Employee.class, employeeId);

		// Initialize leaves collection
		
		employee.getLeaves().size();

		session.close();

		return employee;
	}

	public void assignDepartment(int employeeId, int departmentId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, employeeId);

		Department department = session.get(Department.class, departmentId);

		employee.setDepartment(department);

		session.update(employee);

		transaction.commit();

		session.close();

		System.out.println("Department assigned to employee successfully!");
	}

	public Department getDepartmentWithEmployees(int departmentId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Department department = session.get(Department.class, departmentId);

		// Employees collection initialize 
		
		department.getEmployees().size();

		session.close();

		return department;
	}

	public Department getDepartmentById(int departmentId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Department department = session.get(Department.class, departmentId);

		session.close();

		return department;
	}
	// Emp login

	public Employee loginEmployee(String email, String password) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Employee employee = session
				.createQuery("from Employee " + "where employeeEmail = :email " + "and employeePassword = :password",
						Employee.class)
				.setParameter("email", email).setParameter("password", password).uniqueResult();

		session.close();

		return employee;
	}
}