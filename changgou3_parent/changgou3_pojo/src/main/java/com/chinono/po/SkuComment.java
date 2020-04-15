package com.chinono.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Table(name = "tb_sku_comment")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SkuComment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="user_id")
    private Integer userId;
    @Transient
    private User user;

    @Column(name="spu_id")
    private Integer spuId;
    @Transient
    private Spu spu;

    @Column(name="sku_id")
    private Integer skuId;
    @Transient
    private Sku sku;


    @Column(name="ratio")
    private String ratio;

    @Column(name="spec_list")
    private String specList;


    @Column(name="content")
    private String content;
    @Column(name="star")
    private Integer star;
    @Column(name="isshow")
    private String isShow;

    @Column(name="sn")
    private String sn;

}