<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 29.05.19
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HOME</title>
</head>
<body>
<a href="/user/1/tweets/">User 1 Tweets</a>
<br><br>
<a href="/user/search-tweets/program">Find tweets beggining with "program"</a>
<br><br>
<a href="/user/add">Add user</a>
<br><br>
<a href="/tweet/add">Add tweet</a>

<c:import url="elements/footer.jsp"/>
</body>
</html>
