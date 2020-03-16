<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑试卷</title>
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
    <br><br><br><br><br>
    <form method="post" action="EditPaperServlet">
        <ul>
            <br><li>试卷编号<input type="number" min="1" max="100" required="required" name="p_num" class="input" ></li>
            <br><li>发布日期<input type="datetime-local" required="required" name="publish_time" class="input"></li>
            <br><li>截止日期<input type="datetime-local" required="required" name="deadline" class="input"></li>
            <br><li>试卷标题<input type="text" maxlength="100" required="required" name="p_headline" class="input"></li>
        </ul>
        <br><br>
        <input type="submit" value="提交" class="button">
    </form>
</div>
</body>
</html>