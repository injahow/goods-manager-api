package com.injahow.goodsManager.dao;

import com.injahow.goodsManager.bean.GoodSpu;

import java.util.List;

public interface GoodSpuDAO {
    int insertGood(GoodSpu good);
    int deleteGoodById(int id);
    GoodSpu queryGoodById(int id);
    List<GoodSpu> listGood(int start, int limit);

}
