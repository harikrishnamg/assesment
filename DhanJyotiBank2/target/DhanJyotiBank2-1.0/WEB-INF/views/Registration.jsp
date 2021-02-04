
    <%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<h3 align="right"><a href="homeaction">Back To Home</a></h3>

<form:form action="register" method="post" modelAttribute="userForm" enctype="multipart/form-data">
		<table>
		<tr><td>First Name</td><td>Last Name</td><td>DOB</td></tr>
		<tr><td><form:input path="firstName"/></td><td><form:input path="lastName" /><td><form:input path="dateOfBirth"/></td></tr>
		<tr><td><form:errors path="firstName" cssClass="error" /></td><td><form:errors path="lastName" cssClass="error" /></td><td><form:errors path="dateOfBirth" cssClass="error" /></td></tr>
		<tr><td>Address Line 1</td><td>Address Line 2</td><td>City</td></tr>
		<tr><td><form:input path="address1"/></td><td><form:input path="address2"/></td><td><form:input path="city"/></td></tr>
		<tr><td><form:errors path="address1" cssClass="error" /></td><td><form:errors path="address2" cssClass="error" /></td><td><form:errors path="city" cssClass="error" /></td></tr>
		<tr><td>State</td><td>PIN</td><td>Mobile Number</td></tr>
		<tr><td><form:input path="state"/></td><td><form:input path="pin"/></td><td><form:input path="mobile"/></td></tr>
		<tr><td><form:errors path="state" cssClass="error" /></td><td><form:errors path="pin" cssClass="error" /></td><td><form:errors path="mobile" cssClass="error" /></td></tr>
		<tr><td>Eamil</td><td>Aadhar</td><td>PAN</td></tr>
		<tr><td><form:input path="email"/></td><td><form:input path="aadhar"/></td><td><form:input path="pan"/></td></tr>
		<tr><td><form:errors path="email" cssClass="error" /></td><td><form:errors path="aadhar" cssClass="error" /></td><td><form:errors path="pan" cssClass="error" /></td></tr>
		<tr><td>User Name</td><td>Login Password</td><td>Confirm Password</td></tr>
		<tr><td><form:input path="userName"/></td><td><form:password path="loginPassword" /></td><td><form:password path="confirmPassword"/></td></tr>
		<tr><td><form:errors path="userName" cssClass="error" /></td><td><form:errors path="loginPassword" cssClass="error" /></td><td><form:errors path="confirmPassword" cssClass="error" /></td></tr>
		</table>
		<table>
		<tr><td>Date Of Birth</td><td><input type="file" name="dobFile"></td></tr>
		<tr><td>Address Proff</td><td><input type="file" name="addressFile"></td></tr>
		<tr><td>Aadhar</td><td><input type="file" name="aadharFile"></td></tr>
		<tr><td>PAN</td><td><input type="file" name="panFile"></td></tr>		
		</table>
		<table>
		<tr><td><input
			type="submit" value="submit"></td></tr>
		</table>
	</form:form>
</body>
</html>