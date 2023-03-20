package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BookRowMapper implements RowMapper<Book> {
    @Override
    public Book getRow(ResultSet resultSet) {
        Book book = null;
        try{
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String isbn = resultSet.getString("isbn");
            String name = resultSet.getString("name");
            Date publishTime = resultSet.getDate("publish_time");//sql.Date  是  util.Date  的子类
            int pages = resultSet.getInt("pages");
            int account = resultSet.getInt("account");
            String type = resultSet.getString("type");
            String introduce = resultSet.getString("introduce");
            String evaluate = resultSet.getString("evaluate");
            book = new Book(id, author, isbn, name, publishTime, pages, account, type, introduce, evaluate);
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}