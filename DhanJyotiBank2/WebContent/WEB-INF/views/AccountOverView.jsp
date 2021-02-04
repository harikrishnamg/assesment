<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Over View</title>
</head>
<body>
<h3>Account Information</h3><p align="left"><a href="customerLogout">Logout</a></p>
<h4>${transferStatus}</h4>
<table border="1px" cellpadding="0" cellspacing="0">
<tr><th>Account</th><th>Account Name</th><th>Balance</th></tr>
<tr><td>${accountInfo.account}</td><td>${customer.firstName}</td><td>${accountInfo.balance}</td></tr>
</table>
<h3>Account Statement</h3>
<table border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>Account</th>
				<th>Credit</th>
				<th>Debit</th>
				<th>Date</th>
				
			</tr>
		</thead>

		<tbody>
			<c:forEach var="logData" items="${logList}">
				<tr>
					
					<td>${logData.account}</td>
					<td>${logData.creditAmount}</td>
					<td>${logData.debitAmount}</td>
					<td>${logData.logDate}</td>
					
					<%-- <td><a
						href="${pageContext.request.contextPath}/editUser/${user.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteUser/${user.id}">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</tbody>


	</table>
	
	<table><caption>FundTransfer</caption>
	<tr><td><a href="fundTransferAction">Fund Transer</a></td></tr>
	<tr><td></td></tr>
	<tr><td><a href="addBenificiery">AddBinificiery</a></td></tr>
	</table>
</body>
</html>