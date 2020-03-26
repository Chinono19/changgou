package com.chinono.service;

import com.chinono.mapper.UserMapper;
import com.chinono.po.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService  {
    @Resource
    private UserMapper userMapper;


    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
