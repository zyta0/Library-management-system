package com.yunze.LibraryManagementSystem.modules.borrowbook.json;

import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;

public class RenewRequest {
    private Borrow borrow;
    private String due;

    public RenewRequest() {
    }

    public RenewRequest(Borrow borrow, String due) {
        this.borrow = borrow;
        this.due = due;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "RenewRequest{" +
                "borrow=" + borrow +
                ", due='" + due + '\'' +
                '}';
    }
}
