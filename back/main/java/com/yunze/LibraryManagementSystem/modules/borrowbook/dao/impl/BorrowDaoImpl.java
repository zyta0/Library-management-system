package com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl;

import com.yunze.LibraryManagementSystem.modules.advanced.impl.BorrowRowMapper;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BorrowDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Borrow;
import com.yunze.LibraryManagementSystem.modules.utils.DaoUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.List;

public class BorrowDaoImpl implements BorrowDao {
    DaoUtils<Borrow> daoUtils = new DaoUtils<Borrow>();

    @Override
    public int insert(Borrow borrow) {
        String sql = "insert into borrow (reader_id, book_id, borrow_date, due) values(?,?,?,?);";
        Object[] args = {borrow.getReaderId(), borrow.getBookId(), DataUtils.utilToSql(borrow.getBorrowDate()), DataUtils.utilToSql(borrow.getDue())};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public int remove(Borrow borrow) {
        String sql = "delete from borrow where reader_id = ? and book_id = ?;";
        Object[] args = {borrow.getReaderId(), borrow.getBookId()};
        return daoUtils.commonsUpdate(sql, args);
    }

    @Override
    public Borrow select(int readId, int bookId) {
        String sql = "select * from borrow where reader_id = ? and book_id = ?;";
        List<Borrow> list = daoUtils.commonsSelect(sql, new BorrowRowMapper(), readId, bookId);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public int update(Borrow borrow) {
        String sql = "update borrow set due = ? where reader_id = ? and book_id = ?;";
        Object[] args = {DataUtils.utilToSql(borrow.getDue()), borrow.getReaderId(), borrow.getBookId()};
        return daoUtils.commonsUpdate(sql, args);

    }
}
