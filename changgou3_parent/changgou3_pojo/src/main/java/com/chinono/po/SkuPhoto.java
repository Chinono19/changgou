package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * sku图片
 */

@Table(name = "tb_sku_photo")
@Data
public class SkuPhoto {
    @Id
    private Integer id;
    @Column(name = "sku_id")
    private Integer skuId;
    private String url;
}
