package com.yunze.LibraryManagementSystem.modules.follow.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.FollowRowMapper;
import com.yunze.LibraryManagementSystem.modules.follow.dao.FollowDao;
import com.yunze.LibraryManagementSystem.modules.follow.entity.Follow;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FollowDaoImpl implements FollowDao {
    DaoUtils daoUtils = new DaoUtils();
    @Override
    public List<Follow> showHot() {
        String sql = "select * from follow";
        List<Follow> list = daoUtils.commonsSelect(sql,new FollowRowMapper(),null);
        //降序，按粉丝量
        Collections.sort(list, new Comparator<Follow>() {
            @Override
            public int compare(Follow o1, Follow o2) {
                return fanCount(o2.getReaderId()) - fanCount(o1.getReaderId());
            }
        });
        return list;
    }

    @Override
    public int insert(Follow follow) {
        String sql = "insert into follow (reader_id, fan_id, follow_time) values(?,?,?);";
        Object[] args = {follow.getReaderId(), follow.getFanId(), DataUtils.utilToSql(follow.getFollowTime())};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(int readerId, int fanId) {
        String sql = "delete from follow where reader_id = ? and fan_id = ?";
        return daoUtils.commonsUpdate(sql, readerId, fanId);
    }



    @Override
    public List<Follow> selectFans(int readerId) {
        String sql = "select * from follow where reader_id = ?;";
        List<Follow> list = daoUtils.commonsSelect(sql, new FollowRowMapper(), readerId);
        return list;
    }

    @Override
    public List<Follow> selectFollows(int fanId) {
        String sql = "select * from follow where fan_id = ?;";
        List<Follow> list = daoUtils.commonsSelect(sql, new FollowRowMapper(), fanId);
        return list;
    }

    @Override
    public int fanCount(int readerId) {
        List<Follow> fans = this.selectFans(readerId);
        int count = 0;
        for(Follow follow : fans){
            count++;
        }
        return count;
    }

    @Override
    public int followCount(int fanId) {
        List<Follow> follows = this.selectFollows(fanId);
        int count = 0;
        for(Follow follow : follows){
            count++;
        }
        return count;
    }
}
