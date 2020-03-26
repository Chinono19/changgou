package com.chinono.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.chinono.po.User;
import com.chinono.utils.BaseResult;
import com.chinono.utils.SmsUtil;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sms")
public class SmsController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/sendSms")
    public BaseResult sendSms(@RequestBody User user){
        String randomStr = RandomStringUtils.randomNumeric(4);
        //将验证码存放redis ..
        String key = "sms_register"+user.getMobile();
        stringRedisTemplate.opsForValue().set(key,randomStr,5, TimeUnit.MINUTES);

        //以短信的方式 将验证码发给用户
        try {
            SendSmsResponse sendSmsResponse = SmsUtil.sendSms(user.getMobile(),randomStr);
            //处理数据
            if ("OK".equals(sendSmsResponse.getCode())){
                return BaseResult.ok("发送成功");
            }else {
                return BaseResult.error(sendSmsResponse.getMessage());
            }
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return BaseResult.error("短信发送失败");
    }
}
