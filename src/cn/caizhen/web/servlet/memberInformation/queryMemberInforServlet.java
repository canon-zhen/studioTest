package cn.caizhen.web.servlet.memberInformation;

import cn.caizhen.domain.Student;
import cn.caizhen.service.StudentService;
import cn.caizhen.service.impl.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryMemberInforServlet", value = "/queryMemberInforServlet")
public class queryMemberInforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String wname = request.getParameter("wname");//工作室名字
        String role = request.getParameter("role");
        //查询工作室学生信息
        //调用UserService完成查询
        StudentService studentService =new StudentServiceImpl();
        List<Student> students = studentService.findAllStudentByWorkhome(wname);
        //将list存入request域
        if (students.size()==0){
            System.out.println("学生集合为空");
            if (role.equals("1")){
                //管理界面
                response.sendRedirect(request.getContextPath()+"/admin_index.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/student_index.jsp");
            }
        }else{
            request.setAttribute("students",students);
            //转发到list.jsp
            if (role.equals("1")){
                request.getRequestDispatcher("/admin_index.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/student_index.jsp").forward(request,response);
                //response.sendRedirect(request.getContextPath()+"/student_index.jsp");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
