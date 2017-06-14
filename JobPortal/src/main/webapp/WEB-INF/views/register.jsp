<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<style>
table{
	background-color: lightblue;

	cellspacing: 2px;
}
</style>
</head>
<body>
<body>
	<h3>Registration Page</h3>
	<table cellpadding="4" border="1">

		<form:form method="post" action="registered" modelAttribute="emp">
		<tr hidden="true">
				<th >ID</th>
				<td><form:input type="number" path="id" /></td>
				<td><form:errors path="id" style="color:red;" /></td>
			</tr>
			<tr>
				<th>First Name</th>
				<td><form:input type="text" path="firstName" /></td>
				<td><form:errors path="firstName" style="color:red;" /></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><form:input type="text" path="lastName" /></td>
				<td><form:errors path="lastName" style="color:red;" /></td>
			</tr>
			<tr>
				<th>Gender</th>
				<td><form:select path="gender">
						<form:option value="Select" label="Select" />
						<form:option value="Male" label="Male" />
						<form:option value="Female" label="Female" />
					</form:select></td>
					<td></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><form:input type="text" path="age" /></td>
				<td><form:errors path="age" style="color:red;" /></td>
			</tr>

			<tr>
				<th>Email</th>
				<td><form:input type="text" path="email" /></td>
				<td><form:errors path="email" style="color:red;" /></td>
			</tr>

			<tr>
				<th>Mobile Number</th>
				<td><form:input type="text" path="mobileNumber" /></td>
				<td><form:errors path="mobileNumber" style="color:red;" /></td>
			</tr>
			<tr>
			
			<tr>
				<th>Password</th>
				<td><form:input type="password" path="password" />
				<td><form:errors path="password" style="color:red;" /></td>
			</tr>
			<tr>
				<th>Skill </th>
				<td><form:input type="textarea" path="skill" />
				<td><form:errors path="skill" style="color:red;" /></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Register"></td>
				<td>
			</tr>


		</form:form>
	</table>

</body>

</body>
</html>