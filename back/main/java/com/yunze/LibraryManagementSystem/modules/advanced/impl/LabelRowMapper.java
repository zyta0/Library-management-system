package com.yunze.LibraryManagementSystem.modules.advanced.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelRowMapper implements RowMapper<Label> {
    @Override
    public Label getRow(ResultSet resultSet) {
        Label label = null;
        try{
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int view = resultSet.getInt("view");
            int cite = resultSet.getInt("cite");
            label = new Label(id, name, view, cite);
            return label;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
