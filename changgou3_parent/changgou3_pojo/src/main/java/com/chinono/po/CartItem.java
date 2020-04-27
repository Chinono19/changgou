package com.chinono.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/** 购物车的购物项
 * Created by liangtong.
 */
@Data
public class CartItem {
    private Integer skuid;          // sku(商品)id
    private Integer spuid;          // spu(小分类)id
    @JsonProperty("goods_name")
    private String goodsName;       //商品名称
    private Double price;           //价格
    private Integer count;          //购买数量
    private Boolean checked;        //是否选中
    private String midlogo;         //图标
    @JsonProperty("spec_info")
    private String specInfo;        //规格信息
}
