package com.chinono.repository;

import com.chinono.povo.ESBook;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ESBookRepository extends ElasticsearchRepository<ESBook,Long> {

    // 通过title查询
    public List<ESBook> findByTitle(String title);

    // 价格区间
    public List<ESBook> findByPriceBetween(Float start,Float end);

    // 价格区间 , ID 排序
    public List<ESBook> findByPriceBetweenOrderByIdDesc(Float start,Float end);

    // 价格小于70
    public List<ESBook> findByPriceLessThanEqual(Float price);
}
