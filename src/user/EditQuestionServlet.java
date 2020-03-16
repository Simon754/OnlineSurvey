package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "EditQuestionServlet", urlPatterns = "/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        dbBean db = new dbBean();
        String p_num = String.valueOf(session.getAttribute("p_num"));
        String q_s_num = request.getParameter("q_s_num");
        String q_headline = request.getParameter("q_headline");
        String q_type = request.getParameter("q_type");
        String q_answer = "";
        if (q_type.equals("单选")) {
            q_answer = request.getParameter("q_answer");
        } else if (q_type.equals("多选")) {
            String[] temp = request.getParameterValues("q_answer");
            StringBuilder a=new StringBuilder();
            for (String b:temp)
                a.append(b);
            q_answer=a.toString();
        }
        String sql = "insert into t_question(q_s_num,q_type,q_headline,p_num,q_answer) value ('" + q_s_num + "','" + q_type + "','" + q_headline + "','" + p_num + "','" + q_answer + "')";
        db.executeUpdate(sql);
        String q_num = null;
        ResultSet rs = db.executeQuery("select q_num from t_question where p_num=" + p_num + " and q_s_num=" + q_s_num);
        try {
            while (rs.next())
                q_num = String.valueOf(rs.getInt("q_num"));
        } catch (SQLException e) {
            System.out.println("cant get q_num!");
        }
        int result=0;
        String[] o_content = request.getParameterValues("o_content");
        for (int i = 0; i < o_content.length; i++) {
            sql = "insert into t_option(o_s_num,o_content,q_num) value ('" + i + "','" + o_content[i] + "','" + q_num + "')";
            result=db.executeUpdate(sql);
        }
        if (result!=0){
            RequestDispatcher dis = request.getRequestDispatcher("edit_question.jsp");
            dis.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
