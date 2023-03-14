package com.yunze.LibraryManagementSystem.modules.borrowbook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.borrowbook.json.LendOrRenewRequest;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BorrowService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl.BorrowServiceImpl;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

/**
 * 查询借阅表
 */
@WebServlet(name = "selectBorrowController", value = "/safe/selectBorrowController")
public class SelectBorrowController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
        LendOrRenewRequest lendOrRenewRequest = mapper.readValue(json.toString(), LendOrRenewRequest.class);

        // 处理数据
        //只负责调用业务逻辑
        HttpSession session = request.getSession();
        BorrowService borrowService = new BorrowServiceImpl();
        Reader r = (Reader) session.getAttribute("reader");
        int readerId = r.getReaderId();
        Book book = lendOrRenewRequest.getBook();
        int bookId = book.getId();
        Borrow borrow = borrowService.select(readerId, bookId);
        System.out.println(borrow);

        //将查询结果存储在request对象中
        request.setAttribute("borrow", borrow);
        //根据请求参数动态决定转发给哪个Servlet
        String action = lendOrRenewRequest.getAction();//获取请求参数
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(action.equals("lend")) {if(borrow == null){
            responseMap.put("status","failure");
            responseMap.put("code", 4001);
            responseMap.put("message", "未借此书");
            response.getWriter().write(mapper.writeValueAsString(responseMap));
        }else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/safe/lendBookController");
            dispatcher.forward(request, response);
        }
        } else if (action.equals("renew")) {
            if(borrow == null){
                responseMap.put("status","failure");
                responseMap.put("code", 4001);
                responseMap.put("message", "未借此书");
                response.getWriter().write(mapper.writeValueAsString(responseMap));
            }else {
                responseMap.put("status","success");
                responseMap.put("code", 2000);
                responseMap.put("message", "已借此书");
                responseMap.put("borrow", borrow);
                response.getWriter().write(mapper.writeValueAsString(responseMap));
            }
        }else{
            //如果参数值不合法，返回错误页面
            responseMap.put("status","failure");
            responseMap.put("code", 1000);
            responseMap.put("message", "错误参数，请求失败");
            response.getWriter().write(mapper.writeValueAsString(responseMap));
        }
    }
}
