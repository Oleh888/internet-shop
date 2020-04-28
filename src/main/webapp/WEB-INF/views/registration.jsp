<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
    <h1>Hello! Please provide your user details.</h1>

    <h4 style="color:red">${message}</h4>

    <form method="post" action="${pageContext.request.contextPath}/registration">
        Provide your name: <input type="text" name="name">
        Provide your login: <input type="text" name="login">
        Provide your password: <input type="password" name="pwd">
        Repeat your password: <input type="password" name="repeat-pwd">
        <button type="submit">Register</button>
    </form>
</body>
</html>
