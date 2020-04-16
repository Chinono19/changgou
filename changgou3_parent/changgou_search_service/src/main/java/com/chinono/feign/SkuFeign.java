package com.chinono.feign;

import com.chinono.utils.BaseResult;
import com.chinono.vo.ESData;
import com.chinono.vo.SearchSku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "cgwebservice",path = "/sku")
public interface SkuFeign {

    @GetMapping("/esData")
    public BaseResult<List<SearchSku>> findAll();
}
