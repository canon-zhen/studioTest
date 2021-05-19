package cn.caizhen.service;

import cn.caizhen.domain.Achievement;
import cn.caizhen.domain.Student;
import cn.caizhen.domain.Workhome;

import java.util.List;

public interface WorkhomeService {

    /**
     * 添加工作室
     * @param workhome
     */
    void addWorkHome(Workhome workhome);

    /**
     * 根据工作室名字删除工作室
     * @param wname
     */
    void deleteWorkHome(String wname);

    /**
     * 根据工作室名字查询工作室信息
     * @param workname
     * @return
     */
    List<Workhome> findAllWorkHomeByname(String workname);

    /**
     * 查询所有成就信息
     * @return
     */
    List<Achievement> findAllAchievement();
    List<Achievement> findAllAchievementByWkHname(String wkHname);

}
