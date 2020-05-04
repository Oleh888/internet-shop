<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

        <body>
            <div class="alert alert-dark" role="alert">
                <h1 class="display-2">* * * Welcome to the internet shop * * *</h1></div>
            <center><h1>Login page</h1></center>
            <center><h4 style="color:red">${errorMsg}</h4></center>
            <center><form method="post" action="${pageContext.request.contextPath}/login">
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
                <button type="submit" class="btn btn-primary">Login</button>
            </form></center>
            <center><a class="memberNameLink" href="${pageContext.request.contextPath}/registration">If you don't have personal account, please go to the registration</a></center>
        </body>
</html>
