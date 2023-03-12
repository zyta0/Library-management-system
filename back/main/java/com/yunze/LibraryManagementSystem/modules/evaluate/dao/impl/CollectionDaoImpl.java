package com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl;

import com.yunze.LibraryManagementSystem.modules.evaluate.dao.CollectionDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Collection;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

public class CollectionDaoImpl implements CollectionDao {
    DaoUtils<Collection> daoUtils = new DaoUtils<>();
    @Override
    public int insert(Collection collection) {
        String sql = "insert into collection (evaluate_id, reader_id, collect_time) values(?,?,?);";
        Object[] args = {collection.getEvaluateId(), collection.getReaderId(), DataUtils.utilToSql(collection.getCollectTime())};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(int evaluateId, int readerId) {
        String sql = "delete from collection where evaluate_id = ? and reader_id = ?;";
        Object[] args = {evaluateId, readerId};
        return daoUtils.commonsUpdate(sql, args);
    }
}
