package com.chinono.po;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by liangtong.
 */
@Table(name="tb_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自动增长
    private Integer id;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

    private String email;
    private String mobile;
    private String username;

    private String password;
    private String face;
    private Integer expriece;

    @Transient //临时数据
    private String code; //验证码

}

