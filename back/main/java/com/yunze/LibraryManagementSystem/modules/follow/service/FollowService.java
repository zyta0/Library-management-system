package com.yunze.LibraryManagementSystem.modules.follow.service;

import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;

import java.util.List;

public interface FollowService {
    public List<Follow> showHot();
    public int follow(Follow follow);//关注功能
    public int unfollow(int readerId, int fanId);//取关功能
    public List<Follow> selectFans(int readerId);//查看粉丝功能
    public List<Follow> selectFollows(int fanId);//查看关注功能
    public int fanCount(int readerId);//查看粉丝数
    public int followCount(int fanId);//查看关注数
}
