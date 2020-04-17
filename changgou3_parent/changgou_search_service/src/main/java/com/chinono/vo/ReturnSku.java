package com.chinono.vo;

import lombok.Data;

/**
 * Created by liangtong.
 */
@Data
public class ReturnSku {
    private Integer id;         //
    private String goodsName;   //商品名称
    private Double price;      //价格(单位：分)
    private String midlogo;     //spu logo
    private Integer commentCount;   //评论数
}
