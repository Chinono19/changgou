package com.chinono.feign;

import com.chinono.utils.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(value = "cgwebservice",path = "/sku")
public interface SkuFeign {

    @PutMapping("/updateSkuNum/{skuId}")
    public BaseResult updateSkuNum(@PathVariable("skuId")Integer skuId, Integer count);

}
