package com.yunze.LibraryManagementSystem.modules.follow.entity;

import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Date;

public class Follow {
    private int readerId;
    private int fanId;
    private Date followTime;

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public int getFanId() {
        return fanId;
    }

    public void setFanId(int fanId) {
        this.fanId = fanId;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Follow() {
    }

    public Follow(int readerId, int fanId, Date followTime) {
        this.readerId = readerId;
        this.fanId = fanId;
        this.followTime = followTime;
    }

    @Override
    public String toString() {
        return "Follow{" +
                "readerId=" + readerId +
                ", fanId=" + fanId +
                ", followTime=" + DataUtils.utilToStr(followTime) +
                '}';
    }
}
