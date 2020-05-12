package com.chinono.weixin;

import com.github.wxpay.sdk.WXPay;

import java.util.HashMap;
import java.util.Map;

public class TestWXPayUnfiedOrder {
    public static void main(String[] args) throws Exception {
        //下订单

        //1 准备配置类
        MyWXPayConfig config = new MyWXPayConfig();
        //2 准备核心类
        WXPay wxPay = new WXPay(config);
        //3 准备参数
        //3 准备参数
        Map<String,String> map = new HashMap<>();
        map.put("body","商品描述0001");             //商品描述
        map.put("out_trade_no","20200511001");     //商户订单号
        map.put("total_fee","1");                   //标价金额
        map.put("spbill_create_ip","127.0.0.1");   //终端IP
        map.put("notify_url","http://www.czxy.com"); //通知地址(回调)
        map.put("trade_type","NATIVE ");           //交易类型
        //4 调用方法
        Map<String, String> result = wxPay.unifiedOrder(map);

        //5 处理结果
        System.out.println("返回状态码：" + result.get("return_code"));
        System.out.println("返回信息：" + result.get("return_msg"));
        System.out.println("业务结果：" + result.get("result_code"));
        System.out.println("二维码链接：" + result.get("code_url"));
    }
}
