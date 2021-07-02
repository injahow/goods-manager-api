package com.injahow.goodsManager.service;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.Comment;
import com.injahow.goodsManager.bean.GoodType;
import org.springframework.stereotype.Service;

@Service

public interface CommentService {
    boolean removeCommentById(int commentId);
    Page<Comment> listComment();

}
