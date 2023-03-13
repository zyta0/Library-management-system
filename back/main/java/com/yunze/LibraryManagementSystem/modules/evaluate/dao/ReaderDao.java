package com.yunze.LibraryManagementSystem.modules.evaluate.dao;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Reader;

import java.util.List;

public interface ReaderDao {
    public List<Reader> select(String name);

}
