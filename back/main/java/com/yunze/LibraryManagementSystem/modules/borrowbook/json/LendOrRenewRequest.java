package com.yunze.LibraryManagementSystem.modules.borrowbook.json;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;

public class LendOrRenewRequest {
    private String action;
    private Book book;

    public LendOrRenewRequest() {
    }

    public LendOrRenewRequest(String action, Book book) {
        this.action = action;
        this.book = book;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "LendOrRenewRequest{" +
                "action='" + action + '\'' +
                ", book=" + book +
                '}';
    }
}
