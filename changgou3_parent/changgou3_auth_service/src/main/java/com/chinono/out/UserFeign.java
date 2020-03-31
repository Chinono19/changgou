package com.chinono.out;


import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "cgwebservice",path = "/user")
public interface UserFeign {


}
