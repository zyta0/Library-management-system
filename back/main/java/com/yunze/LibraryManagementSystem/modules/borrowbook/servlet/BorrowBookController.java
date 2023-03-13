package com.yunze.LibraryManagementSystem.modules.borrowbook.servlet;

import com.alibaba.fastjson.JSONObject;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.alibaba.fastjson.JSON;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.borrowbook.json.BorrowRequest;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BorrowService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl.BorrowServiceImpl;
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

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 借书
 */
@WebServlet(name = "borrowBookController", value = "/safe/borrowBookController")
public class BorrowBookController extends HttpServlet {
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
        BorrowRequest borrowRequest = mapper.readValue(json.toString(), BorrowRequest.class);

        // 处理数据
        Book book = borrowRequest.getBook();
        Date borrowDate = DataUtils.strToUtil(borrowRequest.getBorrowDate());
        Date due = DataUtils.strToUtil(borrowRequest.getDue());
        //只负责调用业务逻辑
        HttpSession session = request.getSession();
        Borrow borrow = new Borrow();
        borrow.setReaderId((int)session.getAttribute("reader_id"));
        borrow.setBookId(book.getId());
        borrow.setBorrowDate(borrowDate);
        borrow.setDue(due);
        BorrowService borrowService = new BorrowServiceImpl();
        int result = borrowService.borrowBook(borrow);

        //响应
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(result == 0){//自定义状态码
            responseMap.put("status", "failure");
            responseMap.put("code", 4001);
            responseMap.put("message", "已借此书，此次借书失败");
        }else{
            responseMap.put("status", "success");
            responseMap.put("code", 2000);
            responseMap.put("message", "借书成功");

            responseMap.put("borrow", borrow);
        }
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
