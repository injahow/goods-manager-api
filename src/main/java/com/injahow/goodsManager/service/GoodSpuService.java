package com.injahow.goodsManager.service;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSpu;

public interface GoodSpuService {

    boolean addGoodSpu(GoodSpu goodSpu);
    Page<GoodSpu> listGoodSpu();
    Page<GoodSpu> searchGoodSpuByName(String name);
    Page<GoodSpu> searchGoodSpuByTypeId(int typeId);
    boolean editGoodSpu(GoodSpu goodSpu);
    boolean removeGoodSpuById(int goodId);
    GoodSpu find(int goodId);
}
