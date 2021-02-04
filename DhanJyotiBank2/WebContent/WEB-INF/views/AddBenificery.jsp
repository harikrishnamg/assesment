
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Add Benificery </h4>
<form:form action="submitBenificiery" method="post" modelAttribute="userForm" enctype="multipart/form-data">
<table>
		<tr><td>Enter Benificiery Account NO:</td><td><td><form:input path="account"/></td></td></tr>
		<tr><td>Enter Benficiery Name:</td><td><td><form:input path="firstName"/></td></td></tr>
	
		<tr><td><input
			type="submit" value="AddBenificiery"></td></tr>
		</table>
		
</form:form>
</body>
</html>