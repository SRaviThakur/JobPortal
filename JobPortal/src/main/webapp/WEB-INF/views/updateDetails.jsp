<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Page</title>
<style>
table {
	border: 1px;
	background-color: lightblue;
	padding: 15px;
}
</style>
</head>
<body style="background-color:lightblue;">

<
<h1>Edit Profile</h1>
<form:form method="post" action="updateData" modelAttribute="emp">
	<table cellpadding="4" border="1" background-color="lightgreen">
	<tr>
			<td> ID:</td>
			<td><form:input path="id" readonly="true"/></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td><form:input path="firstName" /></td>
			<td><form:errors path="firstName" style="color:red;"/></td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td><form:input path="lastName" /></td>
			<td><form:errors path="lastName" style="color:red;"/></td>
		</tr>
		
		<tr>
			<td>Password:</td>
			<td><form:input path="password" /></td>
			<td><form:errors path="password" style="color:red;"/></td>
		</tr>
		
		<tr>
			<td>Student Mobile Number:</td>
			<td><form:input path="mobileNumber" /></td>
			<td><form:errors path="mobileNumber" style="color:red;"/></td>
		<tr>    
		<tr>
			<td>Student Email:</td>
			<td><form:input path="email" /></td>
			<td><form:errors path="email" style="color:red;"/></td>
		<tr> 
		<tr>
			<td>Age:</td>
			<td><form:input path="age" /></td>
			<td><form:errors path="age" style="color:red;"/></td>
		</tr>
		<tr>
			<td>Gender:</td>
			<td><form:input path="gender" readonly="true"/></td>
		</tr>   
		<tr>
				<td> Add Skills </td>
				<td><form:input type="textarea" path="skill" />
				<td><form:errors path="skill" style="color:red;" /></td>
			</tr>
		
          <td> </td>    
          <td><input type="submit" value="edit and save" /></td>    
         </tr>    
	</table>
	
</form:form>
</body>
</html>