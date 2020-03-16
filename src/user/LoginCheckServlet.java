package user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;

@WebServlet(name = "user.LoginCheckServlet",urlPatterns = "/LoginCheckServlet")
public class LoginCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("user_name");
        String pwd = request.getParameter("user_password");
        UserBean user = new UserBean();
        HttpSession session = request.getSession();
        user.setUser_name(name);
        user.setUser_pwd(pwd);
        UserCheck uc = new UserCheck();
        if (uc.validate(user)) {
            session.setAttribute("user", user);
            session.setAttribute("status","1");
            if (user.getUser_auth().equals("1")){
                dbBean db=new dbBean();
                ResultSet rs=db.executeQuery("select p_num,p_headline from t_paper");
                if(rs!=null) {
                    session.setAttribute("rs", rs);
                }
                else
                    System.out.println("no paper");
                RequestDispatcher dis = request.getRequestDispatcher("choosePaper.jsp");
                dis.forward(request, response);
            }
            else if (user.getUser_auth().equals("2")){
                RequestDispatcher dis = request.getRequestDispatcher("edit_paper.jsp");
                dis.forward(request, response);
            }
            else
                response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
