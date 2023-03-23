package com.yunze.LibraryManagementSystem.modules.follow.dao;

import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;

import java.util.List;

public interface FollowDao {
    public List<Follow> showHot();
    public int insert(Follow follow);
    public int remove(int readerId, int fanId);
    public List<Follow> selectFans(int readerId);//查看粉丝
    public List<Follow> selectFollows(int fanId);//查看关注

    public int fanCount(int readerId);//查看粉丝数
    public int followCount(int fanId);//查看关注数
}
