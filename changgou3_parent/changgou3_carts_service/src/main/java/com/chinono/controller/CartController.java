package com.chinono.controller;

import com.chinono.config.JwtProperties;
import com.chinono.po.User;
import com.chinono.service.CartService;
import com.chinono.utils.BaseResult;
import com.chinono.utils.JwtUtils;
import com.chinono.vo.CartVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private HttpServletRequest request;
    @Resource
    private CartService cartService;

    @PostMapping("/addOrder")
    public BaseResult addOrder(@RequestBody CartVo cartVo){
        User loginUser = null;
        try {
            String token = request.getHeader("Authorization");
            loginUser = JwtUtils.getObjectFromToken(token, jwtProperties.getPublicKey(), User.class);
        }catch (Exception e){
            e.printStackTrace();
            return BaseResult.error("token无效");
        }
        //添加到购物车
        cartService.addCart(loginUser,cartVo);

        return BaseResult.ok("添加成功");
    }
}
