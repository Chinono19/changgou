package com.chinono.po;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Table(name="tb_address")
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id")
    private Integer userId;

    @Column(name="shr_name")
    @JsonProperty("shr_name")
    private String shrName;

    @Column(name="shr_mobile")
    @JsonProperty("shr_mobile")
    private String shrMobile;

    @Column(name="shr_province")
    @JsonProperty("shr_province")
    private String shrProvince;

    @Column(name="shr_city")
    @JsonProperty("shr_city")
    private String shrCity;

    @Column(name="shr_area")
    @JsonProperty("shr_area")
    private String shrArea;

    @Column(name="shr_address")
    @JsonProperty("shr_address")
    private String shrAddress;

    private Integer isdefault;
}
