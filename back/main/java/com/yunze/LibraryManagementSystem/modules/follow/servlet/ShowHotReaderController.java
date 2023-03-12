package com.yunze.LibraryManagementSystem.modules.follow.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.follow.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 显示热门用户
 */
@WebServlet(name = "showHotReaderController", value = "/showHotReaderController")
public class ShowHotReaderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FollowService followService = new FollowServiceImpl();
        List<Follow> followList = followService.showHot();
        Map<String, Object> responseMap = new HashMap<>();
        if(followList.isEmpty()){
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("massage", "获取失败");
        }else{
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("massage", "获取成功");
            responseMap.put("followList", followList);
        }
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
