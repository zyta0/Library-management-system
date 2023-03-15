package com.yunze.LibraryManagementSystem.modules.follow.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.follow.service.impl.FollowServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * 查看自己的粉丝列表
 */
@WebServlet(name = "showFansController", value = "/safe/showFansController")
public class ShowFansController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Reader reader = (Reader) session.getAttribute("reader");
        int readerId = reader.getReaderId();
        FollowService followService = new FollowServiceImpl();
        List<Follow> fans = followService.selectFans(readerId);
        Map<String, Object> responseMap = new HashMap<>();
        List<Integer> fanList = new ArrayList<>();
        for(Follow fan : fans){
            fanList.add(fan.getFanId());
        }
        response.setStatus(200);
        responseMap.put("status", "success");
        responseMap.put("code", 200);
        responseMap.put("fans", fanList);
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
