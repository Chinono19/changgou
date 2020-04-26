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


    /**
     * 查询指定skuId评论数（当前商品的评论数）
     * @param skuId
     * @return
     */
    @Select("select count(*) from tb_sku_comment where sku_id = #{skuId}")
    public Integer findNumBySkuId(@Param("skuId") Integer skuId);


    /**
     * 通过skuId查询评论级别（求平均数）
     * @param skuId
     * @return
     */
    @Select("SELECT AVG(star) FROM tb_sku_comment WHERE sku_id = #{skuId}")
    public Double findAvgStarBySkuId(@Param("skuId") Integer skuId);


    /**
     * 指定spu前提下，根据ratio查询评论数
     * @param spuId  这是spu 的id
     * @param ratio 这是查询 好评等级的标识
     * @return
     */
    @Select("select count(*) from tb_sku_comment where spu_id = #{spuId} and ratio = #{ratio}")
    public Integer findCommentCountByRatio(@Param("spuId") Integer spuId, @Param("ratio") String ratio );

}
