package com.chinono.controller;

import com.chinono.po.Specification;
import com.chinono.service.SpecificationService;
import com.chinono.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/specifications")
public class SpecificationController {

    @Resource
    private SpecificationService specificationService;

    @GetMapping("/category/{categoryId}")
    public BaseResult findAll(@PathVariable("categoryId")Integer categoryId){
        //判断
        if (categoryId == null){
            return  BaseResult.error("查询规格失败");
        }
        //查询
        List<Specification> list = specificationService.findAll(categoryId);
        return BaseResult.ok("查询成功",list);
    }
}
