package com.chinono.service;

import com.chinono.mapper.SpecificationMapper;
import com.chinono.po.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class SpecificationService {

    @Resource
    private SpecificationMapper specificationMapper;

    public List<Specification> findAll(Integer categoryId){
        List<Specification> list = specificationMapper.findAll(categoryId);
        return list;
    }
}
