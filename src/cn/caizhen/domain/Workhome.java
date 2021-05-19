package cn.caizhen.domain;

import java.sql.Date;

public class Workhome {
    private int wid;        //ID
    private String wname;   //名字
    private String header;   //负责人
    private String teacher;   //指导老师
    private String waddress;  //地点
    private String wprize;  //工作室荣誉
    private String wslogan;  //工作室口号
    private Date wtime;//工作室成立时间

    public Workhome(int wid, String wname, String header, String teacher,
                    String waddress, String wprize, String wslogan,Date wtime) {
        this.wid = wid;
        this.wname = wname;
        this.header = header;
        this.teacher = teacher;
        this.waddress = waddress;
        this.wprize = wprize;
        this.wslogan = wslogan;
        this.wtime=wtime;
    }

    public Workhome() {
    }

    public Date getWtime() {
        return wtime;
    }

    public void setWtime(Date wtime) {
        this.wtime = wtime;
    }

    @Override
    public String toString() {
        return "Workhome{" +
                "wid=" + wid +
                ", wname='" + wname + '\'' +
                ", header='" + header + '\'' +
                ", teacher='" + teacher + '\'' +
                ", waddress='" + waddress + '\'' +
                ", wprize='" + wprize + '\'' +
                ", wslogan='" + wslogan + '\'' +
                ", wtime=" + wtime +
                '}';
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getWaddress() {
        return waddress;
    }

    public void setWaddress(String waddress) {
        this.waddress = waddress;
    }

    public String getWprize() {
        return wprize;
    }

    public void setWprize(String wprize) {
        this.wprize = wprize;
    }

    public String getWslogan() {
        return wslogan;
    }

    public void setWslogan(String wslogan) {
        this.wslogan = wslogan;
    }
}
