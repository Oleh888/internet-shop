<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <jsp:include page="index.jsp"></jsp:include>
    <head>
        <title>Demo</title>
    </head>
    <body>
        <h1>Your mock data was added to DB</h1>
        <a href="${pageContext.request.contextPath}/">Inject data test into the DB</a>
    </body>
</html>
