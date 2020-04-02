package com.chinono.controller;

import com.chinono.po.News;
import com.chinono.service.NewsService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.NewsVo;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Resource
    private NewsService newsService;
    @GetMapping("/findAllNews")
    public BaseResult findAllNews(NewsVo newsvo){
        PageInfo<News> pageInfo =  newsService.findAll(newsvo);
        return BaseResult.ok("查询成功",pageInfo);
    }
}
