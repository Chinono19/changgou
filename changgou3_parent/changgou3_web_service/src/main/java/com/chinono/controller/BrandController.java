package com.chinono.controller;

import com.chinono.po.Brand;
import com.chinono.service.BrandService;
import com.chinono.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Resource
    private BrandService brandService;

    @GetMapping("/category/{categoryId}")
    public BaseResult findAll(@PathVariable("categoryId")Integer categoryId){
        List<Brand> list = brandService.findAll(categoryId);
        return BaseResult.ok("查询成功",list);
    }


}
