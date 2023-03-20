package com.yunze.LibraryManagementSystem.modules.follow.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.follow.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
/**
 * 取消关注功能
 */

@WebServlet(name = "unfollowController", value = "/safe/unfollowController")
public class UnfollowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 读取前端发送的 JSON 数据
        BufferedReader reader = request.getReader();
        StringBuilder json = new StringBuilder();//拼接字符串
        String line = null;
        while ((line = reader.readLine()) != null) {//逐行读取请求体的数据
            json.append(line);
        }
        reader.close();
        // 将 JSON 数据转换为 Java 对象
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        Map<String, Object> jsonMap = mapper.readValue(json.toString(), Map.class);
        int readerId = (int) jsonMap.get("readerId");

        HttpSession session = request.getSession();
        Reader r = (Reader)session.getAttribute("reader");
        int fanId = r.getReaderId();

        FollowService followService = new FollowServiceImpl();
        int result = followService.unfollow(readerId, fanId);
        Map<String, Object> responseMap = new HashMap<>();
        if(result == 0){
            response.setStatus(500);
            responseMap.put("status", "failure");
            responseMap.put("code", 500);
            responseMap.put("message", "取消关注失败");
        }else{
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("message", "取消关注成功");
        }
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
