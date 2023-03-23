package com.yunze.LibraryManagementSystem.modules.evaluate.service.impl;

import com.yunze.LibraryManagementSystem.modules.evaluate.dao.LabelDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl.LabelDaoImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Label;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.LabelService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

import java.util.List;

public class LabelServiceImpl implements LabelService {
    LabelDao labelDao = new LabelDaoImpl();
    @Override
    public int insert(Label label) {
        int result = 0;
        try {
            DBUtils.begin();
            result = labelDao.insert(label);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int remove(Label label) {
        int result = 0;
        try {
            DBUtils.begin();
            result = labelDao.remove(label);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int update(Label label) {
        int result = 0;
        try {
            DBUtils.begin();
            result = labelDao.update(label);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Label> select(String name) {
        List<Label> labels = null;
        try {
            DBUtils.begin();
            labels = labelDao.select(name);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return labels;
    }

    @Override
    public Label select(int id) {
        Label label = null;
        try {
            DBUtils.begin();
            label = labelDao.select(id);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return label;
    }

    @Override
    public List<Label> showAll() {
        List<Label> list = null;
        try{
            DBUtils.begin();
            list = labelDao.showAll();
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return list;
    }
}
