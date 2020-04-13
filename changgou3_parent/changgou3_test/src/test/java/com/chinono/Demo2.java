package com.chinono;

import com.chinono.povo.ESBook;
import com.chinono.repository.ESBookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
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
        list.add(new ESBook(1L,"小康子历险记","666.jpg",68.8f));
        list.add(new ESBook(2L,"阿飞快跑III","678.jpg",88.8f));
        list.add(new ESBook(3L,"月月不走","890.jpg",48.8f));

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
}
