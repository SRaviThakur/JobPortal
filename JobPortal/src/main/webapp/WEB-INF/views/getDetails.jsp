<%@page import="com.galaxe.rst.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table {
	border: 1px;
	background-color: lightblue;
	padding: 15px;
}
</style>
</head>
<%-- <%HttpSession session1=request.getSession(false);
Employee emp=(Employee)session1.getAttribute("emp");
if(session1==null)
{
	request.getRequestDispatcher("login").forward(request, response);
}
%> --%>
<body style="background-color: lightblue;">
<h3>${msga}</h3>
	<h2>Details</h2>

	<table cellpadding="4" border="1">
		<tr>
			<th>ID:</th>
			<td>${emp.id}</td>
		</tr>
		<tr>
			<th>First Name:</th>
			<td>${emp.firstName}</td>
		</tr>
		<tr>
			<th>Last Name:</th>
			<td>${emp.lastName}</td>
		</tr>
		<tr>
			<th>Age:</th>
			<td>${emp.age}</td>
		</tr>
		<tr>
			<th>Gender:</th>
			<td>${emp.gender}</td>
		</tr>

		<tr>
			<th>Mobile Number:</th>
			<td>${emp.mobileNumber}</td>
		</tr>
		<tr>
			<th>Email:</th>
			<td>${emp.email}</td>
		</tr>
		
		<tr>
			<td><a href="skills">Skillset</a></td>
			<td><c:forEach var="skill" items="${skill}" /> <c:out
					value="${skill}" /></td>

		</tr>
		
	</table>
	<br>
	<br>
	<br>

</body>
</html>