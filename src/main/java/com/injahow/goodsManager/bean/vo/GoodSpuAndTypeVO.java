package com.injahow.goodsManager.bean.vo;

import com.injahow.goodsManager.bean.GoodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodSpuAndTypeVO {

    int goodId;
    String goodName;

    GoodType goodType;
    int soldNum;
    int status;

    String context;
    Date createTime;
    Date updateTime;

}
