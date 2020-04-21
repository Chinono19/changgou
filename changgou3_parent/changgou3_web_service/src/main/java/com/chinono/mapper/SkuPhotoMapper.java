package com.chinono.mapper;

import com.chinono.po.SkuPhoto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface SkuPhotoMapper extends Mapper<SkuPhoto> {
    /**
     * 通过sku查询所有的图片
     * @param skuId
     * @return
     */
    @Select("SELECT * FROM tb_sku_photo WHERE sku_id = #{skuId}")
    public List<SkuPhoto> findSkuPhotoBySkuId(@Param("skuId") Integer skuId);

}
