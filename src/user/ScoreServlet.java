package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ScoreServlet",urlPatterns = "/ScoreServlet")
public class ScoreServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        dbBean db=new dbBean();

        UserBean user=(UserBean)session.getAttribute("user");
        String q_nums=session.getAttribute("q_nums").toString();
        String answers=session.getAttribute("answers").toString();
        String[] q_num=q_nums.split(" ");
        String[] answer=answers.split(" ");
        for (int i=0;i<q_num.length;i++){
            String a1;
            String[] a2;
            if(answer[i].length()<2) {
                a1 = request.getParameter(q_num[i]);
                db.executeUpdate("insert into t_record(o_num,user_id) value('"+a1+"','"+user.getUser_name()+"')");
            }
            else {
                a2 = request.getParameterValues(q_num[i]);
                for(String a:a2)
                    db.executeUpdate("insert into t_record(o_num,user_id) value('"+a+"','"+user.getUser_name()+"')");
            }
        }
        db.close();
        RequestDispatcher dis = request.getRequestDispatcher("finish.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
