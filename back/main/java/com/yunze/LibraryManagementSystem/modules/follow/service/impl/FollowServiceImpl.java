package com.yunze.LibraryManagementSystem.modules.follow.service.impl;

import com.yunze.LibraryManagementSystem.modules.follow.dao.FollowDao;
import com.yunze.LibraryManagementSystem.modules.follow.dao.impl.FollowDaoImpl;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;
import com.yunze.LibraryManagementSystem.modules.follow.service.FollowService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;

import java.util.List;

public class FollowServiceImpl implements FollowService {
    FollowDao followDao = new FollowDaoImpl();
    @Override
    public List<Follow> showHot() {
        List<Follow> follows =  null;
        try {
            DBUtils.begin();
            follows = followDao.showHot();
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return follows;
    }

    @Override
    public int follow(Follow follow) {
        int result = 0;
        try{
            DBUtils.begin();
            result = followDao.insert(follow);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int unfollow(int readerId, int fanId) {
        int result = 0;
        try{
            DBUtils.begin();
            result = followDao.remove(readerId, fanId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Follow> selectFans(int readerId) {
        List<Follow> fans =  null;
        try {
            DBUtils.begin();
            fans = followDao.selectFans(readerId);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return fans;
    }

    @Override
    public List<Follow> selectFollows(int fanId) {
        List<Follow> follows =  null;
        try {
            DBUtils.begin();
            follows = followDao.selectFollows(fanId);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return follows;
    }

    @Override
    public int fanCount(int readerId) {
        int result = 0;
        try{
            DBUtils.begin();
            result = followDao.fanCount(readerId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int followCount(int fanId) {
        int result = 0;
        try{
            DBUtils.begin();
            result = followDao.followCount(fanId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
