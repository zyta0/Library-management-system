package com.yunze.LibraryManagementSystem.modules.evaluate.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
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

/**
 * 发布书评
 */
@WebServlet(name = "postEvaluateController", value = "/safe/postEvaluateController")
public class PostEvaluateController extends HttpServlet {
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
        Post post = mapper.readValue(json.toString(), Post.class);

        // 处理数据
        Evaluate evaluate = new Evaluate();
        HttpSession httpSession = request.getSession();
        Reader r = (Reader) httpSession.getAttribute("reader");
        evaluate.setReaderId(r.getReaderId());
        evaluate.setBookId(post.getBookId());
        evaluate.setPublishTime(new Date());
        evaluate.setEvaluate(post.getEvaluate());
        evaluate.setLabelId(post.getLabelId());

        System.out.println(evaluate);
        EvaluateService evaluateService = new EvaluateServiceImpl();
        int result = evaluateService.postEvaluate(evaluate);
        //响应
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(result == 0){
            response.setStatus(500);
            responseMap.put("status", "failure");
            responseMap.put("code", 500);
            responseMap.put("message", "发布失败");
        }else{
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("message", "发布成功");

            responseMap.put("evaluate", evaluate);
        }
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
