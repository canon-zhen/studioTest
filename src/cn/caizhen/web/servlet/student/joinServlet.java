package cn.caizhen.web.servlet.student;

import cn.caizhen.domain.Student;
import cn.caizhen.service.StudentService;
import cn.caizhen.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "joinServlet", value = "/joinServlet")
public class joinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        //封装对象
        Student student=new Student();
        try {
            BeanUtils.populate(student,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用UserService完成更新
        StudentService studentService =new StudentServiceImpl();
        studentService.updateUserTojoin(student);
        response.sendRedirect(request.getContextPath()+"/student_join_drop.jsp");
        //将list存入request域
       /* if (students.size()==0){
            System.out.println("学生集合为空");
            response.sendRedirect(request.getContextPath()+"/student_index.jsp");
        }else{
            request.setAttribute("students",students);
            //转发到list.jsp

            request.getRequestDispatcher("/student_index.jsp").forward(request,response);
            //response.sendRedirect(request.getContextPath()+"/student_index.jsp");

        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
