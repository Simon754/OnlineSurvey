package user;

import java.sql.ResultSet;
import java.sql.*;

public class UserCheck {
    public boolean validate(UserBean user) {
        dbBean db = new dbBean();
        String sql = "SELECT * FROM t_user";
        ResultSet rs = db.executeQuery(sql);
        try {
            while (rs.next()) {
                if (String.valueOf(rs.getInt("user_id")).equals(user.getUser_name()) && String.valueOf(rs.getInt("user_pwd")).equals(user.getUser_pwd())) {
                    user.setUser_name(String.valueOf(rs.getInt("user_id")));
                    user.setUser_pwd(String.valueOf(rs.getInt("user_pwd")));
                    user.setUser_auth(String.valueOf(rs.getInt("user_auth")));
                    db.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        db.close();
        return false;
    }
}
