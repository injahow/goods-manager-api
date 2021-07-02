package com.injahow.goodsManager.service;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSku;
import com.injahow.goodsManager.bean.GoodSpu;

import java.util.List;

public interface GoodSkuService {
    List<GoodSku> listGoodSku(int goodId);
    boolean addGoodSku(GoodSku goodSku);
    boolean removeGoodSkuById(int skuId);

}
