<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

    <h1>Add some products</h1>

    <form method="post" action="${pageContext.request.contextPath}/products/add">
        Provide your product: <input type="text" name="name">
        Provide product's price: <input type="text" name="price">
        <button type="submit">Add</button>
    </form>
</body>
</html>
