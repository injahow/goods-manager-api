package com.injahow.goodsManager.service;

import com.injahow.goodsManager.bean.GoodSku;

import java.util.List;

public interface GoodSkuService {
    List<GoodSku> listGoodSku(int goodId);
    boolean addGoodSku(GoodSku goodSku);
    boolean removeGoodSkuById(int skuId);
    GoodSku find(int skuId);
    boolean editGoodSku(GoodSku goodSku);

}
