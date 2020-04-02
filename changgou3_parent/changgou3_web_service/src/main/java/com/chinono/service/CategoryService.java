package com.chinono.service;

import com.chinono.mapper.CategoryMapper;
import com.chinono.po.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    public List<Category> findAll(){
        Example example = new Example(Category.class);
        example.setOrderByClause(" parentId asc ");
        List<Category> categoryList = categoryMapper.selectByExample(example);

        List<Category> returnList = new ArrayList<>();
        Map<Integer,Category> cacheMap = new HashMap();
        for (Category category : categoryList) {
            if (category.getParentId() == 0){
                returnList.add(category);
            }
            cacheMap.put(category.getId(), category);

            Category parentCategory = cacheMap.get(category.getParentId());
            if (parentCategory!=null){
                parentCategory.getChildren().add(category);
            }
        }
        return categoryList;
    }
}
