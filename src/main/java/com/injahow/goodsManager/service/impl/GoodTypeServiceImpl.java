package com.injahow.goodsManager.service.impl;

import com.injahow.goodsManager.bean.GoodType;
import com.injahow.goodsManager.dao.GoodTypeDAO;
import com.injahow.goodsManager.service.GoodTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class GoodTypeServiceImpl implements GoodTypeService {

    @Resource
    private GoodTypeDAO goodTypeDAO;


    @Override
    @Transactional
    public GoodType getGoodTypeById(int typeId) {
        return goodTypeDAO.findGoodTypeById(typeId);

    }
}
