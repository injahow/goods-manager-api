package com.injahow.goodsManager.service.impl;

import com.github.pagehelper.Page;
import com.injahow.goodsManager.bean.GoodSpu;
import com.injahow.goodsManager.dao.GoodSpuDAO;
import com.injahow.goodsManager.service.GoodSpuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodSpuServiceImpl implements GoodSpuService {

    @Resource
    private GoodSpuDAO goodSpuDAO;

    @Transactional
    public boolean addGoodSpu(GoodSpu good) {
        int res = goodSpuDAO.insertGoodSpu(good);
        return res>0;
    }

    @Override
    public Page<GoodSpu> listGoodSpu() {
        return goodSpuDAO.listGoodSpu();
    }

    @Override
    public boolean removeGoodSpu() {
        return false;
    }

    @Override
    public boolean editGoodSpu(GoodSpu goodSpu) {
        int res = goodSpuDAO.updateGoodSpu(goodSpu);
        return res>0;
    }

}
