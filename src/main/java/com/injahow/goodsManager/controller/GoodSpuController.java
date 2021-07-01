package com.injahow.goodsManager.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.injahow.goodsManager.bean.GoodSpu;
import com.injahow.goodsManager.bean.GoodType;
import com.injahow.goodsManager.bean.vo.GoodSpuAndTypeVO;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.GoodSpuService;
import com.injahow.goodsManager.bean.vo.PageHelperVO;
import com.injahow.goodsManager.service.GoodTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/good")
@CrossOrigin
public class GoodSpuController {

    @Resource
    private GoodSpuService goodSpuService;

    @Resource
    private GoodTypeService goodTypeService;

    @GetMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam(defaultValue = "1") int pageNo,
                         @RequestParam(defaultValue = "10") int pageSize) {

        PageHelper.startPage(pageNo, pageSize);

        PageInfo<GoodSpu> pageInfo = new PageInfo<>(goodSpuService.listGoodSpu());

        int pages = pageInfo.getPages();
        int total = (int) pageInfo.getTotal();

        List<GoodSpu> list = pageInfo.getList();


        List<GoodSpuAndTypeVO> resList = new ArrayList();

        for(GoodSpu item: list){
            GoodType goodType = goodTypeService.getGoodTypeById(item.getTypeId());

            resList.add(new GoodSpuAndTypeVO(
                    item.getGoodId(),
                    item.getGoodName(),
                    goodType,
                    item.getSoldNum(),
                    item.getStatus(),
                    item.getContext(),
                    item.getCreateTime(),
                    item.getUpdateTime()
            ));
        }


        PageHelperVO<GoodSpuAndTypeVO> data = new PageHelperVO<>(total, pages, resList);
        return new ResultVO(200, "success" , data);
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultVO add(GoodSpu goodSpu /*MultipartFile imgFile*/) {
        // MultipartFile 获取文件流，属性名保持一致
        boolean isSuccess = goodSpuService.addGoodSpu(goodSpu);
        if (isSuccess) {
            return new ResultVO(200, "提交成功", null);
        } else {
            return new ResultVO(500, "提交失败", null);
        }
    }

    @PostMapping("/edit")
    @ResponseBody
    public ResultVO edit(GoodSpu goodSpu){
        int goodId = goodSpu.getGoodId();
        System.out.println(goodSpu);
        if (goodId>0){
            boolean isSuccess = goodSpuService.editGoodSpu(goodSpu);
            System.out.println(goodSpu);
            if (isSuccess){
                return new ResultVO(200,"修改成功",null);
            }else {
                return new ResultVO(500,"修改失败",null);
            }
        }else {
            return new ResultVO(500,"提交表单失败",null);
        }
    }

    @PostMapping("/del")
    @ResponseBody
    public ResultVO del(@RequestParam("goodId") int goodId) {
        boolean isSuccess = goodSpuService.removeGoodSpuById(goodId);
        if (isSuccess) {
            return new ResultVO(200, "删除成功", null);
        } else {
            return new ResultVO(500, "删除失败", null);
        }

    }
}
