package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.LabelService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.LabelServiceImpl;

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
 * 显示所有讨论热点
 */
@WebServlet(name = "showAllLabelController", value = "/showAllLabelController")
public class ShowAllLabelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LabelService labelService = new LabelServiceImpl();
        List<Label> list = labelService.showAll();
        Map<String, Object> responseMap = new HashMap<>();
        if(list.isEmpty()){
            response.setStatus(404);
            responseMap.put("status", "failure");
            responseMap.put("code", 404);
            responseMap.put("massage", "获取失败");
        }else{
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("massage", "获取成功");
            responseMap.put("labels", list);
        }
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
