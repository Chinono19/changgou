package com.chinono.repository;

import com.chinono.vo.SearchSku;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**  注意：ElasticsearchRepository ID的类型必须一致
 * Created by liangtong.
 */
public interface SkuRepository extends ElasticsearchRepository<SearchSku,Integer> {


}
