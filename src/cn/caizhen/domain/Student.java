package cn.caizhen.domain;

public class Student {
    private int sid;  //数据库编号ID
    private int studentId;  //学号
    private String sname;   //姓名
    private String sgender; //性别
    private int sage;       //年龄
    private String sclass;  //班级
    private String sphone;  //电话号码
    private String workHname;//所属工作室
    private String username;//登录账号名
    private String password;//登录密码

    public Student(int sid, int studentId, String sname, String sgender, int sage,
                   String sclass, String sphone, String workHname, String username,
                   String password) {
        this.sid = sid;
        this.studentId = studentId;
        this.sname = sname;
        this.sgender = sgender;
        this.sage = sage;
        this.sclass = sclass;
        this.sphone = sphone;
        this.workHname = workHname;
        this.username = username;
        this.password = password;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", studentId=" + studentId +
                ", sname='" + sname + '\'' +
                ", sgender='" + sgender + '\'' +
                ", sage=" + sage +
                ", sclass='" + sclass + '\'' +
                ", sphone='" + sphone + '\'' +
                ", workHname='" + workHname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSgender() {
        return sgender;
    }

    public void setSgender(String sgender) {
        this.sgender = sgender;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSphone() {
        return sphone;
    }

    public void setSphone(String sphone) {
        this.sphone = sphone;
    }

    public String getWorkHname() {
        return workHname;
    }

    public void setWorkHname(String workHname) {
        this.workHname = workHname;
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
