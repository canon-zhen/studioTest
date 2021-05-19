package cn.caizhen.service;

import cn.caizhen.domain.Student;

import java.util.List;

/**
 * 学生业务接口类
 */
public interface StudentService {
    //学生
    Student login(Student student);
    boolean register(Student student);
    List<Student> findAllStudentByWorkhome(String workname);
    /**
     * 学生加入工作室修改用户信息
     * @param student
     */
    void updateUserTojoin(Student student);
    //退出工作室更新信息用
    void updateUserTodrop(String studentId);

}
