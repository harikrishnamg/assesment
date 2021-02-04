<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Customers List To Activate</h1>   <p align="left"><a href="userLogout">Logout</a></p>
<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>DOB</th>
				<th>Aadhar</th>
				<th>Mobile</th>
				<th>Status</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="customer" items="${customerList}">
				<tr>
					<td><a href="getCustomerData/${customer.customerID}">${customer.firstName}</a></td>
					<td>${customer.lastName}</td>
					<td>${customer.dateOfBirth}</td>
					<td>${customer.aadhar}</td>
					<td>${customer.mobile}</td>
					<td>${customer.customerStat}</td>
					<%-- <td><a
						href="${pageContext.request.contextPath}/editUser/${user.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteUser/${user.id}">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>


	</table>
	<table>
	<tr><td><a href="depositMoneyHome">Deposit Money To Customer</a></td></tr>
	
	<tr><td></td></tr>
	<tr><td>${depositStatus}</td></tr>
	</table>
</body>
</html>