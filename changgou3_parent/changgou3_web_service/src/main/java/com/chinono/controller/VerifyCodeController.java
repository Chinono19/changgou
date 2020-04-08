package com.chinono.controller;

import org.aspectj.weaver.ast.Var;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by chinono
 * Data 2020.03.10
 * email:2401691738@qq.com
 */
@Controller
@RequestMapping("/verifycode")
public class VerifyCodeController {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 用于生产随机的验证码
     * @param username 用户名
     * @param response 响应对象
     * @throws IOException
     */
    @GetMapping
    public void verifyCode(@RequestParam(name = "username") String username, HttpServletResponse response) throws IOException {
        //1 生产验证码
        //字体只显示大写，去掉了1,0,i,o几个容易混淆的字符
        String VERIFY_CODES = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ";

        int IMG_WIDTH = 72;
        int IMG_HEIGTH = 27;
        Random random = new Random();
        //创建图片
        BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGTH, BufferedImage.TYPE_INT_RGB);

        //画板
        Graphics g = image.getGraphics();
        //填充背景
        g.setColor(Color.WHITE);
        g.fillRect(1,1,IMG_WIDTH-2,IMG_HEIGTH-2);
        //设置字体
        g.setFont(new Font("楷体",Font.BOLD,25));


        //-login
        StringBuilder builder = new StringBuilder();
        //绘制4个随机字符
        for(int i = 1 ; i <= 4 ; i ++){
            //随机颜色
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            int len = random.nextInt(VERIFY_CODES.length());
            //一个随机字符
            String str = VERIFY_CODES.substring(len,len+1);
            builder.append(str);
            g.drawString(str, IMG_WIDTH / 6 * i , 22 );
        }

        //保存到redis中
        String code = builder.toString();
        String key = "login" + username;
        stringRedisTemplate.opsForValue().set(key,code,5, TimeUnit.MINUTES);

        // 生成随机干扰线
        for (int i = 0; i < 30; i++) {
            //随机颜色
            g.setColor(new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
            int x = random.nextInt(IMG_WIDTH - 1);
            int y = random.nextInt(IMG_HEIGTH - 1);
            int x1 = random.nextInt(12) + 1;
            int y1 = random.nextInt(6) + 1;
            g.drawLine(x, y, x - x1, y - y1);
        }

        //2 响应到浏览器
        ImageIO.write(image,"jpeg", response.getOutputStream());
    }
}
