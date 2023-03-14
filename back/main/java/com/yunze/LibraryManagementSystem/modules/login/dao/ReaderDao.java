package com.yunze.LibraryManagementSystem.modules.login.dao;

import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;

import java.util.List;

public interface ReaderDao {
    public Reader select(String name);

}
