package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
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
import java.util.List;
import java.util.Map;

/**
 * 通过讨论热点链接到书评
 */
@WebServlet(name = "showEvaluateByLabel", value = "/showEvaluateByLabel")
public class ShowEvaluateByLabel extends HttpServlet {
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
        int labelId = (int) jsonMap.get("labelId");

        EvaluateService evaluateService = new EvaluateServiceImpl();
        LabelService labelService = new LabelServiceImpl();
        List<Evaluate> list = evaluateService.showByLabel(labelId);
        Map<String, Object> responseMap = new HashMap<>();
        if(list == null){
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("message", "查找失败");
        }else{
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("message", "查找成功");
            responseMap.put("label", labelService.select(labelId));
            responseMap.put("evaluates", list);
        }
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
