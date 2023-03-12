package com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.EvaluateRowMapper;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.EvaluateDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.List;

public class EvaluateDaoImpl implements EvaluateDao {
    DaoUtils<Evaluate> daoUtils = new DaoUtils<Evaluate>();
    @Override
    public int insert(Evaluate evaluate) {
        String sql = "insert into evaluate (reader_id, book_id, publish_time, evaluate, label_id) values(?,?,?,?,?);";
        Object[] args = {evaluate.getReaderId(), evaluate.getBookId(), DataUtils.utilToSql(evaluate.getPublishTime()), evaluate.getEvaluate(), evaluate.getLabelId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(int evaluateId) {
        String sql = "delete from evaluate where evaluate_id = ?;";
        Object[] args = {evaluateId};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public List<Evaluate> select(int id) {
        String sql = "select * from evaluate where reader_id = ? or book_id = ?;";
        List<Evaluate> list = daoUtils.commonsSelect(sql, new EvaluateRowMapper(), id, id);
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }

    @Override
    public Evaluate search(int evaluateId){
        String sql = "select * from evaluate where evaluate_id = ?;";
        List<Evaluate> list = daoUtils.commonsSelect(sql, new EvaluateRowMapper(), evaluateId);
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
    @Override
    public int update(Evaluate evaluate) {
        String sql = "update evaluate set evaluate = ?, view = ?, praise = ?, collection = ?, share = ?, review = ?, quintessence = ?, label_id = ? where evaluate_id = ?;";
        Object[] args = {evaluate.getEvaluate(), evaluate.getView(), evaluate.getPraise(), evaluate.getCollection(), evaluate.getShare(), evaluate.getReview(), evaluate.getQuintessence(),evaluate.getLabelId(),evaluate.getEvaluateId()};
        return daoUtils.commonsUpdate(sql, args);

    }

    @Override
    public List<Evaluate> selectAll() {
        String sql = "select * from evaluate";
        List<Evaluate> list = daoUtils.commonsSelect(sql,new EvaluateRowMapper(),null);
        return list;
    }

    @Override
    public List<Evaluate> selectByLabel(int labelId){
        String sql = "select * from evaluate where label_id = ?;";
        List<Evaluate> list = daoUtils.commonsSelect(sql, new EvaluateRowMapper(), labelId);
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }
}
