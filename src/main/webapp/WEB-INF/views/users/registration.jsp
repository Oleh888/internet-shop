<%--suppress XmlDuplicatedId --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
        <jsp:include page="../index.jsp"></jsp:include>
        <center><h1>Hello! Please provide your user details.</h1></center>

        <h4 style="color:red">${message}</h4>
        <center>
            <form method="post" action="${pageContext.request.contextPath}/registration">
                <div class="form-group">
                    <label>
                        <div class="input-group mb-3">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="inputGroup-sizing-default">Provide your name: </span>
                            </div>
                            <input type="text" name="name" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                        </div>
                    </label>
                </div>
                    <div class="form-group">
                        <label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Provide your login: </span>
                                </div>
                                <input type="text" name="login" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>
                        </label>
                    </div>
                    <div class="form-group">
                        <label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Provide your password: </span>
                                </div>
                                <input type="password" name="pwd" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>
                        </label>
                    </div>
                    <div class="form-group">
                        <label>
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="inputGroup-sizing-default">Repeat your password: </span>
                                </div>
                                <input type="password" name="repeat-pwd" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default">
                            </div>
                        </label>
                    </div>
                    <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>
                    <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </center>
    </body>
</html>
