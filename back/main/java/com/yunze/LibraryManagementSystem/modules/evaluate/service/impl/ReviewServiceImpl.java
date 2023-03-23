package com.yunze.LibraryManagementSystem.modules.evaluate.service.impl;

import com.yunze.LibraryManagementSystem.modules.evaluate.dao.ReviewDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl.ReviewDaoImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Review;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.ReviewService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    ReviewDao reviewDao = new ReviewDaoImpl();
    @Override
    public int insert(Review review) {
        int result = 0;
        try{
            DBUtils.begin();
            result = reviewDao.insert(review);
            DBUtils.commit();
        }catch(Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(Review review) {
        int result = 0;
        try{
            DBUtils.begin();
            result = reviewDao.remove(review);
            DBUtils.commit();
        }catch(Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Review review) {
        int result = 0;
        try{
            DBUtils.begin();
            result = reviewDao.update(review);
            DBUtils.commit();
        }catch(Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Review> showAll(int readerId) {
        List<Review> reviews = null;
        try{
            DBUtils.begin();
            reviews = reviewDao.showAll(readerId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review select(int reviewId) {
        Review review = null;
        try{
            DBUtils.begin();
            review = reviewDao.select(reviewId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return review;
    }
}
