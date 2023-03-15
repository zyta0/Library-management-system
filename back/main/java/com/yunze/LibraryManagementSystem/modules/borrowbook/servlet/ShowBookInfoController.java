package com.yunze.LibraryManagementSystem.modules.borrowbook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.alibaba.fastjson.JSON;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BookService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

/**
 * 显示书籍详细信息
 */
@WebServlet(name = "showBookInfoController", value = "/showBookInfoController")
public class ShowBookInfoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //收参
        String str = request.getParameter("str");//书名或作者

        //只负责调用业务逻辑
        BookService service = new BookServiceImpl();
        List<Book> books = service.ShowBookInfo(str);
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("books", books);

        //响应
        java.util.Map<String, Object> responseMap = new HashMap<>();
        if(books != null){
            //找到书籍，返回状态码200
            response.setStatus(200);
            responseMap.put("status", "success");
            responseMap.put("code", 200);
            responseMap.put("message", "请求成功");

            responseMap.put("books", books);
        }else{
            //没找到书籍，状态码404
            response.setStatus(404);
            responseMap.put("status", "failure");
            responseMap.put("code", 404);
            responseMap.put("message", "未找到");
        }
        ObjectMapper mapper = new ObjectMapper();
        //创建DateFormat对象，设置日期格式
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(dateFormat);
        String JsonStr = mapper.writeValueAsString(responseMap);
        response.getWriter().write(JsonStr);
    }
}
