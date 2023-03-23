package com.yunze.LibraryManagementSystem.modules.evaluate.dao;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;

import java.util.List;

public interface LabelDao {
    public int insert(Label label);
    public int remove(Label label);
    public List<Label> select(String name);
    public Label select(int id);
    public int update(Label label);
    public List<Label> showAll();
}
