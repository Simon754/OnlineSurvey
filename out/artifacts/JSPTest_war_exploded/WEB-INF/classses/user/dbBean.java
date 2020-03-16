package user;
import java.sql.*;

public class dbBean {
    private Connection conn=null;
    private Statement stmt=null;
    public dbBean()
    {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/ljx2017011167?serverTimezone=UTC";
        String user = "root";
        String password = "123456";
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url,user, password);
            stmt = conn.createStatement();
        }
        catch(Exception ex){System.out.println("cant link to server!");}
    }
    public int executeUpdate(String s)
    {
        int result=0;
        try{result=stmt.executeUpdate(s);}
        catch(Exception ex){System.out.println("update error!");}
        return result;
    }
    public ResultSet executeQuery(String s)
    {
        ResultSet rs=null;
        try{rs=stmt.executeQuery(s);}
        catch(Exception ex){System.out.println("query error!");}
        return rs;
    }
    public void close()
    {
        try{
            stmt.close();
            conn.close();
        }
        catch(Exception e){}
    }
}
