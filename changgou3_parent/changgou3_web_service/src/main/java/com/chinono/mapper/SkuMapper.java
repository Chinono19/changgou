package com.chinono.mapper;

import com.chinono.po.Sku;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SkuMapper extends Mapper<Sku> {
    @Select("select * from tb_sku")
    @Results(id = "skuResult",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "stock", column = "stock"),
            @Result(property = "spuId", column = "spu_id"),
            @Result(property = "skuName", column = "sku_name"),
            @Result(property = "images", column = "images"),
            @Result(property = "price", column = "price"),
            @Result(property = "specInfoIdList", column = "spec_info_id_list"),
            @Result(property = "specInfoIdTxt", column = "spec_info_id_txt"),
            @Result(property = "spu", one = @One(select = "com.chinono.mapper.SpuMapper.findById"), column = "spu_id")
    })
    public List<Sku> findAllSku();

    /**
     * 查询spu对应的所有sku
     * @param spuId
     * @return
     */
    @Select("SELECT * FROM tb_sku WHERE spu_id = #{spuId}")
    @ResultMap("skuResult")
    public List<Sku> findSkuBySpuId(@Param("spuId") Integer spuId);
}
