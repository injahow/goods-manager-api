package com.injahow.goodsManager.dao;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSpu;

import java.util.List;

public interface GoodSpuDAO {
    int insertGoodSpu(GoodSpu good);
    int deleteGoodSpuById(int id);
    GoodSpu queryGoodSpuById(int id);
    Page<GoodSpu> listGoodSpu();
}
