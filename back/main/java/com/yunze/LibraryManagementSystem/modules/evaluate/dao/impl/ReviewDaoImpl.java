package com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.EvaluateRowMapper;
import com.yunze.LibraryManagementSystem.modules.advanced.impl.ReviewRowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.ReaderDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.ReviewDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Review;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.List;

public class ReviewDaoImpl implements ReviewDao {
    DaoUtils<Review> daoUtils = new DaoUtils<>();
    @Override
    public int insert(Review review) {
        String sql = "insert into review (evaluate_id, reader_id, review, publish_time) values(?,?,?,?);";
        Object[] args = {review.getEvaluateId(), review.getReaderId(), review.getReview(), DataUtils.utilToSql(review.getPublishTime())};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(Review review) {
        String sql = "delete from review where review_id = ?;";
        Object[] args = {review.getReviewId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int update(Review review) {
        String sql = "update review set view = ?, praise = ? where review_id = ?;";
        Object[] args = {review.getView(), review.getPraise(), review.getReviewId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public List<Review> showAll(int readerId){
        String sql = "select * from review where reader_id = ?;";
        List<Review> list = daoUtils.commonsSelect(sql, new ReviewRowMapper(), readerId);
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @Override
    public Review select(int reviewId) {
        String sql = "select * from review where review_id = ?;";
        List<Review> list = daoUtils.commonsSelect(sql, new ReviewRowMapper(), reviewId);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
