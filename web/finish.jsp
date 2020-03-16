<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2019/6/14
  Time: 23:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="user.dbBean" %>
<%@page import="java.util.Enumeration" %>
<html>
<head>
    <title>Title</title>
    <link href="css/edit.css" rel="stylesheet">
</head>
<body class="ebody">
<%--<%
    if(session.getAttribute("status")==null)
        response.sendRedirect("login.jsp");
%>--%>
<%!
    public String fun(int a){
        if (a==0)
            return "A";
        else if (a==1)
            return "B";
        else if (a==2)
            return "C";
        else if (a==3)
            return "D";
        return "error";
    }
%>
<div style="width: 70%; height: 90%;display: table-cell;vertical-align: middle;text-align: center;background-color: #fff;border-radius:5px 5px 5px 5px;">
    <div align="right">
        <input type="button" value="退出" onclick="location.href='quit.jsp'">
    </div>
    <%
        out.println("<div align=\"left\">");
        dbBean db=new dbBean();
        ResultSet rs=db.executeQuery("select o_num from t_record");
        try {
            while (rs.next()) {
                ResultSet q_num_rs=db.executeQuery("select q_num from t_option where o_num="+rs.getInt("o_num"));
                out.println("<ul>");
                q_num_rs.next();
                out.println("<li style=\"list-style-type: none\">" + q_num_rs.getString("q_num") + ".");

                out.println("<li style=\"list-style-type: none\">"+""+rs.getInt("o_num"));


            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("cant get question!");
        }
        out.println("</div>");
    %>
</div>
</body>
</html>
