package com.yunze.LibraryManagementSystem.modules.login.servlet;

import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.login.service.ReaderService;
import com.yunze.LibraryManagementSystem.modules.login.service.impl.ReaderServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginController", value = "/loginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //处理数据
        ReaderService readerService = new ReaderServiceImpl();
        Reader reader = readerService.login(username, password);
        //处理结果，流程跳转
        if (reader != null) {
            //登录成功
            //将读者信息存储在Session里，有效期：一次会话
            HttpSession session = request.getSession();
            session.setAttribute("reader", reader);
            response.getWriter().write("登录成功");
            } else {
            //登录失败
            //跳转到登录页面，重新登录
            response.getWriter().println("登录失败");
            response.sendRedirect(request.getContextPath() + "/login.html");
            }
        }
}
