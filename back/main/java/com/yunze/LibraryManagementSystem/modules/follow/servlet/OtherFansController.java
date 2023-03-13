package com.yunze.LibraryManagementSystem.modules.follow.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.follow.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 查看他人的粉丝列表
 */

@WebServlet(name = "otherFansController", value = "/otherFansController")
public class OtherFansController extends HttpServlet {
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
        FollowService followService = new FollowServiceImpl();
        List<Follow> fans = followService.selectFans(readerId);
        List<Integer> fanList = new ArrayList<>();
        for(Follow fan : fans){
            fanList.add(fan.getFanId());
        }
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("status", "success");
        responseMap.put("code", 2000);
        responseMap.put("fans", fanList);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
