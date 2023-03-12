package com.yunze.LibraryManagementSystem.modules.evaluate.service.impl;

import com.yunze.LibraryManagementSystem.modules.evaluate.dao.CollectionDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl.CollectionDaoImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Collection;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.CollectionService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

public class CollectionServiceImpl implements CollectionService {
    CollectionDao collectionDao = new CollectionDaoImpl();
    @Override
    public int collect(Collection collection) {
        int result = 0;
        try {
            DBUtils.begin();
            result = collectionDao.insert(collection);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int cancelCollect(int evaluateId, int readerId) {
        int result = 0;
        try {
            DBUtils.begin();
            result = collectionDao.remove(evaluateId, readerId);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
