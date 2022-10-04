<%--
  Created by IntelliJ IDEA.
  User: mehul
  Date: 04-10-2022
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Success </title>
</head>
<body>
  <h2 style="color: green"> <%= request.getAttribute("username") %> Login success!!! </h2>
    <a href="login.html"> Login page</a>
</body>
</html>
