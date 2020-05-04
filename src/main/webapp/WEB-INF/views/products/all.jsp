<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <jsp:include page="../index.jsp"></jsp:include>
        <center><h1>All products page</h1></center>
        <table class="table table-hover">
            <thead><tr>
                    <th scope="col">Name</th>
                    <th scope="col">Price</th>
                    <th scope="col">ID</th>
                    <th>Add to the cart</th>
            </tr></thead>
            <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td><c:out value="${product.name}"/></td>
                        <td><c:out value="${product.price}"/></td>
                        <td><c:out value="${product.id}"/></td>
                        <td><a class="memberNameLink" href="${pageContext.request.contextPath}/products/addToCart?id=${product.id}">Add</a></td>
                    </tr>
                </c:forEach>
        </table>
        <a class="memberNameLink" href="${pageContext.request.contextPath}/shoppingCart">Go to the shopping cart</a>
    </body>
</html>
