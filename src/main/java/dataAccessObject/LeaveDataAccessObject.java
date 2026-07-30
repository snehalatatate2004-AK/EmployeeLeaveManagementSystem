package dataAccessObject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Leave;
import utility.HibernateUtil;

public class LeaveDataAccessObject {

	// 1. SAVE LEAVE - INSERT

	public void saveLeave(Leave leave) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.save(leave);

		transaction.commit();

		session.close();

		System.out.println("Leave data saved successfully!");
	}

	// 2. GET ALL LEAVES - SELECT ALL

	public List<Leave> getAllLeaves() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Leave> leaves = session.createQuery("select l from Leave l " + "join fetch l.employee", Leave.class)
				.getResultList();

		session.close();

		return leaves;
	}

	// 3. GET LEAVE BY ID - SELECT BY ID

	public Leave getLeaveById(int leaveId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Leave leave = session.get(Leave.class, leaveId);

		session.close();

		return leave;
	}

	// 4. UPDATE LEAVE - UPDATE

	public void updateLeave(Leave leave) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.update(leave);

		transaction.commit();

		session.close();

		System.out.println("Leave data updated successfully!");
	}

	// 5. DELETE LEAVE - DELETE

	public void deleteLeave(Leave leave) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(leave);

		transaction.commit();

		session.close();

		System.out.println("Leave data deleted successfully!");
	}

	// 6. FETCH PENDING LEAVES

	public void getPendingLeaves() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Leave> leaves = session.createQuery("from Leave where status = 'Pending'", Leave.class).list();

		for (Leave leave : leaves) {

			System.out.println(leave);
		}

		session.close();
	}

	public List<Leave> getPendingLeavesList() {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Leave> leaves = session
				.createQuery("select l " + "from Leave l " + "join fetch l.employee " + "where l.status = 'Pending'",
						Leave.class)
				.list();

		session.close();

		return leaves;
	}

	// 7. APPROVE LEAVE

	public void approveLeave(int leaveId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Leave leave = session.get(Leave.class, leaveId);

		if (leave != null && leave.getStatus().equals("Pending")) {

			leave.setStatus("Approved");

			session.update(leave);

			System.out.println("Leave approved successfully!");

		} else {

			System.out.println("Leave not found or already processed!");
		}

		transaction.commit();

		session.close();
	}

	// 8. REJECT LEAVE

	public void rejectLeave(int leaveId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		Leave leave = session.get(Leave.class, leaveId);

		if (leave != null && leave.getStatus().equals("Pending")) {

			leave.setStatus("Rejected");

			session.update(leave);

			System.out.println("Leave rejected successfully!");

		} else {

			System.out.println("Leave not found or already processed!");
		}

		transaction.commit();

		session.close();
	}

	// 9. FETCH ALL LEAVES OF AN EMPLOYEE

	public List<Leave> getLeavesByEmployeeId(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Leave> leaves = session.createQuery("from Leave " + "where employee.employeeId = :employeeId", Leave.class)
				.setParameter("employeeId", employeeId).list();

		session.close();

		return leaves;
	}

	// 10. LEAVE SUMMARY OF EMPLOYEE

	public void getLeaveSummary(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Long totalLeaves = session
				.createQuery("select count(l) " + "from Leave l " + "where l.employee.employeeId = :employeeId",
						Long.class)
				.setParameter("employeeId", employeeId).uniqueResult();

		Long approvedLeaves = session
				.createQuery("select count(l) " + "from Leave l " + "where l.employee.employeeId = :employeeId "
						+ "and l.status = 'Approved'", Long.class)
				.setParameter("employeeId", employeeId).uniqueResult();

		Long rejectedLeaves = session
				.createQuery("select count(l) " + "from Leave l " + "where l.employee.employeeId = :employeeId "
						+ "and l.status = 'Rejected'", Long.class)
				.setParameter("employeeId", employeeId).uniqueResult();

		Long pendingLeaves = session.createQuery("select count(l) " + "from Leave l "
				+ "where l.employee.employeeId = :employeeId " + "and l.status = 'Pending'", Long.class)
				.setParameter("employeeId", employeeId).uniqueResult();

		System.out.println("Employee ID: " + employeeId);

		System.out.println("Total Leaves: " + totalLeaves);

		System.out.println("Approved Leaves: " + approvedLeaves);

		System.out.println("Rejected Leaves: " + rejectedLeaves);

		System.out.println("Pending Leaves: " + pendingLeaves);

		session.close();
	}

	// 11. CHECK LEAVE BALANCE

	public void getLeaveBalance(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Long approvedLeaves = session
				.createQuery("select count(l) " + "from Leave l " + "where l.employee.employeeId = :employeeId "
						+ "and l.status = 'Approved'", Long.class)
				.setParameter("employeeId", employeeId).uniqueResult();

		int totalAllowedLeaves = 12;

		long remainingLeaves = totalAllowedLeaves - approvedLeaves;

		System.out.println("Employee ID: " + employeeId);

		System.out.println("Total Allowed Leaves: " + totalAllowedLeaves);

		System.out.println("Approved Leaves: " + approvedLeaves);

		System.out.println("Remaining Leaves: " + remainingLeaves);

		session.close();
	}

	// 12. CALCULATE APPROVED LEAVE DAYS

	public void getUsedLeaveDays(int employeeId) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		List<Leave> leaves = session
				.createQuery("from Leave " + "where employee.employeeId = :employeeId " + "and status = 'Approved'",
						Leave.class)
				.setParameter("employeeId", employeeId).list();

		long totalUsedDays = 0;

		for (Leave leave : leaves) {

			LocalDate startDate = LocalDate.parse(leave.getStartDate());

			LocalDate endDate = LocalDate.parse(leave.getEndDate());

			long leaveDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

			totalUsedDays = totalUsedDays + leaveDays;

			System.out.println("Leave ID: " + leave.getLeaveId() + " | Days: " + leaveDays);
		}

		int totalAllowedDays = 12;

		long remainingDays = totalAllowedDays - totalUsedDays;

		System.out.println("Total Allowed Days: " + totalAllowedDays);

		System.out.println("Used Leave Days: " + totalUsedDays);

		System.out.println("Remaining Leave Days: " + remainingDays);

		session.close();
	}

	// 13. APPLY LEAVE WITH BALANCE
	// AND OVERLAP VALIDATION

	public void applyLeave(Leave leave) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// 1. CALCULATE REQUESTED LEAVE DAYS

		LocalDate startDate = LocalDate.parse(leave.getStartDate());

		LocalDate endDate = LocalDate.parse(leave.getEndDate());

		long requestedDays = ChronoUnit.DAYS.between(startDate, endDate) + 1;

		// 2. CHECK OVERLAPPING LEAVE

		List<Leave> employeeLeaves = session
				.createQuery("from Leave " + "where employee.employeeId = :employeeId " + "and status != 'Rejected'",
						Leave.class)
				.setParameter("employeeId", leave.getEmployee().getEmployeeId()).list();

		for (Leave existingLeave : employeeLeaves) {

			LocalDate existingStart = LocalDate.parse(existingLeave.getStartDate());

			LocalDate existingEnd = LocalDate.parse(existingLeave.getEndDate());

			boolean overlap = !startDate.isAfter(existingEnd) && !endDate.isBefore(existingStart);

			if (overlap) {

				System.out.println("Leave dates overlap " + "with existing leave!");

				transaction.rollback();

				session.close();

				return;
			}
		}

		// 3. FETCH APPROVED LEAVES

		List<Leave> approvedLeaves = session
				.createQuery("from Leave " + "where employee.employeeId = :employeeId " + "and status = 'Approved'",
						Leave.class)
				.setParameter("employeeId", leave.getEmployee().getEmployeeId()).list();

		long usedDays = 0;

		for (Leave approvedLeave : approvedLeaves) {

			LocalDate approvedStart = LocalDate.parse(approvedLeave.getStartDate());

			LocalDate approvedEnd = LocalDate.parse(approvedLeave.getEndDate());

			usedDays += ChronoUnit.DAYS.between(approvedStart, approvedEnd) + 1;
		}

		// 4. CHECK LEAVE BALANCE

		int totalAllowedDays = 12;

		long remainingDays = totalAllowedDays - usedDays;

		System.out.println("Requested Leave Days: " + requestedDays);

		System.out.println("Remaining Leave Days: " + remainingDays);

				// 5. SAVE LEAVE IF BALANCE IS AVAILABLE

		if (requestedDays <= remainingDays) {

			leave.setStatus("Pending");

			session.save(leave);

			transaction.commit();

			System.out.println("Leave applied successfully!");

		} else {

			transaction.rollback();

			System.out.println("Insufficient leave balance!");
		}

		session.close();
	}
}