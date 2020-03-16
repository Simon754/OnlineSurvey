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
        ResultSet question_rs=(ResultSet) session.getAttribute("question_rs");
        session.setAttribute("question_rs",question_rs);
        out.println("<form method=\"post\" action=\"ScoreServlet\">");
        out.println("<div align=\"left\">");
        StringBuilder q_nums=new StringBuilder();
        StringBuilder answers=new StringBuilder();
        try {
            while (question_rs.next()) {
                String q_num=String.valueOf(question_rs.getInt("q_num"));
                String q_s_num=String.valueOf(question_rs.getInt("q_num"));
                String q_type=question_rs.getString("q_type");
                String q_headline=question_rs.getString("q_headline");
                String q_answer=String.valueOf(question_rs.getInt("q_answer"));
                q_nums.append(q_num+' ');
                answers.append(q_answer+' ');
                session.setAttribute("q_nums",q_nums);
                session.setAttribute("answers",answers);
                dbBean db=new dbBean();
                ResultSet option_rs=db.executeQuery("select * from t_option where q_num="+q_num);
                out.println("<ul style=\"ali\">");
                out.println("<li style=\"list-style-type: none\">"+q_s_num+".  ("+q_type+"题)"+q_headline+"</li>");
                out.println("<br>");
                try {
                    while (option_rs.next()) {
                        if (q_type.equals("单选"))
                            out.println("<li style=\"list-style-type: none\">    <input type=\"radio\" value=\""+option_rs.getInt("o_num")+' '+"\" required=\"required\" name=\""+q_num+"\">"+fun(option_rs.getInt("o_s_num"))+'.'+option_rs.getString("o_content"));
                        else if(q_type.equals("多选"))
                            out.println("<li style=\"list-style-type: none\">    <input type=\"checkbox\" value=\""+option_rs.getInt("o_num")+' '+"\" name=\""+q_num+"\">"+fun(option_rs.getInt("o_s_num"))+'.'+option_rs.getString("o_content"));
                    }
                } catch (SQLException e) {
                    System.out.println("cant get option!");
                }
                out.println("<br><br><br></ul>");
            }
        } catch (SQLException e) {
            System.out.println("cant get question!");
        }
        out.println("</div>");
        out.println("<input type=\"submit\" value=\"提交\" class=\"button\">\n");
        out.println("</form>");
    %>
</div>
</body>
</html>
