package com.yunze.LibraryManagementSystem.modules.evaluate.service;

import com.yunze.LibraryManagementSystem.modules.evaluate.entity.Evaluate;

import java.util.List;

public interface EvaluateService {
    public List<Evaluate> show(String str);//根据读者名/书名搜索评论
    public Evaluate search(int evaluateId);
    public List<Evaluate> showByTime();//最近评论
    public List<Evaluate> showHot();//热门评论
    public List<Evaluate> showQuintessence();//精华评论
    List<Evaluate> showByLabel(int labelId);//根据label显示相关评论
    public int postEvaluate(Evaluate evaluate);//发布评论
    public int deleteEvaluate(int evaluateId);//删除评论
    public int updateEvaluate(Evaluate evaluate);//修改评论内容，动态更新浏览量点赞量等数据
}
