package com.chinono;

import com.chinono.feign.SkuFeign;
import com.chinono.repository.SkuRepository;
import com.chinono.utils.BaseResult;
import com.chinono.vo.SearchSku;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CGSearchServiceApplication.class)
public class TestSkuFeign {

    @Resource
    private SkuFeign skuFeign;


    @Test
    public void demo01(){
        BaseResult baseResult = skuFeign.findAll();
        List<SearchSku> list = (List<SearchSku>)baseResult.getData();
        System.out.println(list);
    }

    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void demo02(){
        //构建索引
        elasticsearchTemplate.createIndex(SearchSku.class);
        elasticsearchTemplate.putMapping(SearchSku.class);
    }

    @Resource
    private SkuRepository skuRepository;
    @Test
    public void demo03(){
        //远程调用
        BaseResult<List<SearchSku>> baseResult = skuFeign.findAll();
        List<SearchSku> list = baseResult.getData();
        //将查询的数据添加es库
        skuRepository.saveAll(list);
    }

    @Test
    public void demo04(){
        //查询所有：自定义查询 + 支持多条件 ，并展示数据
        //1 条件查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //1.1 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        queryBuilder.withQuery(boolQueryBuilder);


        //2 查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());


        //3 展示结果
        System.out.println("总条数：" + page.getTotalElements());
        for(SearchSku searchSku : page.getContent()){
            System.out.println(searchSku);
        }
    }


    @Test
    public void demo05(){
        //查询所有：自定义查询 + 支持多条件 ，并展示数据
        //1 条件查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //1.1 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 1) 根据分类查询
        boolQueryBuilder.must( QueryBuilders.termQuery("catId", 76));

        //2) 根据品牌查询
        boolQueryBuilder.must( QueryBuilders.termQuery("brandId", 15127));

        queryBuilder.withQuery(boolQueryBuilder);


        //2 查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());


        //3 展示结果
        System.out.println("总条数：" + page.getTotalElements());
        for(SearchSku searchSku : page.getContent()){
            System.out.println(searchSku);
        }
    }

    @Test
    public void demo06(){
        //查询所有：自定义查询 + 支持多条件 ，并展示数据
        //1 条件查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //1.1 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        // 1) 根据分类查询
        boolQueryBuilder.must( QueryBuilders.termQuery("catId", 76));

        //2) 根据品牌查询
        boolQueryBuilder.must( QueryBuilders.termQuery("brandId", 15127));

        //3) 查询规格  机身颜色=粉色
        boolQueryBuilder.must( QueryBuilders.termQuery("specs.机身颜色.keyword", "粉色"));


        queryBuilder.withQuery(boolQueryBuilder);


        //2 查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());


        //3 展示结果
        System.out.println("总条数：" + page.getTotalElements());
        for(SearchSku searchSku : page.getContent()){
            System.out.println(searchSku);
        }
    }

    @Test
    public void demo07(){
        //查询所有：自定义查询 + 支持多条件 ，并展示数据
        //1 条件查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //1.1 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //4) 价格区间查询
        boolQueryBuilder.must( QueryBuilders.rangeQuery("price").gt(110000).lt(140000));


        queryBuilder.withQuery(boolQueryBuilder);


        //2 查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());


        //3 展示结果
        System.out.println("总条数：" + page.getTotalElements());
        for(SearchSku searchSku : page.getContent()){
            System.out.println(searchSku);
        }
    }


    @Test
    public void demo08(){
        //查询所有：自定义查询 + 支持多条件 ，并展示数据
        //1 条件查询构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        //1.1 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();


        //4) 价格区间查询
        boolQueryBuilder.must( QueryBuilders.rangeQuery("price").gt(110000).lt(140000));


        queryBuilder.withQuery(boolQueryBuilder);

        //分页
        int pageNum = 1;
        int pageSize = 3;
        queryBuilder.withPageable(PageRequest.of(pageNum, pageSize));

        //排序
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        //2 查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());
        //3 展示结果
        System.out.println("总条数：" + page.getTotalElements());
        for(SearchSku searchSku : page.getContent()){
            System.out.println(searchSku);
        }
    }


}
