package com.yunze.LibraryManagementSystem.modules.utils;

import com.yunze.LibraryManagementSystem.modules.advanced.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *  复用增、删、改、查方法，避免代码冗余
 */
public class DaoUtils <T>{
    /**
     * 公共处理增、删、改的方法
     *
     * @param sql  执行SQL语句
     * @param args 参数列表
     * @return 受影响的行数
     */
    public int commonsUpdate(String sql, Object... args) {//参数列表数目、类型不固定：可变长参数列表
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        connection = DBUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            int result = preparedStatement.executeUpdate();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.closeAll(null, preparedStatement, null);
        }
        return 0;
    }

    /**
     * 公共的查询方法（可查询任意一张表、可查询单个对象或多个对象）
     *
     * @param sql  执行的SQL语句
     * @param args 参数列表
     * @return 集合
     *
     */
    public List<T> commonsSelect(String sql, RowMapper<T> rowMapper, Object... args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<T> list = new ArrayList<>();

        connection = DBUtils.getConnection();
        try {
            preparedStatement = connection.prepareStatement(sql);
            if(args != null) {
                for (int i = 0; i < args.length; i++) {
                    preparedStatement.setObject(i + 1, args[i]);
                }
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //调用者负责创建具体的对象和赋值
                T t = rowMapper.getRow(resultSet);//回调——>调用者提供的一个封装方法，getRow()完成ORM映射和封装
                list.add(t);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}