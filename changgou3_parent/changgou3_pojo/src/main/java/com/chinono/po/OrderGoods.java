package com.chinono.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tb_order_good")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderGoods implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="sn")
    private Long sn;
//    @Transient
//    private Order order;

    @Column(name="sku_id")
    private Integer skuId;
    @Transient
    private Sku sku;

    @Column(name="spu_id")
    private Integer spuId;

    //购买数量
    @Column(name="number")
    private Integer number;
    //规格列表
    @Column(name="spec_list")
    private String specList;
    //商品名称
    @Column(name="sku_name")
    private String skuName;
    @Column(name="url")
    private String logo;
    //价格
    @Column(name="price")
    private Double price;
}
