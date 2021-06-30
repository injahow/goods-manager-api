package com.injahow.goodsManager.controller;


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
    private GoodSpuService goodService;

    @GetMapping("/list")
    @ResponseBody
    public ResultVO list() {

        List<GoodSpu> goods = goodService.listGoodSpu(1,5);

        PageHelperVO pageHelperVO = new PageHelperVO(80,12, goods);
        System.out.println("list...");


        return new ResultVO(200, "success" , pageHelperVO);
    }

    @PostMapping("/add") // 同步响应，直接跳转
    @ResponseBody
    public HashMap add(/*Good good,*/ MultipartFile imgFile) {
        // MultipartFile 获取文件流，属性名保持一致
        //bookService.addBook(book);
        //System.out.println("add...");
        //System.out.println(imgFile.getOriginalFilename());
        //model.addAttribute("book", book);
        return null;
    }

}
