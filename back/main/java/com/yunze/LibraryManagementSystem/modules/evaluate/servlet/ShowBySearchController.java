package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

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

/**
 * 通过搜索显示书评
 */
@WebServlet(name = "showBySearchController", value = "/showBySearchController")
public class ShowBySearchController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        String str = request.getParameter("str");//书名或用户名
        //处理数据
        EvaluateService evaluateService = new EvaluateServiceImpl();
        List<Evaluate> list = evaluateService.show(str);
        LabelService labelService = new LabelServiceImpl();
        //响应
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(!list.isEmpty()){
            List<LabelEvaluate> labelEvaluates = new ArrayList<>();
            Label label = null;
            for(Evaluate evaluate : list){
                label = labelService.select(evaluate.getLabelId());
                LabelEvaluate labelEvaluate = new LabelEvaluate(label, evaluate);
                labelEvaluates.add(labelEvaluate);
            }
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("message", "请求成功");
            responseMap.put("evaluates", labelEvaluates);
        }else{
            response.setStatus(404);
            responseMap.put("status", "failure");
            responseMap.put("code", 404);
            responseMap.put("message", "未找到");
        }
        ObjectMapper mapper = new ObjectMapper();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
