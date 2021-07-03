package com.injahow.goodsManager.service.impl;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.Comment;
import com.injahow.goodsManager.dao.CommentDAO;
import com.injahow.goodsManager.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentDAO commentDAO;

    @Override
    public boolean removeCommentById(int commentId) {
        int res = commentDAO.deleteCommentById(commentId);
        return res>0;
    }


    @Override
    public Page<Comment> listComment() {
        return commentDAO.listComment();
    }

    @Override
    public boolean deleteCommentsById(List<Integer> idList) {
        int res = commentDAO.deleteCommentsById(idList);
        return res>0;
    }
}
