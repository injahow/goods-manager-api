package com.injahow.goodsManager.service;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface CommentService {
    boolean removeCommentById(int commentId);
    Page<Comment> listComment();
    boolean deleteCommentsById(List<Integer> idList);
}
