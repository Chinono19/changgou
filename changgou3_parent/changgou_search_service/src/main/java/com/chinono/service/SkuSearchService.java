package com.chinono.service;

import com.chinono.repository.SkuRepository;
import com.chinono.vo.ReturnSku;
import com.chinono.vo.SearchSku;
import com.chinono.vo.SearchVo;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class SkuSearchService {
    @Resource
    private SkuRepository skuRepository;

    /**
     * 这个是 单条件查询
     * @param searchVo
     * @return
     */
    public Map search(SearchVo searchVo){
        //条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();

        queryBuilder.withQuery(boolQueryBuilder);
        //查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());
        //处理数据
        long count = page.getTotalElements();
        ArrayList<ReturnSku> list = new ArrayList<>();
        for (SearchSku searchSku : page.getContent()) {
            ReturnSku returnSku = new ReturnSku();
            //封装数据
            returnSku.setGoodsName(searchSku.getSkuName());
            returnSku.setPrice(searchSku.getPrice());
            returnSku.setMidlogo(searchSku.getLogo());
            returnSku.setCommentCount(searchSku.getCommentCount());
            //添加到list
            list.add(returnSku);
        }
        HashMap map = new HashMap();
        map.put("count",count);
        map.put("list",new ArrayList<>());
        return map;
    }

    /**
     * 多条件查询
     * @param searchVo
     * @return
     */
    public  Map search2(SearchVo searchVo){
        //拼接查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("catId",searchVo.getCatId()));
        if (StringUtils.isNotBlank(searchVo.getKeyword())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("all",searchVo.getKeyword()));
        }
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(boolQueryBuilder);
        //查询
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());

        long count = page.getTotalElements();
        ArrayList<ReturnSku> list = new ArrayList<ReturnSku>();
        for (SearchSku searchSku : page.getContent()) {
            ReturnSku returnSku = new ReturnSku();
            //封装数据
            returnSku.setGoodsName(searchSku.getSkuName());
            returnSku.setPrice(searchSku.getPrice());
            returnSku.setMidlogo(searchSku.getLogo());
            returnSku.setCommentCount(searchSku.getCommentCount());
            //添加到list
            list.add(returnSku);
        }
        //5 封装数据
        Map map = new HashMap();
        map.put("count", count);
        map.put("list", list);
        return map;
    }


    /**
     * 完整的多条件查询
     * @param searchVo
     * @return
     */
    public Map search3(SearchVo searchVo){
        //拼凑多条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (searchVo.getCatId()!=null){
            boolQueryBuilder.must(QueryBuilders.termQuery("catId",searchVo.getCatId()));
        }
        if (searchVo.getBrandId() != null){
            boolQueryBuilder.must( QueryBuilders.termQuery("brandId",searchVo.getBrandId()));
        }
        if (StringUtils.isNotBlank(searchVo.getKeyword())){
            boolQueryBuilder.must(QueryBuilders.matchQuery("all",searchVo.getKeyword()));
        }
        //规范查询 map.key = '...' map.value='..'
        if (searchVo.getSpecList()!=null){
            for (String key : searchVo.getSpecList().keySet()) {
                String value = searchVo.getSpecList().get(key);
                if(!"".equals(value)){
                    boolQueryBuilder.must(QueryBuilders.termQuery("specs."+key+".keyword",value));
                }
            }
        }
        //价格区间
        if (searchVo.getMinPrice()!=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").gte(searchVo.getMinPrice()));
        }
        if (searchVo.getMaxPrice()!=null){
            boolQueryBuilder.must(QueryBuilders.rangeQuery("price").lte(searchVo.getMaxPrice()));
        }
        //查询
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(boolQueryBuilder);
        queryBuilder.withPageable(PageRequest.of(searchVo.getPageNum()-1,searchVo.getPageSize()));
        //排序
        HashMap<String, String> tempMap = new HashMap<>();
        tempMap.put("xl","sellerCount");        //销量
        tempMap.put("jg","price");              //价格
        tempMap.put("pl","commentCount");       //评论
        tempMap.put("sj","onSaleTime");         //时间
        String proName = tempMap.get(searchVo.getSortBy());
        //如果存在进行排序
        if (StringUtils.isNotBlank(proName)){
            FieldSortBuilder fieldSortBuilder = SortBuilders.fieldSort(proName);
            if ("desc".equals(searchVo.getSortWay())){
                fieldSortBuilder.order(SortOrder.DESC);
            }else{
                fieldSortBuilder.order(SortOrder.ASC);
            }
            queryBuilder.withSort( fieldSortBuilder) ;
        }
        // 查询结果
        Page<SearchSku> page = skuRepository.search(queryBuilder.build());
        //处理数据
        long count = page.getTotalElements();
        ArrayList<ReturnSku> list = new ArrayList<>();
        for (SearchSku searchSku : page.getContent()) {
            ReturnSku returnSku = new ReturnSku();
            // 2) 封装数据
            returnSku.setGoodsName(searchSku.getSkuName());
            returnSku.setPrice(searchSku.getPrice());
            returnSku.setMidlogo(searchSku.getLogo());
            returnSku.setCommentCount(searchSku.getCommentCount());

            // 3) 添加list
            list.add(returnSku);
        }
        // 封装数据
        Map map = new HashMap();
        map.put("count", count);
        map.put("list", list);
        return map;
    }



}
