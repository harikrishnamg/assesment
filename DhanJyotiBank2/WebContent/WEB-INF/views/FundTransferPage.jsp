
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
<form:form action="transfer" method="post" modelAttribute="userForm" enctype="multipart/form-data">
<table>
		<%-- <tr><td>Enter Account NO:</td><td><td><form:input path="account"/></td></td></tr> --%>
	<tr><td>Enter Account NO:</td><td>	<form:select path="account">
                      <form:option value="" label="..select Account.." />
                      <form:options items="${benList}" />
                       </form:select></td></tr>
		<tr><td>Enter Amount</td><td><form:input path="balance"/></td></td></tr>
		<tr><td><input
			type="submit" value="Transfer"></td></tr>
		</table>
		
</form:form>
</body>
</html>