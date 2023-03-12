package com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BookService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BookDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl.BookDaoImpl;

import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

import java.util.List;


public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public List<Book> ShowBookInfo(String str) {
        List<Book> books = null;
        try {
            DBUtils.begin();
            books = bookDao.select(str);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public List<Book> showAllBook() {
        List<Book> books = null;
        try {
            DBUtils.begin();
            books = bookDao.selectAll();
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return books;
    }

    @Override
    public int removeBook(int id) {
        int result = 0;
        try {
            DBUtils.begin();
            result = bookDao.delete(id);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modify(Book book) {
        int result = 0;
        try {
            DBUtils.begin();
            result = bookDao.update(book);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int add(Book book) {
        int result = 0;
        try {
            DBUtils.begin();
            result = bookDao.insert(book);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
