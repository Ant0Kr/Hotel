<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="container">
    <form:form method="post" modelAttribute="LogForm" class="form-signin">

        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">

            <spring:bind path="username">
                <form:input path="username" type="text" placeholder="-username-" name="username"
                            class="form-control" autofocus="true"/>
            </spring:bind>

            <spring:bind path="password">
                <form:input path="password" placeholder="-password-" name="password" type="password"
                            class="form-control"/>
            </spring:bind>
            <span>${error}</span>

            <button type="submit" class="btn btn-lg btn-primary btn-block">Log in</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>

        </div>

    </form:form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
