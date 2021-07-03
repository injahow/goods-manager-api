package com.injahow.goodsManager.controller;


import com.injahow.goodsManager.bean.GoodSku;
import com.injahow.goodsManager.bean.vo.ResultVO;
import com.injahow.goodsManager.service.GoodSkuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/good_sku")
@CrossOrigin
@ResponseBody
public class GoodSkuController {

    @Resource
    private GoodSkuService goodSkuService;

    @GetMapping("/list_same")
    public ResultVO listSame(@RequestParam("goodId") int goodId){

        List<GoodSku> goodSkuList = goodSkuService.listGoodSku(goodId);
        return new ResultVO(200, "success" , goodSkuList);
    }

    @GetMapping("/find")
    public ResultVO find(@RequestParam("skuId") int skuId) {
        // GoodSku goodSku = goodSkuService.find(goodId);

        return new ResultVO(200, "success" , "goodSkuAndTypeVO");
    }

    @PostMapping("/add")
    public ResultVO add(@RequestBody GoodSku goodSku) {
        if(goodSku.getSkuName()==null &&
                goodSku.getSkuImg()==null &&
                goodSku.getParamsMap()==null &&
                goodSku.getOriginalPrice()==0 &&
                goodSku.getSellPrice()==0 &&
                goodSku.getGoodStock()==null) {
            return new ResultVO(500, "请输入数据后提交", null);
        }
        boolean isSuccess = goodSkuService.addGoodSku(goodSku);
        if (isSuccess) {
            return new ResultVO(200, "提交成功", null);
        } else {
            return new ResultVO(500, "提交失败", null);
        }
    }

    @PostMapping("/edit")
    public ResultVO edit(@RequestBody GoodSku goodSku){
        int skuId = goodSku.getSkuId();
        System.out.println(goodSku);
        if (skuId>0){
            boolean isSuccess = false;//goodSkuService.editGoodSku(goodSku);
            if (isSuccess){
                return new ResultVO(200,"修改成功",null);
            }else {
                return new ResultVO(500,"修改失败",null);
            }
        }else {
            return new ResultVO(500,"提交表单失败",null);
        }
        // return new ResultVO(500,"提交表单失败",null);
    }

    @PostMapping("/del")
    public ResultVO del(@RequestBody GoodSku goodSku) {
        int skuId = goodSku.getSkuId();

        boolean isSuccess = goodSkuService.removeGoodSkuById(skuId);
        if (isSuccess) {
            return new ResultVO(200, "删除成功", null);
        } else {
            return new ResultVO(500, "删除失败", null);
        }
    }


}
