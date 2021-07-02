package com.injahow.goodsManager.dao;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodType;

import java.util.List;

public interface GoodTypeDAO {
    int insertGoodType(GoodType goodType);
    int deleteGoodTypeById(int id);
    int updateGoodType(GoodType goodType);
    GoodType findGoodTypeById(int typeId);
    Page<GoodType> listGoodType();
    List<GoodType> listIdAndNameGoodType();
}