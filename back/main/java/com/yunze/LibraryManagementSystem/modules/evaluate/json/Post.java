package com.yunze.LibraryManagementSystem.modules.evaluate.json;

public class Post {
    private int bookId;
    private String evaluate;
    private int labelId;

    public Post() {
    }

    public Post(int bookId, String evaluate, int labelId) {
        this.bookId = bookId;
        this.evaluate = evaluate;
        this.labelId = labelId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    @Override
    public String toString() {
        return "Post{" +
                "bookId=" + bookId +
                ", evaluate='" + evaluate + '\'' +
                ", labelId=" + labelId +
                '}';
    }
}
