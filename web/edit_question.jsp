<%--
  Created by IntelliJ IDEA.
  User: Simon
  Date: 2019/6/15
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="css/edit.css" rel="stylesheet">
    <script>
        window.onload=function(){
            var submitBtn = document.getElementById("submit");
            submitBtn.onclick = function () {
                var x=document.getElementsByName("q_answer");
                var flag=0,i;
                for (i=0;i<x.length;i++) {
                    if(x[i].checked) {
                        flag=1;
                    }
                }
                if (flag===0){
                    alert("请勾选答案!");
                    return false;
                }
            };
        }
    </script>
</head>
<%--<%
    if(session.getAttribute("status")==null)
        response.sendRedirect("login.jsp");
%>--%>
<body class="ebody">
    <div class="container">
        <div align="right">
            <input type="button" value="退出" onclick="location.href='quit.jsp'">
        </div>
        <form method="post" action="EditQuestionServlet">
            <ul><br><br>
                <li style="list-style-type: none">题目序号<input type="number" min="1" max="99" required="required" name="q_s_num" style="width: 50px"></li>
                <li style="list-style-type: none">题目标题<input type="text" required="required" name="q_headline" style="width: 250px"></li>
                <li style="list-style-type: none">题目类型<input type="radio" name="q_type" required="required" value="单选">单选<input type="radio" name="q_type" value="多选">多选</li>
                <br><br>请在选项前勾选正确答案<br>
                <br><li style="list-style-type: none"><input type="checkbox" name="q_answer" value="0">A选项内容<input type="text" maxlength="100" required="required" name="o_content" style="width: 200px"></li>
                <br><li style="list-style-type: none"><input type="checkbox" name="q_answer" value="1">B选项内容<input type="text" maxlength="100" required="required" name="o_content" style="width: 200px"></li>
                <br><li style="list-style-type: none"><input type="checkbox" name="q_answer" value="2">C选项内容<input type="text" maxlength="100" required="required" name="o_content" style="width: 200px"></li>
                <br><li style="list-style-type: none"><input type="checkbox" name="q_answer" value="3">D选项内容<input type="text" maxlength="100" required="required" name="o_content" style="width: 200px"></li>
            </ul><br>
            <input id="submit" type="submit" value="提交" class="button">
        </form>
    </div>
</body>
</html>
