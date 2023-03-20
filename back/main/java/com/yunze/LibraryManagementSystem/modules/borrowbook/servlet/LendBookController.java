package com.yunze.LibraryManagementSystem.modules.borrowbook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.borrowbook.json.BorrowRequest;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BorrowService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl.BorrowServiceImpl;
import com.alibaba.fastjson.JSON;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 还书
 */
@WebServlet(name = "lendBookController", value = "/safe/lendBookController")
public class LendBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从request对象中获取SelectBorrowController查询到的Borrow对象
        Borrow borrow = (Borrow) request.getAttribute("borrow");
        System.out.println(borrow);
        //处理数据
        BorrowService borrowService = new BorrowServiceImpl();
        int result = borrowService.lendBook(borrow);
        Map<String, Object> responseMap  = new HashMap<>();
        if(result == 0){
            response.setStatus(500);
            responseMap.put("status","failure");
            responseMap.put("code", 500);
            responseMap.put("message", "归还失败");
        }else{
            response.setStatus(200);
            responseMap.put("status","success");
            responseMap.put("code", 200);
            responseMap.put("message", "归还成功");
        }
        // 将 Java 对象转换为 JSON 数据
        ObjectMapper mapper = new ObjectMapper();
        String JsonStr = mapper.writeValueAsString(responseMap);
        // 返回响应数据
        response.getWriter().write(JsonStr);

    }
}
