package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class BorrowRowMapper implements RowMapper<Borrow> {
    @Override
    public Borrow getRow(ResultSet resultSet) {
        Borrow borrow = null;
        try{
            int readerId = resultSet.getInt("reader_id");
            int bookId = resultSet.getInt("book_id");
            Date borrowDate = resultSet.getDate("borrow_date");//sql.Date  是  util.Date  的子类
            Date due = resultSet.getDate("due");
            borrow = new Borrow(readerId, bookId, borrowDate, due);
            return borrow;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
