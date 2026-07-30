<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Add Employee</title>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/dashboard.css">

</head>

<body>

	<div class="apply-leave-container">

		<h2>Add New Employee</h2>

		<form action="add-employee" method="post">

			<label>Employee Name</label> <input type="text" name="employeeName"
				required> <label>Email</label> <input type="email"
				name="employeeEmail" required> <label>Password</label> <input
				type="password" name="employeePassword" required> <label>Department
				ID</label> <input type="number" name="departmentId" required> <label>Designation</label>

			<input type="text" name="employeeDesignation" required> <label>Salary</label>

			<input type="number" name="employeeSalary" required> <label>Role</label>

			<select name="role" required>

				<option value="">Select Role</option>

				<option value="EMPLOYEE">EMPLOYEE</option>

				<option value="ADMIN">ADMIN</option>

			</select> <br>


			<button type="submit" class="add-employee-btn">Add Employee

			</button>

		</form>

	</div>

</body>

</html>