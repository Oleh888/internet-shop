<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <jsp:include page="../index.jsp"></jsp:include>
    <center><h1>All products in order</h1></center>
    <table class="table table-hover">
        <thead><tr>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">ID</th>
        </tr></thead>
        <tbody>
        <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><c:out value="${product.id}"/></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
