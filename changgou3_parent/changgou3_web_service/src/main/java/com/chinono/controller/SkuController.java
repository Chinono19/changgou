package com.chinono.controller;

import com.chinono.po.OneSkuResult;
import com.chinono.service.SkuService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.ESData;
import com.chinono.vo.SearchSku;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Resource
    private SkuService skuService;

    @GetMapping("/esData")
    public BaseResult<List<ESData>> findAll(){
        List<SearchSku> list = skuService.findSku();
        return BaseResult.ok("查询成功",list);
    }

    /**
     * 查询详情
     * @param skuId
     * @return
     */
    @GetMapping("/goods/{skuId}")
    public BaseResult<OneSkuResult> findById(@PathVariable("skuId") Integer skuId){
        //1 查询
        OneSkuResult oneSkuResult = skuService.findSkuById(skuId);

        //2 返回
        return BaseResult.ok("查询成功", oneSkuResult );

    }

    @PutMapping("/updateSkuNum")
    public BaseResult updateSkuNum(@RequestParam("skuId") Integer skuId,@RequestParam("count")Integer count){
        //更新
        skuService.updateSkuNum(skuId,count);
        //返回
        return BaseResult.ok("更新成功");
    }

}
