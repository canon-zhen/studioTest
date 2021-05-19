package cn.caizhen.web.servlet.workHome;

import cn.caizhen.domain.Student;
import cn.caizhen.domain.Workhome;
import cn.caizhen.service.StudentService;
import cn.caizhen.service.WorkhomeService;
import cn.caizhen.service.impl.StudentServiceImpl;
import cn.caizhen.service.impl.WorkhomeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryWorkHomeInforServlet", value = "/queryWorkHomeInforServlet")
public class queryWorkHomeInforServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String wname = request.getParameter("wname");//工作室名字
        String role = request.getParameter("role");//工作室名字
        //查询工作室学生信息
        //调用UserService完成查询
        WorkhomeService workhomeService=new WorkhomeServiceImpl();
        //StudentService studentService =new StudentServiceImpl();
        List<Workhome> workhomes = workhomeService.findAllWorkHomeByname(wname);
        //将list存入request域
        if (workhomes.size()==0){
            System.out.println("学生集合为空");
            if (role.equals("1")){
                //管理界面
                response.sendRedirect(request.getContextPath()+"/wk_workHomeInformation.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/workHomeInformation.jsp");
            }

        }else{
            request.setAttribute("workhomes",workhomes);
            //转发到list.jsp
            if (role.equals("1")){
                request.getRequestDispatcher("/wk_workHomeInformation.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/workHomeInformation.jsp").forward(request,response);
                //response.sendRedirect(request.getContextPath()+"/student_index.jsp");
            }


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
