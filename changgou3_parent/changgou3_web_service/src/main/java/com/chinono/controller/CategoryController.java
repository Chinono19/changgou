package com.chinono.controller;

import com.chinono.po.Category;
import com.chinono.service.CategoryService;
import com.chinono.utils.BaseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/categorys")
public class CategoryController {

    @Resource
    private CategoryService categoryService;


    @GetMapping("/findAll")
    public BaseResult findAll(){
        List<Category> list = categoryService.findAll();
        return BaseResult.ok("查询成功",list);
    }
}
