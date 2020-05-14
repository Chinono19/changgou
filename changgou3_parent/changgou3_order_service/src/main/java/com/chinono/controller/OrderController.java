package com.chinono.controller;

import com.chinono.config.JwtProperties;
import com.chinono.po.OrderVo;
import com.chinono.po.User;
import com.chinono.service.OrderService;
import com.chinono.utils.BaseResult;
import com.chinono.utils.JwtUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Resource
    private OrderService orderService;

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private HttpServletRequest request;



    @PostMapping("/addOrder")
    public BaseResult addOrder(@RequestBody OrderVo orderVo){
        //1 获得用户
        String token = request.getHeader("Authorization");
        User loginUser = null;
        try {
            loginUser = JwtUtils.getObjectFromToken(token, jwtProperties.getPublicKey(), User.class);
        } catch (Exception e) {
            return BaseResult.error("token无效或失效");
        }

        Long sn = orderService.addOrder(loginUser, orderVo);

        return BaseResult.ok("下单成功").append("sn",sn+"");
    }
}
