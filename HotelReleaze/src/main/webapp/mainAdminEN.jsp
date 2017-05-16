<%--
  Created by IntelliJ IDEA.
  User: Antoha12018
  Date: 15.05.2017
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <meta charset="utf-8">

    <title>Sinuavka Hotel&Resort</title>

    <link rel="shortcut icon" href="img/favicon.ico" />
    <!-- CSS FILES -->
    <link rel="stylesheet" href="css/mainAdmin.css" media="all"/>
    <link href="css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
<form method="post" action="hotel">
    <div class="header">
        <div class="mid">
            <header class="logo">
                <div class="topmenu">
                    <aside >
                        <input type="submit" name="usersClick" value="Users" class="mainBtn"/>
                        <input type="submit" name="exitClick" value="Exit" class="mainBtn"/>
                        <input type="submit" name="changeMainAdminClick" value="English" class="mainBtn"/>
                        <img src="img/britain.png" all="Britain" width="40" height="40">
                    </aside>

                </div>
                <img src="img/hotel_logo.png" alt="SIte logo" title="Site logo" height="80" class="logo">

            </header>
        </div>
    </div>


    <div class="footer">
        <div class="mid">
            <div class="fon">
                <table>
                    <tr>
                        <th>№ room</th><th>Type</th><th>State</th><th>Booked(who)</th>
                    </tr>
                    <c:forEach items="${rooms}" var="room">
                        <tr>
                            <td align="center">${room.roomID.toString()}</td>
                            <td align="center">${room.stringRoomTypeEN}</td>
                            <td align="center">${room.stringStateEN}</td>
                            <td align="center">${room.userID}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</form>
</body>
</html>