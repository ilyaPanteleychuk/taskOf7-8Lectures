<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UsersTable</title>
</head>
<body>
    <c:forEach var="user" items="${allUsers}">
        ${user}
    </c:forEach>
</body>
</html>
