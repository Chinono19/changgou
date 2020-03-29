package com.chinono.service;

import com.chinono.mapper.UserMapper;
import com.chinono.po.User;
import com.chinono.utils.BCrypt;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

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

    /**
     * 用户注册
     * @param user
     */
    public void register (User user){
        String npwd = BCrypt.hashpw(user.getPassword());
        user.setPassword(npwd);
        user.setCreatedAt(new Date());
        user.setUpdatedAt(user.getCreatedAt());

        userMapper.insert(user);
    }

    public User userLogin(User user) {
        User u = userMapper.userLogin(user);
        if (u == null){
            return null;
        }
        boolean b = BCrypt.checkpw(user.getPassword(), u.getPassword());
        return b?u:null;
    }
}
