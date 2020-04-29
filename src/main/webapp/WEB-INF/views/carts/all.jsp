<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All products in shopping cart</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

<h1>All products in shopping cart page</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>
                <c:out value="${product.id}"/>
            </td>
            <td>
                <c:out value="${product.name}"/>
            </td>
            <td>
                <c:out value="${product.price}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/carts/delete?id=${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
    <form method="get" action="${pageContext.request.contextPath}/completeOrder">
        <button type="submit">Complete order</button>
    </form>

    <a href="${pageContext.request.contextPath}/products/all">Return to the list of all products</a>
</body>
</html>