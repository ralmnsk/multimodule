<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isELIgnored="false"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>Login page:</h2>
<form:form action="auth" method="post" modelAttribute="user">
Username:
<form:input type="text"  path="name"/></br>
Password:
<form:input type="password"  path="pass"/></br>

<input type="submit" value="Submit"/>
</form:form>
</body>
</html>
