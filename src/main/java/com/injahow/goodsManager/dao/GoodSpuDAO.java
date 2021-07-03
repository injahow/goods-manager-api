package com.injahow.goodsManager.dao;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSpu;

public interface GoodSpuDAO {
    int insertGoodSpu(GoodSpu good);
    int deleteGoodSpuById(int id);
    int updateGoodSpu(GoodSpu good);
    GoodSpu queryGoodSpuById(int id);
    Page<GoodSpu> listGoodSpu();
    Page<GoodSpu> listGoodSpuByName(String goodName);
    Page<GoodSpu> listGoodSpuByTypeId(int typeId);
}
