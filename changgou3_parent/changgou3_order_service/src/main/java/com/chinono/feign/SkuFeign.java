package com.chinono.feign;

import com.chinono.utils.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "cgwebservice",path = "/sku")
public interface SkuFeign {

    @PutMapping("/updateSkuNum")
    public BaseResult updateSkuNum(@RequestParam("skuId") Integer skuId, @RequestParam("count")Integer count);

}
