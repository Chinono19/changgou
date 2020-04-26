package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_impression")
@Data
public class Impression {
    @Id
    private Integer id;
    private String title;
    private Integer count;
    @Column(name = "spu_id")
    private Integer spuId;
    @Column(name = "sku_id")
    private Integer skuId;

}
