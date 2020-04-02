package com.chinono.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name="tb_news")
@Data
public class News {
    @Id
    private Integer id;

    private String title;
    private String content;
    private String author;
    @Column(name="created_at")
    private Date createdAt;
    @Column(name="updated_at")
    private Date updatedAt;

}