package com.yunze.LibraryManagementSystem.modules.borrowbook.service;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;

public interface BorrowService {
    public int borrowBook(Borrow borrow);
    public int lendBook(Borrow borrow);
    public int renewBook(Borrow borrow);

    public Borrow select(int readId, int bookId);

}
