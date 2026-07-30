package dataAccessObject;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Department;
import utility.HibernateUtil;

public class DepartmentDataAccessObject {

	// 1. SAVE DEPARTMENT

	public void saveDepartment(Department department) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(department);

		transaction.commit();

		session.close();

		System.out.println("Department data saved successfully!");
	}

	// 2. FETCH DEPARTMENT WITH EMPLOYEES

	public Department getDepartmentWithEmployees(int departmentId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Department department = session.get(Department.class, departmentId);

		// Initialize Employees collection
		department.getEmployees().size();

		session.close();

		return department;
	}

	// =====================================================
	// 3. FETCH ALL DEPARTMENTS
	// =====================================================

	public void getAllDepartments() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Department> departments = session.createQuery("from Department", Department.class).list();

		for (Department department : departments) {

			System.out.println(department);

		}

		session.close();
	}

	// 4. FETCH DEPARTMENT BY ID

	public Department getDepartmentById(int departmentId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Department department = session.get(Department.class, departmentId);

		session.close();

		return department;
	}
	
	// 5. UPDATE DEPARTMENT

	public void updateDepartment(Department department) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.update(department);

		transaction.commit();

		session.close();

		System.out.println("Department data updated successfully!");
	}
	// 6. DELETE DEPARTMENT

	public void deleteDepartment(Department department) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(department);

		transaction.commit();

		session.close();

		System.out.println("Department data deleted successfully!");
	}

}