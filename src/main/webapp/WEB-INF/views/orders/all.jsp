<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

<h2>My oders</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>List of products</th>
    </tr>
    <c:forEach var="order" items="${orders}">
        <tr>
            <td>
                <c:out value="${order.orderId}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/shoppingCart?id=${order.orderId}">Show products</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/orders/delete?id=${order.orderId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
