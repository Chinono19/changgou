package com.chinono.controller;

import com.chinono.service.SkuCommentService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.CommentResult;
import com.chinono.vo.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comments")
public class SkuCommentController {
    @Resource
    private SkuCommentService skuCommentService;

    @GetMapping("/spu/{spuId}")
    public BaseResult findComments(@PathVariable("spuId")Integer spuId, PageRequest pageRequest){
        CommentResult commentResult = skuCommentService.findComments(spuId, pageRequest);
        return BaseResult.ok("查询成功",commentResult);
    }


}
