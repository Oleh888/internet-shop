<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
    <jsp:include page="../index.jsp"></jsp:include>

    <center><h1>All products in shopping cart page</h1></center>

    <table class="table table-hover">
        <thead><tr>
            <th scope="col">ID</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th>Delete product</th>
        </tr></thead>
        <tbody>
        <c:forEach var="product" items="${products}">
        <tr>
            <td><c:out value="${product.id}"/></td>
            <td><c:out value="${product.name}"/></td>
            <td><c:out value="${product.price}"/></td>
            <td><a class="memberNameLink" href="${pageContext.request.contextPath}/carts/delete?id=${product.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </table>

    <form method="get" action="${pageContext.request.contextPath}/completeOrder">
        <button type="submit" class="btn btn-primary">Complete order</button>
    </form>
    <a class="memberNameLink" href="${pageContext.request.contextPath}/products/all">Return to the list of all products</a>
    </body>
</html>