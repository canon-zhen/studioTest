package cn.caizhen.domain;

public class Admins {
    private int aid;  //管理员ID
    private String name;  //管理员姓名
    private String username;  //管理员登录账户
    private String password;  //管理员登录密码
    private String role;//身份

    public Admins(int aid, String name, String username, String password) {
        this.aid = aid;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Admins(int aid, String name, String username, String password, String role) {
        this.aid = aid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public Admins() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
