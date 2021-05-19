package cn.caizhen.dao;


import cn.caizhen.domain.Student;

import java.util.List;

/**
 * 学生操作DAO
 */
public interface StudentDao {
    /**
     * 登录时查询信息
     * @param slogName
     * @param slogPassword
     * @return
     */
    Student findStudentByslogNameAndslogPassword(String slogName,String slogPassword);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    Student findStudentByUsername(String username);
    /**
     * 保存注册的用户
     * @param student
     */
    void saveStudent(Student student);

    /**
     * 根据工作室来查询学生
     * @return
     */
    List<Student> findAllStudentByWorkhome(String workname);

    /**
     * 学生加入工作室修改用户信息
     * @param student
     */
    void updateUserTojoin(Student student);
    //退出工作室更新信息用
    void updateUserTodrop(String studentId);
}
