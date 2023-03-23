package com.yunze.LibraryManagementSystem.modules.borrowbook.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;

import java.util.Date;

public class BorrowRequest {

    private Book book;
    private String borrowDate;
    private String due;

    public BorrowRequest() {
    }

    public BorrowRequest(Book book, String borrowDate, String due) {
        this.book = book;
        this.borrowDate = borrowDate;
        this.due = due;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "BorrowRequest{" +
                "book=" + book +
                ", borrowDate='" + borrowDate + '\'' +
                ", due='" + due + '\'' +
                '}';
    }
}