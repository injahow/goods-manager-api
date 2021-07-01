package com.injahow.goodsManager.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.injahow.goodsManager.bean.GoodSpu;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.GoodSpuService;
import com.injahow.goodsManager.bean.vo.PageHelperVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/good")
@CrossOrigin
public class GoodSpuController {

    @Resource
    private GoodSpuService goodSpuService;

    @GetMapping("/list")
    @ResponseBody
    public ResultVO list(@RequestParam(defaultValue = "1") int pageNo,
                         @RequestParam(defaultValue = "10") int pageSize) {

        PageHelper.startPage(pageNo, pageSize);

        PageInfo<GoodSpu> pageInfo = new PageInfo<>(goodSpuService.listGoodSpu());

        return new ResultVO(200, "success" , pageInfo);
    }

    @PostMapping("/add") // 同步响应，直接跳转
    @ResponseBody
    public ResultVO add(GoodSpu goodSpu /*MultipartFile imgFile*/) {
        // MultipartFile 获取文件流，属性名保持一致
        boolean isSuccess = goodSpuService.addGoodSpu(goodSpu);
        if (isSuccess){
            return new ResultVO(200, "提交成功" ,null);
        }else {
            return new ResultVO(500, "提交失败" ,null);
        }

        //System.out.println("add...");
        //System.out.println(imgFile.getOriginalFilename());
        //model.addAttribute("book", book);
    }

}
