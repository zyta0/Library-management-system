package com.yunze.LibraryManagementSystem.modules.evaluate.dao;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Review;

import java.util.List;


public interface ReviewDao {
    public int insert(Review review);
    public int remove(Review review);
    public int update(Review review);
    public List<Review> showAll(int readerId);
    public Review select(int reviewId);
}
