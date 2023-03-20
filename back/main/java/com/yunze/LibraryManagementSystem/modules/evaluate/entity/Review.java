package com.yunze.LibraryManagementSystem.modules.evaluate.entity;

import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Date;

public class Review {
    private int reviewId;
    private int evaluateId;
    private int readerId;
    private String review;
    private Date publishTime;
    private int view;
    private int praise;

    public Review() {
    }

    public Review(int evaluateId, int readerId, String review, Date publishTime, int view, int praise) {
        this.evaluateId = evaluateId;
        this.readerId = readerId;
        this.review = review;
        this.publishTime = publishTime;
        this.view = view;
        this.praise = praise;
    }

    public Review(int reviewId, int evaluateId, int readerId, String review, Date publishTime, int view, int praise) {
        this.reviewId = reviewId;
        this.evaluateId = evaluateId;
        this.readerId = readerId;
        this.review = review;
        this.publishTime = publishTime;
        this.view = view;
        this.praise = praise;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", evaluateId=" + evaluateId +
                ", readerId=" + readerId +
                ", review='" + review + '\'' +
                ", publishTime=" + DataUtils.utilToStr(publishTime) +
                ", view=" + view +
                ", praise=" + praise +
                '}';
    }
}
