package user;

public class UserBean implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    private String user_name=null;
    private String user_pwd=null;
    private String user_auth=null;

    public UserBean(){
    }
    public String getUser_name() {
        return user_name;
    }
    public String getUser_pwd() {
        return user_pwd;
    }
    public void setUser_name(String name) {
        user_name=name;
    }
    public void setUser_pwd(String pwd) {
        user_pwd=pwd;
    }
    public String getUser_auth() {
        return user_auth;
    }
    public void setUser_auth(String user_auth) {
        this.user_auth = user_auth;
    }
}
