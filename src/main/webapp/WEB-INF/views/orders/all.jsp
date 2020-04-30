<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
    <jsp:include page="../index.jsp"></jsp:include>

    <center><h2>My oders</h2></center>

    <table class="table table-hover">
        <thead><tr>
            <th scope="col">ID</th>
            <th scope="col">List of products</th>
            <th>Delete cart</th>
        </tr></thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
        <tr>
            <td><c:out value="${order.orderId}"/></td>
            <td><a href="${pageContext.request.contextPath}/MyProductsToBuy?id=${order.orderId}">Show products</a></td>
            <td><a href="${pageContext.request.contextPath}/orders/delete?id=${order.orderId}">Delete</a></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
