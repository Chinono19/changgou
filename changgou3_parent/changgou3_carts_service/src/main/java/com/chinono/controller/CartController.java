package com.chinono.controller;

import com.chinono.config.JwtProperties;
import com.chinono.po.Cart;
import com.chinono.po.CartItem;
import com.chinono.po.User;
import com.chinono.service.CartService;
import com.chinono.utils.BaseResult;
import com.chinono.utils.JwtUtils;
import com.chinono.vo.CartVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

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

    @GetMapping("/queryCartList")
    public BaseResult queryCartList(){
        //校验用户
        User loginUser = null;
        try {
            String token = request.getHeader("Authorization");
            loginUser = JwtUtils.getObjectFromToken(token, jwtProperties.getPublicKey(), User.class);

        }catch (Exception e){
            return BaseResult.error("token无效");
        }
        //查询购物车
        Cart cart = cartService.queryCartList(loginUser);
        Collection<CartItem> values = cart.getData().values();
        return BaseResult.ok("查询成功",values);
    }
}
