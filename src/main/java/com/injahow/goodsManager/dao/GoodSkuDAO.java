package com.injahow.goodsManager.dao;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSku;
import com.injahow.goodsManager.bean.GoodSpu;

import java.util.List;

public interface GoodSkuDAO {
    List<GoodSku> queryGoodSkuByGoodId(int goodId);
    int insertGoodSku(GoodSku goodSku);
    int deleteGoodSkuById(int id);

}
