package com.yunze.LibraryManagementSystem.modules.borrowbook.service.impl;

import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BookDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BorrowDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl.BorrowDaoImpl;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.borrowbook.service.BorrowService;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl.BookDaoImpl;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

public class BorrowServiceImpl implements BorrowService {

    BorrowDao borrowDao = new BorrowDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    @Override
    public int borrowBook(Borrow borrow) {
        int result = 0;
        int isUpdate = 0;
        try {
            DBUtils.begin();
            result = borrowDao.insert(borrow);
            if(result != 0) {
                Book book = bookDao.selectById(borrow.getBookId());
                book.setAccount(book.getAccount() - 1);
                isUpdate = bookDao.update(book);
            }
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return isUpdate;
    }

    @Override
    public int lendBook(Borrow borrow) {
        int result = 0;
        int isUpdate = 0;
        try {
            DBUtils.begin();
            result = borrowDao.remove(borrow);
            if(result != 0){
                Book book = bookDao.selectById(borrow.getBookId());
                book.setAccount(book.getAccount() + 1);
                isUpdate = bookDao.update(book);
            }
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return isUpdate;
    }

    public int renewBook(Borrow borrow){
        int result = 0;
        try {
            DBUtils.begin();
            result = borrowDao.update(borrow);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }




    @Override
    public Borrow select(int readId, int bookId){
        Borrow borrow = null;
        try {
            DBUtils.begin();
            borrow = borrowDao.select(readId, bookId);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return borrow;
    }

}
