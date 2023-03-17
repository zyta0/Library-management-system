package com.yunze.LibraryManagementSystem.modules.evaluate.service;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;

import java.util.List;

public interface LabelService {
    public int insert(Label label);
    public int remove(Label label);
    public int update(Label label);
    public List<Label> select(String name);
    public Label select(int id);
    public List<Label> showAll();

}
