<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>Hello world!</h1>
        <table border="2">
            <td><a href="${pageContext.request.contextPath}/injectData">Go to the main page</a></td>

            <td><a href="${pageContext.request.contextPath}/products/add">Add some products to the shop</a></td>

            <td><a href="${pageContext.request.contextPath}/registration">Add new user</a></td>

            <td><a href="${pageContext.request.contextPath}/products/all">Show all products</a></td>

            <td><a href="${pageContext.request.contextPath}/users/all">Show all users</a></td>

            <td><a href="${pageContext.request.contextPath}/shoppingCart">Show the shopping cart</a></td>
        </table>
    </body>
</html>
