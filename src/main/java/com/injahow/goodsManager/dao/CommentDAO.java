package com.injahow.goodsManager.dao;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.Comment;
import com.injahow.goodsManager.bean.GoodType;

import java.util.List;


public interface CommentDAO {
    Page<Comment> listComment();
    int deleteCommentById(int commentId);
    int deleteCommentsById(List<Integer> idList);
}
