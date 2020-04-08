package com.chinono.mapper;

import com.chinono.po.Specification;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SpecificationMapper extends Mapper<Specification> {

    @Select("select * from tb_specification where category_id = #{categoryId} ")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "specName",column = "spec_name"),
            @Result(property = "categoryId",column = "category_id"),
            @Result(property = "options",column = "id",many = @Many(select = "com.chinono.mapper.SpecificationOptionMapper.findAll")),
    })
    public List<Specification> findAll(@Param("categoryId")Integer categoryId);
}
