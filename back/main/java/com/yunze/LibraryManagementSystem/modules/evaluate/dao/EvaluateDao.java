package com.yunze.LibraryManagementSystem.modules.evaluate.dao;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;

import java.util.List;

public interface EvaluateDao {
    public int insert(Evaluate evaluate);
    public int remove(int evaluateId);
    public List<Evaluate> select(int id);//读者/书的id
    public Evaluate search(int evaluateId);
    public int update(Evaluate evaluate);
    public List<Evaluate> selectAll();
    public List<Evaluate> selectByLabel(int label);
}
