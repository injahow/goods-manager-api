package com.injahow.goodsManager.bean.vo;

import com.injahow.goodsManager.bean.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentAndMemberVO {
    int commentId;
    String goodId;
    String content;
    Member member;
    Date createTime;
}
