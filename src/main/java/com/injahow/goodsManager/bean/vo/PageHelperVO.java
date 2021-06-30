package com.injahow.goodsManager.bean.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageHelperVO<T> {
    //总记录数
    private int count;
    //总页数
    private int pageCount;
    //分页数据
    private List<T> list;
}


