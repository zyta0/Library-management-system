package com.yunze.LibraryManagementSystem.modules.borrowbook.entity;

import com.yunze.LibraryManagementSystem.modules.login.entity.User;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Date;

public class Borrow extends User {
    private int readerId;
    private int bookId;
    private Date borrowDate;
    private Date due;

    public Borrow() {
    }

    public Borrow(int readerId, int bookId, Date borrowDate, Date due) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.due = due;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Override
    public String toString() {//toString()方法会将日期对象转换为默认格式的日期时间字符串如Mon Nov 02 00:00:00 CST 2020
        return "Borrow{" +
                "readerId=" + readerId +
                ", bookId=" + bookId +
                ", borrowDate=" + DataUtils.utilToStr(borrowDate) +
                ", due=" + DataUtils.utilToStr(due) +
                '}';
    }
}
