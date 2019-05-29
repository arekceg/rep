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
    <title>Tweet Form</title>
</head>
<body>
<form:form method="POST" modelAttribute="tweet">
    Title: <form:input path="title" type="text"/>
    <br> <form:errors path="title"/>
    <br><br>
    Tweet: <form:textarea rows="10" cols="10" path="tweetText"/>
    <br> <form:errors path="tweetText"/>
    <br><br>
    User: <form:select path="user.id" items="${users}" itemLabel="fullName" itemValue="id"/>
<%--    <br> <form:errors path="user"/>--%>
    <br><br>
    <input type="submit" value="submit"/>
</form:form>
<c:import url="elements/footer.jsp"/>
</body>
</html>
