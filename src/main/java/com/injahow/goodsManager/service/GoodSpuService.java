package com.injahow.goodsManager.service;


import com.injahow.goodsManager.bean.GoodSpu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodSpuService {

    boolean addGoodSpu(GoodSpu goodSpu);
    List<GoodSpu> listGoodSpu(@Param("start") int start,
                           @Param("pageSize") int pageSize);

    boolean removeGoodSpu();

}
