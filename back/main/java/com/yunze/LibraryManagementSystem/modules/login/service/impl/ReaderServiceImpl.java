package com.yunze.LibraryManagementSystem.modules.login.service.impl;

import com.yunze.LibraryManagementSystem.modules.login.dao.ReaderDao;
import com.yunze.LibraryManagementSystem.modules.login.dao.impl.ReaderDaoImpl;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.login.service.ReaderService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

public class ReaderServiceImpl implements ReaderService {
    ReaderDao readerDao = new ReaderDaoImpl();
    @Override
    public Reader login(String username, String password) {
        Reader reader = null;
        try {
            DBUtils.begin();
            Reader temp = readerDao.select(username);
            if(temp != null){
                if(temp.getPassword().equals(password)){
                    reader = temp;
                }
            }
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return reader;
    }
}
