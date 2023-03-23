package com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.LabelRowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.LabelDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;

import java.util.List;

public class LabelDaoImpl implements LabelDao {
    DaoUtils daoUtils = new DaoUtils();
    @Override
    public int insert(Label label) {
        String sql = "insert into label (id, name, view, cite) values(?,?,?,?);";
        Object[] args = {label.getId(), label.getName(), label.getView(), label.getCite()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(Label label) {
        String sql = "delete from label where id = ?;";
        Object[] args = {label.getId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public List<Label> select(String name) {
        String sql = "select * from label where name like ?;";
        List<Label> list = daoUtils.commonsSelect(sql, new LabelRowMapper(), "%" + name + "%");
        return list;
    }

    @Override
    public Label select(int id) {
        String sql = "select * from label where id = ?;";
        List<Label> list = daoUtils.commonsSelect(sql, new LabelRowMapper(), id);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int update(Label label) {
        String sql = "update label set name = ?, view = ?, cite = ? where id = ?;";
        Object[] args = {label.getName(), label.getView(), label.getCite(), label.getId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public List<Label> showAll() {
        String sql = "select * from label;";
        List<Label> list = daoUtils.commonsSelect(sql, new LabelRowMapper(), null);
        return list;
    }
}
