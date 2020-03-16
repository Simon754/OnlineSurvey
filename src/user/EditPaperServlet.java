package user;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditPaperServlet" ,urlPatterns="/EditPaperServlet")
public class EditPaperServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        dbBean db=new dbBean();
        String p_num=request.getParameter("p_num");
        String deadline=request.getParameter("deadline");
        String publish_time=request.getParameter("publish_time");
        String p_headline=request.getParameter("p_headline");
        String sql="insert into t_paper(deadline,publish_time,p_headline,p_num) value ('"+deadline+"','"+publish_time+"','"+p_headline+"','"+p_num+"')";
        int a=db.executeUpdate(sql);
        if (a!=0){
            session.setAttribute("p_num",p_num);
            RequestDispatcher dis = request.getRequestDispatcher("edit_question.jsp");
            dis.forward(request, response);
        }
        else
            System.out.println("update error");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
