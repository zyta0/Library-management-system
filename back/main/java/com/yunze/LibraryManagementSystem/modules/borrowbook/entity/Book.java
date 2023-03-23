package com.yunze.LibraryManagementSystem.modules.borrowbook.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Date;

public class Book {
    private int id;
    private String author;
    private String isbn;
    private String name;
    private Date publishTime;
    private String image;
    private int pages;
    private int account;
    private String type;
    private String introduce;
    private String evaluate;

    public Book() {
    }

    public Book(int id, String author, String isbn, String name, Date publishTime, String image, int pages, int account, String type, String introduce, String evaluate) {
        this.id = id;
        this.author = author;
        this.isbn = isbn;
        this.name = name;
        this.publishTime = publishTime;
        this.image = image;
        this.pages = pages;
        this.account = account;
        this.type = type;
        this.introduce = introduce;
        this.evaluate = evaluate;
    }

    public Book(String author, String isbn, String name, Date publishTime, String image, int pages, int account, String type, String introduce, String evaluate) {
        this.author = author;
        this.isbn = isbn;
        this.name = name;
        this.publishTime = publishTime;
        this.image = image;
        this.pages = pages;
        this.account = account;
        this.type = type;
        this.introduce = introduce;
        this.evaluate = evaluate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", publishTime=" + DataUtils.utilToStr(publishTime) +
                ", image='" + image + '\'' +
                ", pages=" + pages +
                ", account=" + account +
                ", type='" + type + '\'' +
                ", introduce='" + introduce + '\'' +
                ", evaluate='" + evaluate + '\'' +
                '}';
    }
}
