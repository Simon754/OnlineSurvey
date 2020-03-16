package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "ChooseServlet",urlPatterns = "/ChooseServlet")
public class ChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        dbBean db=new dbBean();
        String temp=request.getParameter("paper");
        String []a=temp.split(" ");
        String p_num=a[0];
        String sql="select * from t_question where p_num="+p_num;
        ResultSet question_rs=db.executeQuery(sql);
        session.setAttribute("p",p_num);
        session.setAttribute("question_rs",question_rs);
        StringBuilder question=new StringBuilder();
        session.setAttribute("question",question.toString());
        RequestDispatcher dis = request.getRequestDispatcher("do_test.jsp");
        dis.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
