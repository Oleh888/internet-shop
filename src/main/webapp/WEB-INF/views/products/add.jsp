<%--suppress XmlDuplicatedId --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
</head>
<body>
<jsp:include page="../index.jsp"></jsp:include>

    <h1>Add some products</h1>

    <form method="post" action="${pageContext.request.contextPath}/products/add">
        <div class="form-group">
            <label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Provide your product: </span>
                    </div>
                    <input type="text" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
            </label>
            <label>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-default">Provide product's price: </span>
                    </div>
                    <input type="text" name="price" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                </div>
            </label>
        </div>
        <button type="submit" class="btn btn-primary">Add</button>
    </form>
</body>
</html>
