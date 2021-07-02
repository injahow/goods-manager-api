package com.injahow.goodsManager.service.impl;

import com.injahow.goodsManager.bean.GoodType;
import com.injahow.goodsManager.dao.GoodTypeDAO;
import com.injahow.goodsManager.service.GoodTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

@Service
public class GoodTypeServiceImpl implements GoodTypeService {

    @Resource
    private GoodTypeDAO goodTypeDAO;

    @Override
    public boolean addGoodType(GoodType goodType) {
        int res = goodTypeDAO.insertGoodType(goodType);
        return res>0;
    }

    @Override
    public boolean removeGoodTypeById(int typeId) {
        int res = goodTypeDAO.deleteGoodTypeById(typeId);
        return res>0;
    }

    @Override
    public boolean editGoodType(GoodType goodType) {
        int res = goodTypeDAO.updateGoodType(goodType);
        return res>0;
    }

    @Override
    @Transactional
    public GoodType listGoodTypeById(int typeId) {
        return goodTypeDAO.findGoodTypeById(typeId);

    }

    @Override
    public List<GoodType> listIdAndNameGoodType() {
        return goodTypeDAO.listIdAndNameGoodType();
    }

    @Override
    public List<GoodType> listGoodType() {
        return goodTypeDAO.listGoodType();
    }

}
