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
import java.util.Map;

@WebServlet(name = "dropServlet", value = "/dropServlet")
public class dropServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String studentId = request.getParameter("studentId");
        //调用UserService完成更新
        StudentService studentService =new StudentServiceImpl();
        studentService.updateUserTodrop(studentId);
        response.sendRedirect(request.getContextPath()+"/student_join_drop.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
