package com.yunze.LibraryManagementSystem.modules.borrowbook.dao;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> select(String str);

    Book selectById(int id);

    int insert(Book book);

    int delete(int id);

    int update(Book book);

    List<Book> selectAll();
}
