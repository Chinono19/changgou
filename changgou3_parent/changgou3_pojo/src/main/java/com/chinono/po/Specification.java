package com.chinono.po;

import lombok.Data;
import sun.management.counter.perf.PerfInstrumentation;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Table(name = "tb_specification")
@Data
public class Specification {
    @Id
    private Integer id;
    @Column(name = "spec_name")
    private String specName;

    @Column(name = "category_id")
    private Integer categoryId;

    //一个规格拥有多个规格选项
    private List<SpecificationOption> options = new ArrayList<>();


}
