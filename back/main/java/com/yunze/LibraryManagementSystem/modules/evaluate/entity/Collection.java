package com.yunze.LibraryManagementSystem.modules.evaluate.entity;

import java.util.Date;

public class Collection {
    private int evaluateId;
    private int readerId;
    private Date collectTime;

    public Collection() {
    }

    public Collection(int evaluateId, int readerId, Date collectTime) {
        this.evaluateId = evaluateId;
        this.readerId = readerId;
        this.collectTime = collectTime;
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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }

    @Override
    public String toString() {
        return "Collection{" +
                "evaluateId=" + evaluateId +
                ", readerId=" + readerId +
                ", collectTime=" + collectTime +
                '}';
    }
}
