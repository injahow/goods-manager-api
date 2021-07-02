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

    @PostMapping("/add")
    public ResultVO add(@RequestBody GoodType goodType) {
        if(goodType.getTypeId()== 0 &&
                goodType.getTypeName()==null) {
            return new ResultVO(500, "请输入数据后提交", null);
        }
        boolean isSuccess = goodTypeService.addGoodType(goodType);
        if (isSuccess) {
            return new ResultVO(200, "提交成功", null);
        } else {
            return new ResultVO(500, "提交失败", null);
        }
    }

    @PostMapping("/del")
    public ResultVO del(@RequestBody GoodType goodType) {
        int typeId = goodType.getTypeId();
        if(typeId>0){
            boolean isSuccess = goodTypeService.removeGoodTypeById(typeId);
            if (isSuccess) {
                return new ResultVO(200, "删除成功", null);
            } else {
                return new ResultVO(500, "删除失败", null);
            }
        }else{
            return new ResultVO(500, "请提交typeId参数", null);
        }


    }

    @PostMapping("/edit")
    public ResultVO edit(@RequestBody GoodType goodType){
        int typeId = goodType.getTypeId();
        if (typeId>0){
            boolean isSuccess = goodTypeService.editGoodType(goodType);
            if (isSuccess){
                return new ResultVO(200,"修改成功",null);
            }else {
                return new ResultVO(500,"修改失败",null);
            }
        }else {
            return new ResultVO(500,"提交表单失败",null);
        }
    }

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
        return new ResultVO(200, "success", mapList);
    }

    @GetMapping("/list")
    public ResultVO list(){
        List<Map> mapList = new ArrayList<>();
        List<GoodType>  goodTypeList = goodTypeService.listGoodType();
        for (GoodType goodType: goodTypeList){
            Map map = new HashMap();
            map.put("typeId",goodType.getTypeId());
            map.put("typeName",goodType.getTypeName());
            map.put("typeDesc",goodType.getTypeDesc());
            mapList.add(map);
        }
        return new ResultVO(200,"success", goodTypeList);
    }

    @GetMapping("/find")
    public ResultVO find(@RequestParam("typeId") int typeId) {

        GoodType goodType = goodTypeService.find(typeId);

        return new ResultVO(200,"success", goodType);
    }
}
