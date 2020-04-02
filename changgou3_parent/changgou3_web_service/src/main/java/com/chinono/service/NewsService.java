package com.chinono.service;

import com.chinono.mapper.NewsMapper;
import com.chinono.po.News;
import com.chinono.vo.NewsVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class NewsService {

    @Resource
    private NewsMapper newsMapper;

    public PageInfo<News> findAll(NewsVo newsvo) {
        PageHelper.startPage(newsvo.getPageNum(),newsvo.getPageSize());
        Example example = new Example(News.class);
        Example.Criteria criteria = example.createCriteria();
        if ("desc".equals(newsvo.getSortWay())){
            example.setOrderByClause("created_at desc");
        }else{
            example.setOrderByClause("created_at asc");
        }
        List<News> list = newsMapper.selectByExample(example);
        return new PageInfo<>(list);
    }
}
