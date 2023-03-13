package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class FollowRowMapper implements RowMapper<Follow> {
    @Override
    public Follow getRow(ResultSet resultSet) {
        Follow follow = null;
        try{
            int readerId = resultSet.getInt("reader_id");
            int fanId = resultSet.getInt("fan_id");
            Date followTime = resultSet.getDate("follow_time");
            follow = new Follow(readerId, fanId, followTime);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return follow;
    }
}
