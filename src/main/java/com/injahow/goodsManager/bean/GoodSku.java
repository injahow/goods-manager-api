package com.injahow.goodsManager.bean;


import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GoodSku {

    int skuId;
    int goodId;

    String skuName;
    String skuImg;
    String paramsMap;

    Double originalPrice;
    Double sellPrice;

    String goodStock;

    Date createTime;
    Date updateTime;

}
