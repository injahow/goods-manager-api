package com.injahow.goodsManager.bean;

import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Comment {
    int commentId;
    String productId;
    String content;
    int memberId;
    Date createTime;
}
