package com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.ReaderRowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.ReaderDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {
    private DaoUtils<Reader> daoUtils = new DaoUtils<Reader>();
    @Override
    public List<Reader> select(String name) {
        String sql = "select * from reader where name = ?;";
        List<Reader> list = daoUtils.commonsSelect(sql, new ReaderRowMapper(), name);
        if(!list.isEmpty()) {
            return list;
        }
        return null;
    }
}
