package com.chinono;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.chinono.utils.SmsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class DemoTest  {


    @Test
    public void demo1(){
        try {
            SendSmsResponse sendSmsResponse = SmsUtil.sendSms("18780376313", "123456");
            System.out.println(sendSmsResponse.getMessage());
            System.out.println(sendSmsResponse);
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
