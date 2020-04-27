package com.chinono.feign;

import com.chinono.po.OneSkuResult;
import com.chinono.utils.BaseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "cgwebservice",path = "/sku")
public interface SkuFeign {

    /**
     * 查询详情
     * @param skuId
     * @return
     */
    @GetMapping("/goods/{skuId}")
    public BaseResult<OneSkuResult> findById(@PathVariable("skuId") Integer skuId);

}
