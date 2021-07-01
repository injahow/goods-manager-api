package com.injahow.goodsManager.controller;

import com.injahow.goodsManager.bean.GoodType;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.GoodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/good_type")
@CrossOrigin
@ResponseBody
public class GoodTypeController {

    @Resource
    private GoodTypeService goodTypeService;


    @GetMapping("/list_name")
    public ResultVO listName(){
        List<Map> mapList = new ArrayList<>();
        List<GoodType> goodTypeList = goodTypeService.listIdAndNameGoodType();
        for (GoodType goodType: goodTypeList){
            Map map = new HashMap();
            map.put("typeId",goodType.getTypeId());
            map.put("typeName",goodType.getTypeName());
            mapList.add(map);
        }
        return new ResultVO(200, null, mapList);
    }

    @GetMapping("/list")
    public ResultVO get(){

        /*int typeId = goodType.getTypeId();
        System.out.println(typeId);
        if (typeId>0){
            return new ResultVO();
        }*/
        return new ResultVO(200,null, null);
    }
}
