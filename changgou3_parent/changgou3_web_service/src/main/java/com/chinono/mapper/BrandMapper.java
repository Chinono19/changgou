package com.chinono.mapper;

import com.chinono.po.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface BrandMapper extends Mapper<Brand> {


    @Select("select br.*\n" +
            "from tb_brand br ,  tb_category_brand cb\n" +
            "where cb.category_id = #{categoryId}\n" +
            "and br.id = cb.brand_id")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "brandName",column = "brand_name"),
            @Result(property = "logo",column = "logo"),
    })
    public List<Brand>  findAll(@Param("categoryId")Integer categoryId);
}
