
    <%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reistration</title>
 <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>
<h3><a href="homeaction">Back To Home</a></h3>
<table>
		<tr><td><h2>Customer Details</h2></td></tr>
		</table>

		<table border="1">
		<tr><td>First Name</td><td>Last Name</td><td>DOB</td></tr>
		<tr><td>${customer.firstName}</td><td>${customer.lastName}</td><td>${customer.dateOfBirth}</td></tr>
		
		<tr><td>Address Line 1</td><td>Address Line 2</td><td>City</td></tr>
		<tr><td>${customer.address1}</td><td>${customer.address2}</td><td>${customer.city}</td></tr>
		
		<tr><td>State</td><td>PIN</td><td>Mobile Number</td></tr>
		<tr><td>${customer.state}</td><td>${customer.pin}</td><td>${customer.mobile}</td></tr>
		
		<tr><td>Eamil</td><td>Aadhar</td><td>PAN</td></tr>
		<tr><td>${customer.email}</td><td>${customer.aadhar}</td><td>${customer.pan}</td></tr>	

		</table>
		<table>
		<tr><td><h2>KYP Document List</h2></td></tr>
		</table>
		<table border="1">
		<c:forEach var="customerDOC" items="${customer.customerDocs}">
				<tr>
					
					<td><a href="${pageContext.request.contextPath}/getKypDocument/${customerDOC.documentID}">${customerDOC.fileName}</a></td>
					
					<%-- <td><a
						href="${pageContext.request.contextPath}/editUser/${user.id}">Edit</a></td>
					<td><a
						href="${pageContext.request.contextPath}/deleteUser/${user.id}">Delete</a></td> --%>
				</tr>
			</c:forEach>
		</table>
		<table>
		<tr><td><a href="${pageContext.request.contextPath}/customerActivation?actiontype=approve"><button >Approve</button></a></td><td><a href="${pageContext.request.contextPath}/customerActivation?actiontype=reject"><button>Reject</button></a></td></tr>
		</table>
		<%-- <form:form action="register" name="">
		<table>
		<tr><td><input type="submit" value="Approve"/></td><td><input type="submit" value="Reject"/></td></tr>
		</table>
		<input/>   
		
		</form:form> --%>
		
		
		
		
	
</body>
</html>