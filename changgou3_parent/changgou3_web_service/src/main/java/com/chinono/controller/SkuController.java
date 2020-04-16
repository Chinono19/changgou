package com.chinono.controller;

import com.chinono.service.SkuService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.ESData;
import com.chinono.vo.SearchSku;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
