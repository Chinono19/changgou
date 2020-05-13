package com.chinono.controller;


import com.chinono.config.PayState;
import com.chinono.service.PayService;
import com.chinono.utils.BaseResult;
import com.chinono.vo.PayRequest;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import sun.nio.ch.IOUtil;

import javax.annotation.Resource;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/pay")
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/payUrl")
    public BaseResult payUrl(@RequestBody PayRequest payRequest){
        //获得路径
        String payUrl = payService.payUrl(payRequest.getSn());
        //返回
        return BaseResult.ok("成功获得").append("wxurl",payUrl);
    }

    @PostMapping("/callBack")
    public BaseResult callBack(HttpServletRequest request,
                               HttpServletResponse response){
        String sn="";
        try {
            //获取请求体
            ServletInputStream inputStream = request.getInputStream();
            //吧流 转成字符串
            String xmlStr = IOUtils.toString(inputStream, "UTF-8");
            //吧字符串 转为map
            Map<String, String> map = WXPayUtil.xmlToMap(xmlStr);
            //获得订单号,修改状态
            if("SUCCESS".equals(map.get("return_code"))){
                 sn = map.get("out_trade_no");
                System.out.println(sn);
                //响应类型
                response.setContentType("text/xml");
                //响应内容
                response.getWriter().print("<xml><return_code><![CDATA[SUCCESS]]></return_code><return_msg><![CDATA[OK]]></return_msg></xml>");
            }else{
                System.out.println("错误了");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("callBck");
        return BaseResult.ok("成功交易-"+sn);
    }

    @GetMapping("/query/{sn}")
   public BaseResult query(@PathVariable("sn")Long sn){
        PayState payState = payService.query(sn);
        if (payState.getCode() == 1){
            //查询成功
            return BaseResult.ok(payState.getDesc());
        }else{
            return BaseResult.error(payState.getDesc());
        }
    }
}
