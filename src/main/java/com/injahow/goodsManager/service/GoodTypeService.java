package com.injahow.goodsManager.service;


import com.injahow.goodsManager.bean.GoodType;

import java.util.List;

public interface GoodTypeService {

    GoodType getGoodTypeById(int typeId);
    List<GoodType> listIdAndNameGoodType();

}
