package cn.caizhen.dao.impl;

import cn.caizhen.dao.StudentDao;
import cn.caizhen.domain.Admins;
import cn.caizhen.domain.Student;
import cn.caizhen.util.JDBCUtils;
import com.alibaba.druid.sql.visitor.functions.Concat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public Student findStudentByslogNameAndslogPassword(String slogName, String slogPassword) {
        try{
            String sql="select * from student where username= ? and password= ?";
            Student student = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Student>(Student.class),
                    slogName, slogPassword);
            return student;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student findStudentByUsername(String username) {
        try {
            //定义sql
            String sql="select * from student where username= ? ";
            Student student = template.queryForObject(sql, new BeanPropertyRowMapper<Student>(Student.class), username);
            return student;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveStudent(Student student) {
        String sql="insert into student(username,password,sname,sclass,studentId,sgender,sage,sphone) " +
                "values(?,?,?,?,?,?,?,?)";
        template.update(sql,student.getUsername(),student.getPassword(),student.getSname(),student.getSclass()
                            ,student.getStudentId(),student.getSgender(),student.getSage(),student.getSphone());
    }

    @Override
    public List<Student> findAllStudentByWorkhome(String workname) {
        //定义sql
        System.out.println(workname);
        String sql="select * from student where workHname like  CONCAT('%',?,'%')" ;
        //String s2="SELECT area_id FROM sys_area WHERE area_code LIKE ";

        List<Student> students = template.query(sql, new BeanPropertyRowMapper<Student>(Student.class),workname);


        return students;
    }

    @Override
    public void updateUserTojoin(Student student) {
        String sql="update student set workHname=?,sname=?,sphone=?,sclass=? where studentId=?";
        int update = template.update(sql, student.getWorkHname(), student.getSname(), student.getSphone(), student.getSclass()
                , student.getStudentId());
        System.out.println(update+"    studentDao");
    }

    @Override
    public void updateUserTodrop(String studentId) {
        String sql="update student set workHname=null where studentId=?";
        int update = template.update(sql,studentId);
        System.out.println(update+"    studentDao");
    }
}
