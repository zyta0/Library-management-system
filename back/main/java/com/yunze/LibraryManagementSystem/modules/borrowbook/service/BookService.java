package com.yunze.LibraryManagementSystem.modules.borrowbook.service;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> ShowBookInfo(String str);//通过书名或作者查询
    public List<Book> showAllBook();
    public int add(Book book);
    public int modify(Book book);
    public int removeBook(int id);
}
