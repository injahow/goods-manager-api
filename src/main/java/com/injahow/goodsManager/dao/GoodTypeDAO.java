package com.injahow.goodsManager.dao;

import com.injahow.goodsManager.bean.GoodType;

import java.util.List;

public interface GoodTypeDAO {
    int insertGoodType(GoodType goodType);
    int deleteGoodTypeById(int id);
    int updateGoodType(GoodType goodType);
    GoodType findGoodTypeById(int typeId);
    List<GoodType> listIdAndNameGoodType();
    List<GoodType> listGoodType();
}
