package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.json.Post;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.EvaluateService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.LabelService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.EvaluateServiceImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.LabelServiceImpl;

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
 * 删除书评
 */
@WebServlet(name = "deleteEvaluateController", value = "/safe/deleteEvaluateController")
public class DeleteEvaluateController extends HttpServlet {
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
        //获取int型数据
        int evaluateId = (int) jsonMap.get("evaluateId");
        //处理数据
        EvaluateService evaluateService = new EvaluateServiceImpl();
        int result = evaluateService.deleteEvaluate(evaluateId);
        Map<String, Object> responseMap = new HashMap<>();
        if(result == 0){
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("massage", "删除失败");
        }else{
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("massage", "删除成功");
        }
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
