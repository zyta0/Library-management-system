package com.yunze.LibraryManagementSystem.modules.borrowbook.dao;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;

public interface BorrowDao {

    public int insert(Borrow borrow);
    public int remove(Borrow borrow);
    public Borrow select(int readId, int bookId);
    public int update(Borrow borrow);

}
