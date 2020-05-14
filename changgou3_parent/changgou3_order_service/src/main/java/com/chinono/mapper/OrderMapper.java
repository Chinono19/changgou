package com.chinono.mapper;

import com.chinono.po.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

@org.apache.ibatis.annotations.Mapper
public interface OrderMapper extends Mapper<Order> {

    /**
     * 修改订单的状态
     * @param sn
     * @param status
     */
    @Update("UPDATE tb_order SET STATUS = #{status} WHERE sn = #{sn}")
    void updateOrderStatus(@Param("sn") String sn, @Param("status") String status);
}
