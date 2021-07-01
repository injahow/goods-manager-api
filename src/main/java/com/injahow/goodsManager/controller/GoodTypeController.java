package com.injahow.goodsManager.controller;

import com.injahow.goodsManager.bean.GoodType;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.GoodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;


@Controller
@RequestMapping("/good")
@CrossOrigin

public class GoodTypeController {

    @Resource
    private GoodTypeService goodTypeService;

    @PostMapping("/detail")
    @ResponseBody
    public ResultVO query(GoodType goodType){

        int typeId = goodType.getTypeId();
        System.out.println(typeId);
        if (typeId>0){
            return new ResultVO();
        }
        return new ResultVO();
    }
}
