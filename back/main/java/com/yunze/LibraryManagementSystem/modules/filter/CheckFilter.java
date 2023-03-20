package com.yunze.LibraryManagementSystem.modules.filter;

import com.yunze.LibraryManagementSystem.modules.login.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * //权限验证  验证用户是否登录
 */
@WebFilter(value = "/safe/*")
public class CheckFilter implements javax.servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //向下转型
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("reader");
        if(user != null){//登录过
            filterChain.doFilter(request,response);
        }else{//登录页面
            response.sendRedirect(request.getContextPath() + "/login.html");//todo
        }
    }

    @Override
    public void destroy() {

    }
}
