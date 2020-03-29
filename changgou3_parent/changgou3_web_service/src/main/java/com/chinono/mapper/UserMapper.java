package com.chinono.mapper;

import com.chinono.po.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import javax.naming.Name;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {


    @Select("SELECT * FROM tb_user WHERE username = #{username}")
    User findByUsername(@Param("username") String username);

    @Select("SELECT * FROM tb_user WHERE mobile = #{phone}")
    User findByPhone(@Param("phone") String phone);

    @Select("SELECT *FROM tb_user WHERE username = #{username}")
    User userLogin(User user);
}
