    <%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <style>
    .error
    {
        color: #ff0000;
        font-weight: bold;
    }
    </style>
</head>
<body>

<form:form action="login" method="get" modelAttribute="userForm">
<h4>${errorMsg}</h4>
<table>
<tr><td>UserName</td><td><form:input path="userName" maxlength="20"/></td><td><form:errors path="userName" cssClass="error"/></td></tr>

<tr><td>Password</td><td><form:password path="loginPassword" maxlength="20"/></td><td><form:errors path="loginPassword" cssClass="error"/></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>
</table>
</form:form>
<h3 align="right"><a href="homeaction">Back To Home</a></h3>
</body>
</html>