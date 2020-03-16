<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2019/6/15
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.invalidate();
        response.sendRedirect("login.jsp");
    %>
</body>
</html>
