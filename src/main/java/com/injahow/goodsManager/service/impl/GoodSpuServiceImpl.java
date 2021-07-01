package com.injahow.goodsManager.service.impl;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSku;
import com.injahow.goodsManager.bean.GoodSpu;
import com.injahow.goodsManager.dao.GoodSpuDAO;
import com.injahow.goodsManager.service.GoodSpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class GoodSpuServiceImpl implements GoodSpuService {

    @Resource
    private GoodSpuDAO goodSpuDAO;

    @Transactional
    public boolean addGoodSpu(GoodSpu goodSpu) {
        goodSpu.setCreateTime(new Date());
        goodSpu.setUpdateTime(new Date());
        int res = goodSpuDAO.insertGoodSpu(goodSpu);
        return res>0;
    }

    @Override
    public Page<GoodSpu> listGoodSpu() {
        return goodSpuDAO.listGoodSpu();
    }

    @Override
    public boolean removeGoodSpuById(int goodId) {
        int res = goodSpuDAO.deleteGoodSpuById(goodId);
        return res>0;
    }

    @Override
    public GoodSpu find(int goodId) {
        return goodSpuDAO.queryGoodSpuById(goodId);
    }

    @Override
    public boolean editGoodSpu(GoodSpu goodSpu) {
        goodSpu.setUpdateTime(new Date());
        int res = goodSpuDAO.updateGoodSpu(goodSpu);
        return res>0;
    }

}
