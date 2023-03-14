package com.yunze.LibraryManagementSystem.modules.evaluate.service.impl;

import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.BookDao;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.EvaluateDao;
import com.yunze.LibraryManagementSystem.modules.login.dao.ReaderDao;
import com.yunze.LibraryManagementSystem.modules.borrowbook.dao.impl.BookDaoImpl;
import com.yunze.LibraryManagementSystem.modules.evaluate.dao.impl.EvaluateDaoImpl;
import com.yunze.LibraryManagementSystem.modules.login.dao.impl.ReaderDaoImpl;
import com.yunze.LibraryManagementSystem.modules.borrowbook.entity.Book;
import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;
import com.yunze.LibraryManagementSystem.modules.login.entity.Reader;
import com.yunze.LibraryManagementSystem.modules.evaluate.service.EvaluateService;
import com.yunze.LibraryManagementSystem.modules.utils.DBUtils;
import com.yunze.LibraryManagementSystem.modules.utils.DataUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EvaluateServiceImpl implements EvaluateService {
    EvaluateDao evaluateDao = new EvaluateDaoImpl();
    BookDao bookDao = new BookDaoImpl();
    ReaderDao readerDao = new ReaderDaoImpl();
    @Override
    public List<Evaluate> show(String str) {
            List<Evaluate> evaluates = new ArrayList<>();
        try {
            DBUtils.begin();
            List<Book> books = bookDao.select(str);
            List<Evaluate> evaluates1;
            if(books != null) {//根据书名查
                for (Book book1 : books) {
                    evaluates1 = evaluateDao.select(book1.getId());
                    evaluates.addAll(evaluates1);
                }
            }
            Reader reader = readerDao.select(str);
            List<Evaluate> evaluates2 = null;
            if(reader != null) {//根据用户名查
                evaluates2 = evaluateDao.select(reader.getReaderId());
                evaluates.addAll(evaluates2);
            }
            //降序排序，按时间
            Collections.sort(evaluates, new Comparator<Evaluate>() {
                @Override
                public int compare(Evaluate o1, Evaluate o2) {
                    return DataUtils.utilToStr(o2.getPublishTime()).compareTo(DataUtils.utilToStr(o1.getPublishTime()));
                }
            });
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluates;
    }

    @Override
    public Evaluate search(int evaluateId) {
        Evaluate evaluate = null;
        try{
            DBUtils.begin();
            evaluate = evaluateDao.search(evaluateId);
            DBUtils.commit();
        }catch (Exception e){
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluate;
    }

    @Override
    public List<Evaluate> showByTime() {
        List<Evaluate> evaluates =  null;
        try {
            DBUtils.begin();
            evaluates = evaluateDao.selectAll();
            //降序排序，按时间
            Collections.sort(evaluates, new Comparator<Evaluate>() {
                @Override
                public int compare(Evaluate o1, Evaluate o2) {
                    return DataUtils.utilToStr(o2.getPublishTime()).compareTo(DataUtils.utilToStr(o1.getPublishTime()));
                }
            });
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluates;
    }

    @Override
    public List<Evaluate> showHot() {
        List<Evaluate> evaluates =  null;
        try {
            DBUtils.begin();
            evaluates = evaluateDao.selectAll();
            //降序排序，按热度:点赞数*0.3 + 收藏数*0.2 + 评论数*0.2 +分享数*0.1 + 浏览数*0.2
            Collections.sort(evaluates, new Comparator<Evaluate>() {
                @Override
                public int compare(Evaluate o1, Evaluate o2) {
                    return (3*o2.getPraise() + 2*o2.getCollection() + 2*o2.getReview() +o2.getShare() + 2*o2.getView()) - (3*o1.getPraise() + 2*o1.getCollection() + 2*o1.getReview() +o1.getShare() + 2*o1.getView());
                }
            });
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluates;
    }

    @Override
    public List<Evaluate> showQuintessence() {
        List<Evaluate> evaluates =  null;
        List<Evaluate> evaluateList = new ArrayList<>();
        try {
            DBUtils.begin();
            evaluates = evaluateDao.selectAll();
            //降序排序,精华，按时间
            Evaluate evaluate = null;
            for(int i = 0; i < evaluates.size();i++){
                evaluate = evaluates.get(i);
                if(evaluate.getQuintessence() != 0){
                    evaluateList.add(evaluate);
                }
            }
            Collections.sort(evaluates, new Comparator<Evaluate>() {
                @Override
                public int compare(Evaluate o1, Evaluate o2) {
                    return DataUtils.utilToStr(o2.getPublishTime()).compareTo(DataUtils.utilToStr(o1.getPublishTime()));
                }
            });
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluateList;
    }


    @Override
    public List<Evaluate> showByLabel(int labelId){
        List<Evaluate> evaluates =  null;
        try {
            DBUtils.begin();
            evaluates = evaluateDao.selectByLabel(labelId);
            //降序排序，按热度
            Collections.sort(evaluates, new Comparator<Evaluate>() {
                @Override
                public int compare(Evaluate o1, Evaluate o2) {
                    return o2.getPraise() - o1.getPraise();
                }
            });
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return evaluates;
    }

    @Override
    public int postEvaluate(Evaluate evaluate) {
        int result = 0;
        try {
            DBUtils.begin();
            result = evaluateDao.insert(evaluate);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteEvaluate(int evaluateId) {
        int result = 0;
        try {
            DBUtils.begin();
            result = evaluateDao.remove(evaluateId);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int updateEvaluate(Evaluate evaluate) {
        int result = 0;
        try {
            DBUtils.begin();
            result = evaluateDao.update(evaluate);
            DBUtils.commit();
        } catch (Exception e) {
            DBUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
