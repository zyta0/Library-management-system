package com.yunze.LibraryManagementSystem.modules.borrowbook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.borrowbook.json.BorrowRequest;
import com.yunze.LibraryManagementSystem.modules.borrowbook.json.RenewRequest;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BorrowService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl.BorrowServiceImpl;
import com.alibaba.fastjson.JSON;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

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
 * 续借
 */
@WebServlet(name = "renewBookController", value = "/safe/renewBookController")
public class RenewBookController extends HttpServlet {
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
        //创建DateFormat对象，设置日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        RenewRequest renewRequest = mapper.readValue(json.toString(), RenewRequest.class);
        Borrow borrow = renewRequest.getBorrow();
        Date due = DataUtils.strToUtil(renewRequest.getDue());
        borrow.setDue(due);
        BorrowService borrowService = new BorrowServiceImpl();
        int result = borrowService.renewBook(borrow);
        Map<String, Object> responseMap = new HashMap<>();
        if(result == 0){
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("massage", "续借失败");
        }else{
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("massage", "续借成功");

            responseMap.put("borrow", borrow);
        }
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
