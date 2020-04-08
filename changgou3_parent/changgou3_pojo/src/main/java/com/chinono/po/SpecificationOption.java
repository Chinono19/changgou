package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_specification_option")
@Data
public class SpecificationOption {
    @Id
    private Integer id;
    @Column(name = "option_name")
    private String optionName;
    @Column(name = "spec_id")
    private Integer specId;
}
