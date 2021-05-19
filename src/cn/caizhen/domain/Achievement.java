package cn.caizhen.domain;

import java.util.Date;

public class Achievement {
    private int achId;//数据库编号
    private String wkHname;//所属工作室名字
    private String achName;//成就名字
    private Date achTime;//创建时间
    private String achTeacher;//指导老师

    @Override
    public String toString() {
        return "Achievement{" +
                "achId=" + achId +
                ", wkHname='" + wkHname + '\'' +
                ", achName='" + achName + '\'' +
                ", achTime=" + achTime +
                ", achTeacher='" + achTeacher + '\'' +
                '}';
    }

    public int getAchId() {
        return achId;
    }

    public void setAchId(int achId) {
        this.achId = achId;
    }

    public String getWkHname() {
        return wkHname;
    }

    public void setWkHname(String wkHname) {
        this.wkHname = wkHname;
    }

    public String getAchName() {
        return achName;
    }

    public void setAchName(String achName) {
        this.achName = achName;
    }

    public Date getAchTime() {
        return achTime;
    }

    public void setAchTime(Date achTime) {
        this.achTime = achTime;
    }

    public String getAchTeacher() {
        return achTeacher;
    }

    public void setAchTeacher(String achTeacher) {
        this.achTeacher = achTeacher;
    }

    public Achievement() {
    }

    public Achievement(int achId, String wkHname, String achName, Date achTime, String achTeacher) {
        this.achId = achId;
        this.wkHname = wkHname;
        this.achName = achName;
        this.achTime = achTime;
        this.achTeacher = achTeacher;
    }
}
