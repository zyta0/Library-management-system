package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.json.Post;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.EvaluateService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.EvaluateServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 更改书评内容
 */
@WebServlet(name = "updateEvaluateController", value = "/updateEvaluateController")
public class UpdateEvaluateController extends HttpServlet {
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
        int evaluateId = (int) jsonMap.get("evaluateId");
        String ev = (String) jsonMap.get("evaluate");//书评内容

        // 处理数据
        EvaluateService evaluateService = new EvaluateServiceImpl();
        Evaluate evaluate = evaluateService.search(evaluateId);
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(evaluate == null){
            response.setStatus(404);
            responseMap.put("status", "failure");
            responseMap.put("code", 404);
            responseMap.put("message", "书评不存在");
        }else {
            evaluate.setEvaluate(ev);
            int result = evaluateService.updateEvaluate(evaluate);
            if (result == 0) {
                response.setStatus(500);
                responseMap.put("status", "failure");
                responseMap.put("code", 500);
                responseMap.put("message", "修改失败");
            } else {
                response.setStatus(200);
                responseMap.put("status", "success");
                responseMap.put("code", 200);
                responseMap.put("message", "修改成功");
                responseMap.put("evaluate", evaluate);
            }
        }
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
