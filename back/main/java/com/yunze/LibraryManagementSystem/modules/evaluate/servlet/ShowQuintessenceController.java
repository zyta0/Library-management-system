package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
import com.yunze.LibraryManagementSystem.modules.evaluate.json.LabelEvaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.EvaluateService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.LabelService;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.EvaluateServiceImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.impl.LabelServiceImpl;

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
 * 显示精华书评
 */
@WebServlet(name = "showQuintessenceController", value = "/showQuintessenceController")
public class ShowQuintessenceController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EvaluateService evaluateService = new EvaluateServiceImpl();
        List<Evaluate> evaluateList = evaluateService.showQuintessence();
        LabelService labelService = new LabelServiceImpl();

        Map<String, Object> responseMap = new HashMap<>();
        if (evaluateList.isEmpty()) {
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("message", "未找到");
        } else {
            List<LabelEvaluate> list = new ArrayList<>();
            Label label = null;
            for (Evaluate evaluate : evaluateList) {
                label = labelService.select(evaluate.getLabelId());
                LabelEvaluate labelEvaluate = new LabelEvaluate(label, evaluate);
                list.add(labelEvaluate);
            }
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("message", "请求成功");
            responseMap.put("label_evaluate", list);
        }

        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        response.getWriter().write(mapper.writeValueAsString(responseMap));
    }
}