package com.injahow.goodsManager.service.impl;

import com.injahow.goodsManager.bean.GoodSku;

import com.injahow.goodsManager.dao.GoodSkuDAO;
import com.injahow.goodsManager.service.GoodSkuService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


@Service
public class GoodSkuServiceImpl implements GoodSkuService {
    @Resource
    private GoodSkuDAO goodSkuDAO;

    @Override
    public List<GoodSku> listGoodSku(int goodId) {
        return goodSkuDAO.queryGoodSkuByGoodId(goodId);
    }

    @Override
    public boolean addGoodSku(GoodSku goodSku) {
        goodSku.setCreateTime(new Date());
        goodSku.setUpdateTime(new Date());
        int res = goodSkuDAO.insertGoodSku(goodSku);
        return res>0;
    }

    @Override
    public boolean removeGoodSkuById(int skuId) {
        int res = goodSkuDAO.deleteGoodSkuById(skuId);
        return res>0;
    }

    @Override
    public GoodSku find(int skuId) {
        return goodSkuDAO.queryGoodSkuById(skuId);
    }

    @Override
    public boolean editGoodSku(GoodSku goodSku) {
        goodSku.setUpdateTime(new Date());
        int res = goodSkuDAO.updateGoodSku(goodSku);
        return res>0;
    }
}