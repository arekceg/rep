<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 29.05.19
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
<table border="1">
    <tr>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Email</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.fistName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td><a href="/user/edit/${user.id}">Edit</a> </td>
            <td><a href="/user/delete/${user.id}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<a href="/user/add">ADD USER</a>
<c:import url="elements/footer.jsp"/>
</body>
</html>
