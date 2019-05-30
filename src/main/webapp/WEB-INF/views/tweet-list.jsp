<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 29.05.19
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweets</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Created</td>
        <td>Title</td>
        <td>Tweet</td>
        <td>User</td>
    </tr>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <td>${tweet.id}</td>
            <td>${tweet.created}</td>
            <td>${tweet.title}</td>
            <td>${tweet.tweetText}</td>
            <td>${tweet.user.fullName}</td>
        </tr>
    </c:forEach>
</table>
<c:import url="elements/footer.jsp"/>
</body>
</html>
