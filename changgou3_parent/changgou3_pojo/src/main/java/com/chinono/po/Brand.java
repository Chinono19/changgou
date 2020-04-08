package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_brand")
@Data
public class Brand {
    @Id
    private Integer id;
    @Column(name = "brand_name")
    private String brandName;
    private String logo;
}
