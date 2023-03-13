package com.yunze.LibraryManagementSystem.modules.follow.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.follow.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算关注数量
 */
@WebServlet(name = "countFollowsController", value = "/countFollowsController")
public class CountFollowsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int fanId = (int)session.getAttribute("reader_id");
        FollowService followService = new FollowServiceImpl();
        int count = followService.followCount(fanId);
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", "success");
        responseMap.put("code", 2000);
        responseMap.put("followsCount", count);
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
