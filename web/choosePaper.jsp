<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2019/6/17
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>选择考卷</title>
    <link href="css/edit.css" rel="stylesheet">
</head>
<body class="ebody">
<%--<%
    if(session.getAttribute("status")==null)
        response.sendRedirect("login.jsp");
%>--%>

<div class="container">
    <div align="right">
        <input type="button" value="退出" onclick="location.href='quit.jsp'">
    </div>
    <%
        ResultSet rs=(ResultSet) session.getAttribute("rs");
        out.println("<form method=\"post\" action=\"ChooseServlet\">");
        try {
            while (rs.next()) {
                out.println("<input type=\"submit\" class=\"button\" name=\"paper\" value=\""+rs.getString("p_num")+" "+rs.getString("p_headline")+"\">\n");
            }
        } catch (SQLException e) {
            System.out.println("cant get p_headline!");
        }
        out.println("</form>");
    %>
</div>
</body>
</html>
