package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EvaluateRowMapper implements RowMapper<Evaluate> {
    @Override
    public Evaluate getRow(ResultSet resultSet) {
        Evaluate ev = null;
        try{
            int evaluateId = resultSet.getInt("evaluate_id");
            int readerId = resultSet.getInt("reader_id");
            int bookId = resultSet.getInt("book_id");
            Date publishTime = resultSet.getDate("publish_time");//sql.Date  是  util.Date  的子类
            String evaluate = resultSet.getString("evaluate");
            int view = resultSet.getInt("view");
            int praise = resultSet.getInt("praise");
            int collection = resultSet.getInt("collection");
            int share = resultSet.getInt("share");
            int review = resultSet.getInt("review");
            int quintessence = resultSet.getInt("quintessence");
            int labelId = resultSet.getInt("label_id");
            ev = new Evaluate(evaluateId,readerId, bookId,publishTime, evaluate, view, praise, collection, share, review, quintessence, labelId);
            return ev;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
