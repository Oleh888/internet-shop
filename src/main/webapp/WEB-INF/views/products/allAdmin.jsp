<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

<h2>All products in shop</h2>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>ID</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>
                <c:out value="${product.name}"/>
            </td>
            <td>
                <c:out value="${product.price}"/>
            </td>
            <td>
                <c:out value="${product.id}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/deleteProductFromShop?id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/products/add">Add new product</a>
</body>
</html>
