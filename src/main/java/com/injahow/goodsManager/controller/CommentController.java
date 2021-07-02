package com.injahow.goodsManager.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.injahow.goodsManager.bean.*;
import com.injahow.goodsManager.bean.vo.CommentAndMemberVO;
import com.injahow.goodsManager.bean.vo.PageHelperVO;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.CommentService;
import com.injahow.goodsManager.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/comment")
@CrossOrigin
@ResponseBody
public class CommentController {

    @Resource
    private CommentService commentService;

    @Resource
    private MemberService memberService;

    @GetMapping("/list")
    public ResultVO find(@RequestParam(defaultValue = "1") int pageNo,
                                        @RequestParam(defaultValue = "10") int pageSize) {

        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Comment> pageInfo = new PageInfo<>(commentService.listComment());
        int pages = pageInfo.getPages();
        int total = (int) pageInfo.getTotal();
        List<Comment> list = pageInfo.getList();
        List<CommentAndMemberVO> resList = new ArrayList();
        for(Comment item: list) {
            Member member = memberService.getMemberById(item.getMemberId());
            resList.add(new CommentAndMemberVO(
                    item.getCommentId(),
                    item.getGoodId(),
                    item.getContent(),
                    member,
                    item.getCreateTime()
            ));
        }
        PageHelperVO<CommentAndMemberVO> data = new PageHelperVO<>(total, pages, resList);
        return new ResultVO(200, "success" , data);
    }

    @PostMapping("/del")
    public ResultVO del(@RequestBody Comment comment) {
        int commentId = comment.getCommentId();
        if (commentId!=0){
            boolean isSuccess = commentService.removeCommentById(commentId);
            if (isSuccess) {
                return new ResultVO(200, "删除成功", null);
            } else {
                return new ResultVO(500, "删除失败", null);
            }
        }else {
            return new ResultVO(500, "提交请求失败", null);
        }

    }
}
