<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>
    Here you can see all employees of your department
    <form action="allUsersTable" method="get">
        <input type="submit" value="AllUsers">
    </form>
    <form action="logout" method="post">
        <input type="submit" value="Logout">
    </form>
</body>
</html>