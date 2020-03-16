<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2019/5/21
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link href="css/login.css" rel="stylesheet">
    <style type="text/css"></style>
</head>
<body id="login_body">
<div id="login_container">
    <form method="post" action="LoginCheckServlet">
        <a id="logo" href="login.jsp"></a>
        <hr color="#1e88e5"><br><br>
        <div id="login_name">
            <input name="user_name" class="input" type="text" placeholder="Account" value required="required" autofocus>
        </div>
        <hr class="blank">
        <div id="login_password">
            <input name="user_password" class="input" type="password" placeholder="Password" required="required">
        </div>
        <br>
        <hr class="blank">
        <input type="submit" value="Login" class="button">
        <hr class="blank">
        <input type="reset" value="Reset" class="button">
        <hr class="blank">
    </form>
</div>
</body>
</html>
