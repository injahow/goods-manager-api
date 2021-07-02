package com.injahow.goodsManager.bean.vo;

import com.injahow.goodsManager.bean.Member;
import com.injahow.goodsManager.bean.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentAndUserVO {
    int commentId;
    String goodId;
    String content;
    Member member;
    Date createTime;
}
