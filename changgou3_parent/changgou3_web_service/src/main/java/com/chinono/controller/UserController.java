package com.chinono.controller;

import com.chinono.po.User;
import com.chinono.service.UserService;
import com.chinono.utils.BaseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/checkusername")
    public BaseResult checkUsername(@RequestBody User user){
        //查询
        User findUser = userService.findByUsername(user.getUsername());
        if(findUser != null){
            return BaseResult.error("用户名以及存在了");
        }else{
            return BaseResult.ok("用户名可用");
        }

    }

    @PostMapping("/checkPhone")
    public BaseResult checkPhone(@RequestParam(name="phone")String phone){
        User user  = userService.findByPhone(phone);
        if (user == null){
            return BaseResult.ok("手机号可用");
        }else{
            return BaseResult.error("手机号不可用");
        }
    }

}
