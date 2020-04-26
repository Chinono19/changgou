package com.chinono.mapper;

import com.chinono.po.Impression;
import com.chinono.po.SkuComment;
import org.apache.ibatis.annotations.*;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface ImpressionMapper extends Mapper<Impression> {


    @Select("select * from tb_impression where spu_id = #{spuId}")
    public List<Impression> findAllBySpuId(@Param("spuId")Integer spuId);






    /**
     * 查找指定spu所有的评论
     * @param spuId
     * @return
     */
    @Select("select * from tb_sku_comment where spu_id = #{spuId}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "updatedAt", column = "updated_at"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "spuId", column = "spu_id"),
            @Result(property = "skuId", column = "sku_id"),
            @Result(property = "ratio", column = "ratio"),
            @Result(property = "specList", column = "spec_list"),
            @Result(property = "content", column = "content"),
            @Result(property = "star", column = "star"),
            @Result(property = "isShow", column = "isshow"),
            @Result(property = "sn", column = "sn"),
            @Result(property = "user", one = @One(select="com.chinono.mapper.UserMapper.selectByPrimaryKey"), column = "user_id"),
    })
    public List<SkuComment> findCommentsBySpuid(@Param("spuId") Integer spuId);
}
