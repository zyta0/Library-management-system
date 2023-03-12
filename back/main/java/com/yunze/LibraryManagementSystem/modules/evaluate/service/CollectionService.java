package com.yunze.LibraryManagementSystem.modules.evaluate.service;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Collection;

public interface CollectionService {
    public int collect(Collection collection);
    public int cancelCollect(int evaluateId, int readerId);
}
