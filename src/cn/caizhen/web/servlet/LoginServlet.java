package cn.caizhen.web.servlet;

import cn.caizhen.domain.Admins;
import cn.caizhen.domain.Student;
import cn.caizhen.service.AdminService;
import cn.caizhen.service.StudentService;
import cn.caizhen.service.impl.AdminServiceImpl;
import cn.caizhen.service.impl.StudentServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String verifycode = request.getParameter("verifycode");//获取验证码
        //校验验证码(在获取全部数据之前)
        HttpSession session = request.getSession();
        String checkcode_session =(String)session.getAttribute("checkcode_session");
        session.removeAttribute("checkcode_session");//确保验证码一次性
        if (!checkcode_session.equalsIgnoreCase(verifycode)){
            //验证码不正确
            //提示信息
            request.setAttribute("login_msg","验证码错误！");
            //跳转到登陆页面
            request.getRequestDispatcher("/login.jsp").forward(request,response);

            return;
        }
        //获取数据
        String role = request.getParameter("role");//用户是1,管理员是0
        Map<String, String[]> map = request.getParameterMap();//获取所有数据
        System.out.println(role);
        //根据身份登录
        if (role.equals("0")){
            //System.out.println("管理员");
            //封装Admins对象
            Admins admins=new Admins();
            try {
                BeanUtils.populate(admins,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用Service查询
            AdminService adminService=new AdminServiceImpl();
            Admins loginAdmins=adminService.login(admins);
            System.out.println(loginAdmins.getRole()+"    loginservlet.jsp");
            //判断是否成功
            if (loginAdmins!=null){
                //成功
                //将用户存入session
                session.setAttribute("admins",loginAdmins);
                //跳转页面
                response.sendRedirect(request.getContextPath()+"/admin_index.jsp");
            }else{
                //登录失败
                //提示信息
                request.setAttribute("login_msg","登录失败！");
                //跳转到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }else{
            System.out.println("用户");
            //封装Student对象
            Student student=new Student();
            try {
                BeanUtils.populate(student,map);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            //调用Service查询
            StudentService studentService=new StudentServiceImpl();
            Student loginStudent=studentService.login(student);
            //System.out.println(loginStudent);
            //判断是否成功
            if (loginStudent!=null){
                //成功
                //将用户存入session
                session.setAttribute("student",loginStudent);
                //跳转页面
                response.sendRedirect(request.getContextPath()+"/student_index.jsp");
            }else{
                //登录失败
                //提示信息
                request.setAttribute("login_msg","登录失败！");
                //跳转到登陆页面
                request.getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
