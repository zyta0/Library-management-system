package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Review;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ReviewRowMapper implements RowMapper<Review> {
    @Override
    public Review getRow(ResultSet resultSet) {
        Review rw = null;
        try{
            int reviewId = resultSet.getInt("review_id");
            int evaluateId = resultSet.getInt("evaluate_id");
            int readerId = resultSet.getInt("reader_id");
            Date publishTime = resultSet.getDate("publish_time");//sql.Date  是  util.Date  的子类
            String review = resultSet.getString("review");
            int view = resultSet.getInt("view");
            int praise = resultSet.getInt("praise");
            rw = new Review(reviewId, evaluateId, readerId, review, publishTime, view, praise);
            return rw;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
