package com.yunze.LibraryManagementSystem.modules.login.service;

import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;

public interface ReaderService {
    public Reader login(String username, String password);
}
