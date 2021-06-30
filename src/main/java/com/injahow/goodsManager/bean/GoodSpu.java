package com.injahow.goodsManager.bean;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GoodSpu {

    int goodId;
    String goodName;

    int typeId;
    int soldNum;
    int status;

    String context;
    Date createTime;
    Date updateTime;
}
