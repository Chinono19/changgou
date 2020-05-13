package com.chinono.service;

import com.chinono.config.PayHelper;
import com.chinono.config.PayState;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PayService {

    @Resource
    private PayHelper payHelper;

    /**
     * 通过订单号，获得微信支付链接
     * @param sn
     * @return
     */
    public String payUrl(Long sn){
        //这里就是吧订单号设置为了 微信支付的交易 key 号
        String payUrl = payHelper.createPayUrl(sn);
        return payUrl;
    }


    /**
     * 通过订单号,获得支付的结果
     * @param sn
     * @return
     */
    public PayState query(Long sn){
        PayState payState = payHelper.queryOrder(sn);
        return payState;
    }
}
