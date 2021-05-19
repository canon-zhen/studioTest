package cn.caizhen.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 登陆验证的过滤器
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //强制转换
        HttpServletRequest request1= (HttpServletRequest) request;
        //获取资源请求路径
        String uri = request1.getRequestURI();
        //判断是否包含登陆相关资源路径
        if (uri.contains("/login.jsp") || uri.contains("/LoginServlet")||uri.contains("/studentHomepage.jsp")||uri.contains("/img/nv.jpg")||
                uri.contains("/RegisterServlet")||uri.contains("/register.jsp")||
                uri.contains("/css/")|| uri.contains("/js/")|| uri.contains("/fonts/")||uri.contains("/html/")||
                uri.contains("/img/")||uri.contains("/checkCodeServlet")){
            //包含，放行
            chain.doFilter(request, response);
        }else{
            //从session中获取duixiang
            Object admins = request1.getSession().getAttribute("admins");
            Object student = request1.getSession().getAttribute("student");
            if (admins!=null || student!=null){
                chain.doFilter(request, response);
            }else{
                //未登录，跳转登陆页面
                request1.setAttribute("login_msg","尚未登录， 请登录");
                request1.getRequestDispatcher("/login.jsp").forward(request1,response);
            }
        }

    }
}
