<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
table{
	border: 1px;
	background-color: lightblue;
	padding: 15px;
}
</style>
</head>
<body>
<h4>${errorMsg}</h4>
<h4>${mesg}</h4>
	<h3>Login Page</h3>
	<table cellpadding="4" border="1">
	

		<form method="post" action="loginEmployee" modelAttribute="emp">
			<tr>
				<th>ID</th>
				<td><input type="number" name="id" /></td>
				<td><errors name="id" style="color:red;" /></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" />
				<td><errors name="error" style="color:red;" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					value="Login"></td>
				<td>
			</tr>
		</form>
		</table>
</body>
</html>