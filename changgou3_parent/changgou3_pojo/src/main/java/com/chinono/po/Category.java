package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_category")
@Data
public class Category {
    //数据库匹配字段
    @Id
    private Integer id;
    @Column(name = "cat_name")
    private String catName;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "is_parent")
    private Integer isParent;

    //用于封装数据--每一个分类，对应多个子分类
    private List<Category> children = new ArrayList<>();


}