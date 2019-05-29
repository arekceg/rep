<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 29.05.19
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
</head>
<body>
<form:form method="POST" modelAttribute="user">
    First name: <form:input path="fistName" type="text"/>
    <br> <form:errors path="fistName"/>
    <br><br>
    Last name: <form:input path="lastName" type="text"/>
    <br> <form:errors path="lastName"/>
    <br><br>
    Email: <form:input path="email" type="email"/>
    <br> <form:errors path="email"/>
    <br><br>
    <input type="submit" value="submit"/>
</form:form>
<c:import url="elements/footer.jsp"/>
</body>
</html>
