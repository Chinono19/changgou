package com.chinono.service;

import com.chinono.mapper.BrandMapper;
import com.chinono.po.Brand;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class BrandService {

    @Resource
    private BrandMapper brandMapper;

    public List<Brand> findAll(Integer categoryId){
        List<Brand> list = brandMapper.findAll(categoryId);
        return list;
    }


}
