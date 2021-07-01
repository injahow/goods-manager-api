package com.injahow.goodsManager.service;


import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSpu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodSpuService {

    boolean addGoodSpu(GoodSpu goodSpu);
    Page<GoodSpu> listGoodSpu();
    boolean editGoodSpu(GoodSpu goodSpu);
    boolean removeGoodSpuById(int goodId);
    GoodSpu find(int goodId);
}
