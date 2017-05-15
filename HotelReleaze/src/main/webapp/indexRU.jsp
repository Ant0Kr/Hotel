<%--
  Created by IntelliJ IDEA.
  User: Antoha12018
  Date: 14.05.2017
  Time: 18:48
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
    <link rel="stylesheet" href="css/index.css" media="all"/>

</head>

<body>
<form method="post" action="hotel">
<div class="header">
    <div class="mid">
        <header class="logo">
            <div class="topmenu">
                <aside >
                    <input type="submit" name="indexClick" value="Главная"/>
                    <input type="submit" name="loginClick" value="Вход"/>
                    <input type="submit" name="registrationClick"value="Регистрация"/>
                    <input type="submit" name="changeIndexClick"value="Русский"/>
                    <img src="img/Russia.png" all="Russia" width="30" height="30">
                </aside>
                <p style="color:Red" class="Text" align="center"><%=request.getAttribute("err")%></p>
            </div>
            <img src="img/hotel_logo.png" alt="Логотип сайта" title="Логотип сайта" height="80" class="logo">

        </header>
    </div>
</div>


<div class="footer">
    <div class="mid">
        <div class="fon">

            <img src="img/boss.png" class="boss">
            <img src="img/newHotel.jpg"  width="600" class="hotel">
            <div class="labels">
                <div class="bossLabel">
                    <h4 class="boss">Босс</h4>
                </div>
                <div class="hotelLabel">
                    <h4 class="hotel">Отель "Синявка"</h4>
                </div>
            </div>

        </div>
    </div>
</div>
</form>
</body>
</html>