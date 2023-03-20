package com.yunze.LibraryManagementSystem.modules.evaluate.entity;

import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Date;

public class Evaluate {
    private int evaluateId;
    private int readerId;
    private int bookId;
    private Date publishTime;
    private String evaluate;
    private int view;
    private int praise;
    private int collection;
    private int share;
    private int review;
    private Integer quintessence;//1是精华
    private int labelId;

    public Evaluate() {
    }

    public Evaluate(int reviewId, int evaluateId, int readerId, String review, Date publishTime, int view, int praise) {
    }

    public Evaluate(int readerId, int bookId, String evaluate, int labelId) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.evaluate = evaluate;
        this.labelId = labelId;
    }

    public Evaluate(int evaluateId, int readerId, int bookId, Date publishTime, String evaluate, int view, int praise, int collection, int share, int review, Integer quintessence, int labelId) {
        this.evaluateId = evaluateId;
        this.readerId = readerId;
        this.bookId = bookId;
        this.publishTime = publishTime;
        this.evaluate = evaluate;
        this.view = view;
        this.praise = praise;
        this.collection = collection;
        this.share = share;
        this.review = review;
        this.quintessence = quintessence;
        this.labelId = labelId;
    }

    public Evaluate(int readerId, int bookId, Date publishTime, String evaluate, int view, int praise, int collection, int share, int review, Integer quintessence, int labelId) {
        this.readerId = readerId;
        this.bookId = bookId;
        this.publishTime = publishTime;
        this.evaluate = evaluate;
        this.view = view;
        this.praise = praise;
        this.collection = collection;
        this.share = share;
        this.review = review;
        this.quintessence = quintessence;
        this.labelId = labelId;
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

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(String evaluate) {
        this.evaluate = evaluate;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public int getPraise() {
        return praise;
    }

    public void setPraise(int praise) {
        this.praise = praise;
    }

    public int getCollection() {
        return collection;
    }

    public void setCollection(int collection) {
        this.collection = collection;
    }

    public Integer getQuintessence() {
        return quintessence;
    }

    public void setQuintessence(Integer quintessence) {
        this.quintessence = quintessence;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    @Override
    public String toString() {
        if(publishTime == null){
            return "Evaluate{" +
                    "evaluateId=" + evaluateId +
                    ", readerId=" + readerId +
                    ", bookId=" + bookId +
                    ", publishTime=" + null +
                    ", evaluate='" + evaluate + '\'' +
                    ", view=" + view +
                    ", praise=" + praise +
                    ", collection=" + collection +
                    ", share=" + share +
                    ", review=" + review +
                    ", quintessence=" + quintessence +
                    ", labelId=" + labelId +
                    '}';
        }
        return "Evaluate{" +
                "evaluateId=" + evaluateId +
                ", readerId=" + readerId +
                ", bookId=" + bookId +
                ", publishTime=" + DataUtils.utilToStr(publishTime) +
                ", evaluate='" + evaluate + '\'' +
                ", view=" + view +
                ", praise=" + praise +
                ", collection=" + collection +
                ", share=" + share +
                ", review=" + review +
                ", quintessence=" + quintessence +
                ", labelId=" + labelId +
                '}';
    }
}
