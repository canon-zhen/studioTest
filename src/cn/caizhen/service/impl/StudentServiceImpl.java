package cn.caizhen.service.impl;

import cn.caizhen.dao.StudentDao;
import cn.caizhen.dao.impl.StudentDaoImpl;
import cn.caizhen.domain.Student;
import cn.caizhen.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao dao=new StudentDaoImpl();

    @Override
    public Student login(Student student) {
        return dao.findStudentByslogNameAndslogPassword(student.getUsername(),student.getPassword());
    }

    @Override
    public boolean register(Student student) {
        Student studentByUsername = dao.findStudentByUsername(student.getUsername());
        System.out.println(studentByUsername+"StuserviceImpl");
        if (studentByUsername != null){
            //用户名存在，注册失败
            return false;
        }
        //无重名，保存
        dao.saveStudent(student);
        return true;
    }

    @Override
    public List<Student> findAllStudentByWorkhome(String workname) {
        return dao.findAllStudentByWorkhome(workname);
    }

    @Override
    public void updateUserTojoin(Student student) {
        dao.updateUserTojoin(student);
    }

    @Override
    public void updateUserTodrop(String studentId) {
        dao.updateUserTodrop(studentId);
    }
}
