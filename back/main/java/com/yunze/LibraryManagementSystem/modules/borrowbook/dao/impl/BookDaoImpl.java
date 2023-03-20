package com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl;

import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BookDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.advanced.impl.BookRowMapper;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.List;

public class BookDaoImpl implements BookDao {
    private DaoUtils<Book> daoUtils = new DaoUtils<Book>();


    @Override
    public List<Book> select(String str) {
        List<Book> list = null;
        String sql = "select * from book where name = ?;";
        list = daoUtils.commonsSelect(sql, new BookRowMapper(), str);
        if(!list.isEmpty()) {
            return list;
        }
        sql = "select * from book where author = ?;";
        list = daoUtils.commonsSelect(sql, new BookRowMapper(), str);
        if(!list.isEmpty()) {
            return list;
        }
        return null;
    }
    @Override
    public Book selectById(int id) {
        String sql = "select * from book where id = ?;";
        List<Book> list = daoUtils.commonsSelect(sql, new BookRowMapper(), id);
        if(!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }



    @Override
    public int insert(Book book) {
        String sql = "insert into book (author, isbn, name, publish_time, pages, account, type, introduce, evaluate) values(?,?,?,?,?,?,?,?,?);";
        Object[] args = {book.getAuthor(), book.getIsbn(), book.getName(),DataUtils.utilToSql(book.getPublishTime()), book.getPages(), book.getAccount(), book.getType(),book.getIntroduce(),book.getEvaluate()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int delete(int id) {
        String sql = "delete from book where id = ?";
        return daoUtils.commonsUpdate(sql, id);
    }

    @Override
    public int update(Book book) {
        String sql = "update book set author = ?, isbn = ?, name = ?, publish_time = ?, pages = ?, account = ?, type = ?, introduce = ?, evaluate = ? where id = ?;";
        Object[] args = {book.getAuthor(), book.getIsbn(), book.getName(),DataUtils.utilToSql(book.getPublishTime()), book.getPages(), book.getAccount(), book.getType(),book.getIntroduce(),book.getEvaluate(), book.getId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public List<Book> selectAll() {
        String sql = "select * from book";
        List<Book> list = daoUtils.commonsSelect(sql,new BookRowMapper(), null);
        return list;
    }

}
