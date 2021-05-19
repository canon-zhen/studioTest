package cn.caizhen.web.servlet.achievement;

import cn.caizhen.domain.Achievement;
import cn.caizhen.service.WorkhomeService;
import cn.caizhen.service.impl.WorkhomeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "queryAchievementBynameServlet", value = "/queryAchievementBynameServlet")
public class queryAchievementBynameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String wname = request.getParameter("wname");//工作室名字
        String role = request.getParameter("role");//工作室名字
        //查询工作室学生信息
        //调用Service完成查询
        WorkhomeService workhomeService=new WorkhomeServiceImpl();
        List<Achievement> achievements = workhomeService.findAllAchievementByWkHname(wname);
        //将list存入request域
        if (achievements.size()==0){
            System.out.println("成就集合为空");
            if (role.equals("1")){
                //管理员
                response.sendRedirect(request.getContextPath()+"/wk_workhomePrize.jsp");
            }else {
                response.sendRedirect(request.getContextPath()+"/workhomePrize.jsp");
            }
            //response.sendRedirect(request.getContextPath()+"/workhomePrize.jsp");
        }else{
            request.setAttribute("achievements",achievements);
            //转发到list.jsp
            if (role.equals("1")){
                request.getRequestDispatcher("/wk_workhomePrize.jsp").forward(request,response);
            }else{
                request.getRequestDispatcher("/workhomePrize.jsp").forward(request,response);
                //response.sendRedirect(request.getContextPath()+"/student_index.jsp");
            }


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
