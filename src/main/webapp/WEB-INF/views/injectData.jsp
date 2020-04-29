<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo</title>
</head>
<jsp:include page="index.jsp"></jsp:include>
    <h1>Your mock data was added to DB</h1>

    <a href="${pageContext.request.contextPath}/">Inject data test into the DB</a>

</body>
</html>
