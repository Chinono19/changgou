package com.chinono.mapper;

import com.chinono.po.SkuComment;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;
@org.apache.ibatis.annotations.Mapper
public interface SkuCommontMapper extends Mapper<SkuComment> {

    /**
     * 查询评论数
     * @param spuId
     * @return
     */
    @Select("select count(*) from tb_sku_comment where spu_id = #{spuId}")
    public Integer findNumBySpuId(@Param("spuId") Integer spuId);
}
