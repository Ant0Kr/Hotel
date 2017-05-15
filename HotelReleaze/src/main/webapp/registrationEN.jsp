<%--
  Created by IntelliJ IDEA.
  User: Antoha12018
  Date: 14.05.2017
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">

    <title>Sinuavka Hotel&Resort</title>

    <link rel="shortcut icon" href="img/favicon.ico" />
    <!-- CSS FILES -->
    <link rel="stylesheet" href="css/registration.css" media="all"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<form method="post" action="hotel">
<div class="header">
    <div class="mid">
        <header class="logo">
            <div class="topmenu">
                <aside >
                    <input type="submit" name="indexClick" value="Main" class="mainBtn"/>
                    <input type="submit" name="loginClick"value="Log In" class="mainBtn"/>
                    <input type="submit" name="changeRegClick"value="English" class="mainBtn"/>
                    <img src="img/britain.png" all="Russia" width="40" height="40">
                </aside>

            </div>
            <img src="img/hotel_logo.png" alt="SIte logo" title="Site logo" height="80" class="logo">

        </header>
    </div>
</div>


<div class="footer">
    <div class="mid">
        <div class="fon">
            <div class="container">

                <h3 class="form-signin-heading">Create your account</h3>

                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <input type="text" path="username" class="form-control" placeholder="Username"
                           autofocus="true" name="regUsername"/>
                    <errors path="username"></errors>
                </div>

                <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errLog")%></p>

                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <input type="password" path="password" class="form-control" placeholder="Password"
                    name="regPassword"/>
                    <errors path="password"></errors>
                </div>

                <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errPass")%></p>



                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <input type="password" path="passwordConfirm" class="form-control"
                           placeholder="Confirm your password" name="regConfirm"/>
                    <errors path="passwordConfirm"></errors>
                </div>

                <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errConf")%></p>

                <button class="btn btn-lg btn-primary btn-block regEN" name="regBtn" type="submit">Submit</button>

            </div>
        </div>
    </div>
</div>
</form>
</body>
</html>