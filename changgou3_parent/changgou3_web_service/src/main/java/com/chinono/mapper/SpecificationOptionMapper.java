package com.chinono.mapper;

import com.chinono.po.SpecificationOption;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecificationOptionMapper extends Mapper<SpecificationOption> {


    @Select("select * from tb_specification_option where spec_id = #{specId}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "optionName",column = "option_name"),
            @Result(property = "specId",column = "spec_id"),
    })
    public List<SpecificationOption> findAll(@Param("specId")Integer sepcId);

}
