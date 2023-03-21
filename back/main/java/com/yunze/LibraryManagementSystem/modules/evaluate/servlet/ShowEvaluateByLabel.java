package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.json.LabelEvaluate;
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
import java.util.ArrayList;
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
        String labelName = (String) jsonMap.get("label_name");

        EvaluateService evaluateService = new EvaluateServiceImpl();
        LabelService labelService = new LabelServiceImpl();
        List<Evaluate> list = evaluateService.showByLabel(labelName);
        List<LabelEvaluate> labelEvaluateList = new ArrayList<>();
        Map<String, Object> responseMap = new HashMap<>();
        if(list == null){
            response.setStatus(404);
            responseMap.put("status", "failure");
            responseMap.put("code", 404);
            responseMap.put("message", "查找失败");
        }else{
            for(Evaluate evaluate : list){
                LabelEvaluate labelEvaluate = new LabelEvaluate(labelService.select(evaluate.getLabelId()), evaluate);
                labelEvaluateList.add(labelEvaluate);
            }
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("message", "查找成功");
            responseMap.put("label_evaluates", labelEvaluateList);
        }
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}
