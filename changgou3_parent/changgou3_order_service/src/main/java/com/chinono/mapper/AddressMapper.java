package com.chinono.mapper;

import com.chinono.po.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface AddressMapper extends Mapper<Address> {


    /**
     * 更新指定用户的默认地址状态
     * @param userId
     * @param defaultValue
     */
    @Update("update tb_address set isdefault = #{defaultValue} where user_id = #{userId} ")
    public void updateDefault(@Param("userId") Integer userId , @Param("defaultValue") Integer defaultValue );
}
