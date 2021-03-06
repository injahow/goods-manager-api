package com.injahow.goodsManager.controller;


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

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/good")
@CrossOrigin
@ResponseBody
public class GoodSpuController {

    @Resource
    private GoodSpuService goodSpuService;

    @Resource
    private GoodTypeService goodTypeService;

    private PageHelperVO<GoodSpuAndTypeVO> listPageInfo(PageInfo<GoodSpu> pageInfo){
        int pages = pageInfo.getPages();
        int total = (int) pageInfo.getTotal();
        List<GoodSpu> list = pageInfo.getList();
        List<GoodSpuAndTypeVO> resList = new ArrayList();
        for(GoodSpu item: list){
            GoodType goodType = goodTypeService.listGoodTypeById(item.getTypeId());
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
        return new PageHelperVO<>(total, pages, resList);
    }

    @GetMapping("/list")
    public ResultVO list(@RequestParam(defaultValue = "1") int pageNo,
                         @RequestParam(defaultValue = "10") int pageSize) {
        // 配置分页插件
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<GoodSpu> pageInfo = new PageInfo<>(goodSpuService.listGoodSpu());
        return new ResultVO(200, "success" , listPageInfo(pageInfo));
    }

    @GetMapping("/search")
    public ResultVO search(@RequestParam String name,
                        @RequestParam(defaultValue = "1") int pageNo,
                        @RequestParam(defaultValue = "10") int pageSize) {

        if(name==null || name==""){
            return new ResultVO(500, "搜索名称为空！" , null);
        }
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<GoodSpu> pageInfo;
        pageInfo = new PageInfo<>(goodSpuService.searchGoodSpuByName(name));
        return new ResultVO(200, "success" , listPageInfo(pageInfo));
    }

    @GetMapping("/search_type")
    public ResultVO search(@RequestParam(defaultValue = "0") int name,
                           @RequestParam(defaultValue = "1") int pageNo,
                           @RequestParam(defaultValue = "10") int pageSize) {
        if(name>0) {
            PageHelper.startPage(pageNo, pageSize);
            PageInfo<GoodSpu> pageInfo;
            pageInfo = new PageInfo<>(goodSpuService.searchGoodSpuByTypeId(name));
            return new ResultVO(200, "success" , listPageInfo(pageInfo));
        }else{
            return new ResultVO(500, "搜索类型为空！" , null);
        }

    }

    @GetMapping("/find")
    public ResultVO find(@RequestParam("goodId") int goodId) {
        GoodSpu goodSpu = goodSpuService.find(goodId);
        return new ResultVO(200, "success" , goodSpu);
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody GoodSpu goodSpu /*MultipartFile imgFile*/) {
        // MultipartFile 获取文件流，属性名保持一致
        if(goodSpu.getContext()==null &&
                goodSpu.getGoodName()==null &&
                goodSpu.getSoldNum() == 0 &&
                goodSpu.getStatus() == 0 &&
                goodSpu.getTypeId() == 0 ) {
            return new ResultVO(500, "请输入数据后提交", null);
        }
        boolean isSuccess = goodSpuService.addGoodSpu(goodSpu);
        if (isSuccess) {
            return new ResultVO(200, "提交成功", goodSpu);
        } else {
            return new ResultVO(500, "提交失败", null);
        }
    }

    @PostMapping("/edit")
    public ResultVO edit(@RequestBody GoodSpu goodSpu){
        int goodId = goodSpu.getGoodId();
        System.out.println(goodSpu);
        if (goodId>0){
            boolean isSuccess = goodSpuService.editGoodSpu(goodSpu);
            if (isSuccess){
                return new ResultVO(200,"修改成功",goodSpu);
            }else {
                return new ResultVO(500,"修改失败",null);
            }
        }else {
            return new ResultVO(500,"提交表单失败",null);
        }
    }

    @PostMapping("/del")
    public ResultVO del(@RequestBody GoodSpu goodSpu) {
        int goodId = goodSpu.getGoodId();
        boolean isSuccess = goodSpuService.removeGoodSpuById(goodId);
        if (isSuccess) {
            return new ResultVO(200, "删除成功", null);
        } else {
            return new ResultVO(500, "删除失败", null);
        }

    }
}
