package com.chinono;

import com.chinono.povo.ESBook;
import com.chinono.repository.ESBookRepository;
import org.aspectj.weaver.ast.Var;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class Demo2 {

    @Test
    public void demo(){
        System.out.println("嘿嘿嘿");

    }


    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void demo01(){
        elasticsearchTemplate.createIndex(ESBook.class);
        elasticsearchTemplate.putMapping(ESBook.class);
    }

    @Test
    public void demo02(){
        //删除索引
        elasticsearchTemplate.deleteIndex(ESBook.class);
    }

    @Resource
    private ESBookRepository esBookRepository;

    @Test
    public void demo03(){
        //准备数据
        ESBook esBook = new ESBook();
        esBook.setId(10L);
        esBook.setTitle("坏蛋是怎样炼成的");
        esBook.setImages("3.jpg");
        esBook.setPrice(998f);
        //添加
        esBookRepository.save(esBook);
    }

    @Test
    public void demo04(){
        //批量添加
        //准备数据
        List<ESBook> list = new ArrayList<>();

        list.add(new ESBook(10L,"阿飞快跑II","678.jpg",88.8f));
        list.add(new ESBook(2L,"阿飞快跑I","678.jpg",88.8f));
        //添加
        esBookRepository.saveAll( list ) ;
    }


    @Test
    public void demo05(){
        Iterable<ESBook> list = esBookRepository.findAll();
        Iterator<ESBook> iterator = list.iterator();
        while (iterator.hasNext()){
            ESBook esBook = iterator.next();
            System.out.println(esBook);
        }
    }

    @Test
    public void demo06(){
        Optional<ESBook> opt = esBookRepository.findById(1L);
        ESBook esBook = opt.get();
        System.out.println(esBook);
    }

    @Test
    public void demo07(){
        List<ESBook> list = esBookRepository.findByTitle("月月不走");
        System.out.println(list);
    }

    @Test
    public void demo08(){
        List<ESBook> list = esBookRepository.findByPriceBetween(50f,70f);
        System.out.println(list);
    }

    @Test
    public void demo09(){
        List<ESBook> list = esBookRepository.findByPriceBetweenOrderByIdDesc(50f,70f);
        System.out.println(list);
    }

    @Test
    public void demo10(){
        List<ESBook> list = esBookRepository.findByPriceLessThanEqual(68.8f);
        System.out.println(list);
    }

    //查询title为“java编程思想
    @Test
    public void demo11(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.matchQuery("title","阿飞快跑"));
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());
        //获取查询总个数
        long total = page.getTotalElements();
        System.out.println(total);
        //查询内容
        for (ESBook esBook : page) {
            System.out.println(esBook);
        }
    }


    //#采用多条件进行查询，查询title为 “阿飞快跑”,且不含“III”
    @Test
    public void demo12(){
        //查询条件构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 构建 bool 多条件查询
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must( QueryBuilders.matchQuery("title","阿飞快跑"));
        boolQueryBuilder.mustNot( QueryBuilders.matchQuery("title","III"));

        queryBuilder.withQuery( boolQueryBuilder );

        //查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());

        //处理
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }

    }


    //#需求：查询“P月月不走” ，以及 “小康子历险记”相关数据
    @Test
    public void demo13(){
        // 查询条件构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 多条件查询 -- 或关系
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.should(QueryBuilders.matchQuery("title","P月月不走"));
        boolQueryBuilder.should(QueryBuilders.matchQuery("title","小康子历险记"));

        queryBuilder.withQuery( boolQueryBuilder );

        // 查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());

        // 处理结果
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }
    }

    //#需求：查询价格为68.8 信息
    @Test
    public void demo14(){
        // 查询条件构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 精准查询条件
        queryBuilder.withQuery(QueryBuilders.termQuery("price",68.8));

        // 查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());

        // 处理结果
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }
    }

    //# 需求：查询价格在60-90之间
    @Test
    public void demo15(){
        // 构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 范围条件
        queryBuilder.withQuery( QueryBuilders.rangeQuery("price").gte(60).lte(90)  );

        // 查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());

        // 处理结果
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }

    }

    //分页
    @Test
    public void demo16(){
        // 构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        // 分页条件
        int pageNum = 1;           //第几页
        int size = 2;           //每页显示个数
        queryBuilder.withPageable(PageRequest.of(pageNum ,size));

        // 查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());

        // 结果处理
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }
    }

    //价格降序
    @Test
    public void demo17(){
        // 构建器
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 排序条件
        queryBuilder.withSort(SortBuilders.fieldSort("price").order(SortOrder.DESC));
        // 查询
        Page<ESBook> page = esBookRepository.search(queryBuilder.build());
        // 处理结果
        System.out.println("总条数：" + page.getTotalElements());
        System.out.println("总分页：" + page.getTotalPages());

        for(ESBook esBook : page ){
            System.out.println(esBook);
        }
    }
}
