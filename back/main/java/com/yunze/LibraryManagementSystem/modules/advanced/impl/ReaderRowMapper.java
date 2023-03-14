package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReaderRowMapper implements RowMapper<Reader> {
    @Override
    public Reader getRow(ResultSet resultSet) {
        Reader reader = null;
        try{
            int readerId = resultSet.getInt("reader_id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            String telephone = resultSet.getString("telephone");
            String email = resultSet.getString("email");
            String dept = resultSet.getString("dept");
            Integer status = resultSet.getInt("status");
            int readerType = resultSet.getInt("reader_type");
            String demo = resultSet.getString("demo");
            reader = new Reader(readerId, name, password, telephone, email, dept, status, readerType, demo);
            return reader;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
