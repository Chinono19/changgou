package com.chinono.service;

import com.chinono.mapper.OrderGoodsMapper;
import com.chinono.mapper.OrderMapper;
import com.chinono.po.OrderVo;
import com.chinono.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderGoodsMapper orderGoodsMapper;

    @Resource
    private OrderMapper orderMapper;

    /**
     * TODO 下订单
     * @param user
     * @param orderVo
     * @return
     */
    public Long addOrder(User user, OrderVo orderVo){

        return 81192L;
    }
}
