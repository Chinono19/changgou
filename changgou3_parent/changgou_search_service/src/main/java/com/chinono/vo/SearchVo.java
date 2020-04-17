package com.chinono.vo;


import lombok.Data;

import java.util.Map;

/**
 * Created by liangtong.
 */
@Data
public class SearchVo{
    private Integer catId;      //分类
    private String keyword;    //关键字
    private Integer brandId;    //品牌
    private Map<String,String> specList;   //规格
    private Integer minPrice;   //开始价格
    private Integer maxPrice;   //结束价格

    private Integer pageNum;       //分页
    private Integer pageSize;
    private String sortBy;         //排序
    private String sortWay;
}
