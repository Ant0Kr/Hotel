<%--
  Created by IntelliJ IDEA.
  User: Antoha12018
  Date: 15.05.2017
  Time: 18:14
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
    <link rel="stylesheet" href="css/mainUser.css" media="all"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<form method="post" action="hotel">
    <div class="header">
        <div class="mid">
            <header class="logo">
                <div class="topmenu">
                    <aside >
                        <input type="submit" name="myBookClick" value="Мои отели" class="mainBtn"/>
                        <input type="submit" name="exitClick" value="Выход" class="mainBtn"/>
                        <input type="submit" name="changeMainUserClick" value="Русский" class="mainBtn"/>
                        <img src="img/Russia.png" all="Russia" width="40" height="40">
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

                    <h3 class="form-signin-heading">Бронирование</h3>

                    <div >
                        <input type="text" class="form-control" placeholder="Заезд"
                               autofocus="true" name="bookCheckIn"/>
                    </div>

                    <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errCheckIn")%></p>

                    <div >
                        <input type="text" class="form-control" placeholder="Выезд"
                               autofocus="true" name="bookCheckOut"/>
                    </div>

                    <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errCheckOut")%></p>

                    <div class="oneStr">
                        <h4 class="sizeRoom">Количество гостей</h4>

                        <select name="langRU" class="langRU" class="select">
                            <option selected value="one">На одного человека</option>
                            <option value="two">На двух человек</option>
                            <option value="big">Большая комната</option>
                        </select>
                    </div>
                    <p style="color:Red" class="Text" align="center"><%=request.getAttribute("errBook")%></p>

                    <button class="btn btn-lg btn-primary btn-block bookRU" name="bookBtn" type="submit">Забронировать</button>
                    <p style="color:Green" class="Text" align="center"><%=request.getAttribute("successBook")%></p>
                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>