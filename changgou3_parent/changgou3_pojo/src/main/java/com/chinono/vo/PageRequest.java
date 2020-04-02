package com.chinono.vo;

import lombok.Data;

/** 分页基类（其他vo的父类）
 * Created by liangtong.
 */
@Data
public class PageRequest {
    private Integer pageNum;    //当前页
    private Integer pageSize;   //每页条数
    private String sortBy;     //排序字段
    private String sortWay;    //排序方式(asc | desc)

    //暂时无用，可以删除
    private Integer limit;      //限制条数
    private Integer offset;     //偏移

}