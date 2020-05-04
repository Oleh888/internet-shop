<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <jsp:include page="../index.jsp"></jsp:include>
        <center><h1>All users page</h1></center>
        <table class="table table-hover">
            <thead><tr>
                <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Login</th>
                <th>Delete user</th>
            </tr></thead>
            <tbody>
            <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.userId}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><a class="memberNameLink" href="${pageContext.request.contextPath}/users/delete?id=${user.userId}">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
