package com.chinono;

import com.chinono.repository.SkuRepository;
import com.chinono.utils.BaseResult;
import com.chinono.vo.SearchSku;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class Demo3 {
    @Resource
    private ElasticsearchTemplate elasticsearchTemplate;
    @Test
    public void demo02(){
        //构建索引
        elasticsearchTemplate.createIndex(SearchSku.class);
        elasticsearchTemplate.putMapping(SearchSku.class);
    }


}
