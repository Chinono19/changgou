package com.chinono.controller;

import com.chinono.config.JwtProperties;
import com.chinono.po.Address;
import com.chinono.po.User;
import com.chinono.service.AddressService;
import com.chinono.utils.BaseResult;
import com.chinono.utils.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @Resource
    private JwtProperties jwtProperties;

    @Resource
    private HttpServletRequest request;

    @GetMapping("/findAll")
    public BaseResult findAll(){
        //获得登录的用户名
        String token = request.getHeader("Authorization");
        User loginUser = null;
        try {
            loginUser  = JwtUtils.getObjectFromToken(token, jwtProperties.getPublicKey(), User.class);
        }catch (Exception e){
            return BaseResult.error("token error");
        }
        //通过用户查询所有的收货地址
        List<Address> list = addressService.findAllByUid(loginUser.getId());
        return BaseResult.ok("查询成功",list);
    }


    @PostMapping("/addAddress")
    public BaseResult addAddress(@RequestBody Address address){
        //获得用户
        String token = request.getHeader("Authorization");
        User loginUser = null;
        try {
            loginUser = JwtUtils.getObjectFromToken(token, jwtProperties.getPublicKey(), User.class);
        } catch (Exception e) {
            return BaseResult.error("token无效或失效");
        }
        //保存
        addressService.addAddress(loginUser , address);
        //返回
        return BaseResult.ok("添加成功");
    }
}
