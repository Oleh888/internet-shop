<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

    <h1>All products page</h1>

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
                    <a href="${pageContext.request.contextPath}/products/addToCart?id=${product.id}">Add</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/shoppingCart">Go to the shopping cart</a>
</body>
</html>
