package com.chinono.controller;

import com.chinono.mapper.UserMapper;
import com.chinono.po.User;
import com.chinono.service.UserService;
import com.chinono.utils.BCrypt;
import com.chinono.utils.BaseResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

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

    @PostMapping("/register")
    public BaseResult register(@RequestBody User user){
        User finUser = userService.findByUsername(user.getUsername());
        User finbyPhone = userService.findByPhone(user.getMobile());
        if (finUser!=null){
            return BaseResult.error("用户名被占用");
        }
        if (finbyPhone!=null){
            return BaseResult.error("手机号被占用");
        }
        String key = "sms_register"+user.getMobile();
        String code = stringRedisTemplate.opsForValue().get(key);
        if (StringUtils.isEmpty(code)){
            return BaseResult.error("验证码无效");
        }
        if(!code.equals(user.getCode())){
            return BaseResult.error("验证码错误");
        }
        //all is right
        userService.register(user);
        return BaseResult.ok("注册成功");
    }

    @PostMapping("/userLogin")
    public BaseResult userLogin(@RequestBody User user){
        if (StringUtils.isEmpty(user.getUsername())){
            return BaseResult.error("用户名不能为空");
        }
        if (StringUtils.isEmpty(user.getPassword())){
            return BaseResult.error("密码不能为空");
        }
        if (StringUtils.isEmpty(user.getCode())){
            return BaseResult.error("验证码不能为空");
        }
        String key = "login" + user.getUsername();
        String scode = stringRedisTemplate.opsForValue().get(key);
        if (!user.getCode().equalsIgnoreCase(scode)){
            return BaseResult.error("验证码错误");
        }
        User ruser = userService.userLogin(user);
        if (ruser== null){
            return BaseResult.error("用户不存在");
        }

        return BaseResult.ok("登录成功");
    }


}
