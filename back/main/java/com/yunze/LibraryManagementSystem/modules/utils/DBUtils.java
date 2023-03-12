package com.yunze.LibraryManagementSystem.modules.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 创建连接池
 * 获得连接对象
 * 控制事务
 * 释放资源
 *
 */


public class DBUtils {
    private static DruidDataSource ds;//声明连接池对象
    private static final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();//创建一个在单线程中可以共享同一个Connection的ThreadLocal对象
    static {
        Properties properties = new Properties();
        InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("database.properties");
        try {
            properties.load(inputStream);//通过流，将配置文件内容以键值对的形式保存到properties集合
            ds = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //获得连接对象
    public static Connection getConnection(){
        Connection connection = threadLocal.get();
            try {
                if(connection == null) {
                    connection = ds.getConnection();
                    threadLocal.set(connection);
                }
            } catch (SQLException e) {
                 e.printStackTrace();
            }
            return connection;
        }

        //开启事务
        public static void begin(){
        Connection connection = null;
            try {
                connection = getConnection();
                connection.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        //提交事务
    public static void commit(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }

    //回滚事务
    public static void rollback(){
        Connection connection = null;
        try {
            connection = getConnection();
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,null,null);
        }
    }

    //释放资源
    public static void closeAll(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
