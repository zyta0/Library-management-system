package com.yunze.LibraryManagementSystem.modules.evaluate.service;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Review;

import java.util.List;

public interface ReviewService {
    public int insert(Review review);//回复
    public int remove(Review review);//删除
    public int update(Review review);//改变浏览量，点赞量

    public List<Review> showAll(int readerId);//显示用户自己的所有回复

    public Review select(int reviewId);
}
