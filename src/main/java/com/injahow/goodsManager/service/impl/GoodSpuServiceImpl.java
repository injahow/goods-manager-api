package com.injahow.goodsManager.service.impl;

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
    private GoodSpuDAO goodDAO;

    @Transactional
    public boolean addGoodSpu(GoodSpu good) {
        int res = goodDAO.insertGood(good);
        return res>0;
    }

    @Override
    public List<GoodSpu> listGoodSpu(int start, int pageSize) {
        return goodDAO.listGood(start, pageSize);
    }

    @Override
    public boolean removeGoodSpu() {
        return false;
    }

}
