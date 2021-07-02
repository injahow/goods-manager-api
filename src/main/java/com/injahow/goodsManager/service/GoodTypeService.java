package com.injahow.goodsManager.service;


import com.injahow.goodsManager.bean.GoodSpu;
import com.injahow.goodsManager.bean.GoodType;

import java.util.List;

public interface GoodTypeService {

    boolean addGoodType(GoodType goodType);
    boolean removeGoodTypeById(int typeId);
    boolean editGoodType(GoodType goodType);
    GoodType listGoodTypeById(int typeId);
    List<GoodType> listIdAndNameGoodType();
    List<GoodType> listGoodType();
}
