package com.yunze.LibraryManagementSystem.modules.evaluate.dao;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Collection;

public interface CollectionDao {
    public int insert(Collection collection);
    public int remove(int evaluateId, int readerId);
}
