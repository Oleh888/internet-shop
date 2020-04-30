<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <jsp:include page="../index.jsp"></jsp:include>

        <center><h2>All products in shop</h2></center>

        <table class="table table-hover">
            <thead><tr>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">ID</th>
                <th>Delete from shop</th>
            </tr></thead>
            <tbody>
            <c:forEach var="product" items="${products}">
            <tr>
                <td><c:out value="${product.name}"/></td>
                <td><c:out value="${product.price}"/></td>
                <td><c:out value="${product.id}"/></td>
                <td><a href="${pageContext.request.contextPath}/deleteProductFromShop?id=${product.id}">Delete</a></td>
            </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/products/add">Add new product</a>
    </body>
</html>
