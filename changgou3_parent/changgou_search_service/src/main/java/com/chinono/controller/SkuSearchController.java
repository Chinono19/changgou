package com.chinono.controller;

import com.chinono.service.SkuSearchService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.SearchVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/sku")
public class SkuSearchController {

    @Resource
    private SkuSearchService skuSearchService;

    @PostMapping("/search")
    public BaseResult findSkus(@RequestBody SearchVo searchVo){
        Map map = skuSearchService.search3(searchVo);
        return BaseResult.ok("查询成功",map);
    }
}
