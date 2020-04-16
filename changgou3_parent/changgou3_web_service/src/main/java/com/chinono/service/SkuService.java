package com.chinono.service;

import com.alibaba.fastjson.JSON;
import com.chinono.mapper.SkuCommontMapper;
import com.chinono.mapper.SkuMapper;
import com.chinono.po.Sku;
import com.chinono.vo.ESData;
import com.chinono.vo.SearchSku;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuCommontMapper skuCommontMapper;

    /**
     * 查询所有的sku
     * @return
     */
   public List<SearchSku> findSku(){
       List<Sku> list = skuMapper.findAllSku();

       //数据封装
       ArrayList<SearchSku> returnList = new ArrayList<>();
       for (Sku sku : list) {
           //1)创建ESData
           SearchSku esData = new SearchSku();
           // 2) 依次封装数据
           esData.setId( sku.getId() );
           esData.setLogo( sku.getSpu().getLogo() );
           esData.setSkuName( sku.getSkuName() );
           //所有需要被搜索的信息，“sku名称 + 规格列表 + 品牌”
           esData.setAll(sku.getSkuName() + sku.getSpecInfoIdTxt() + sku.getSpu().getBrand().getBrandName());
           esData.setOnSaleTime( sku.getSpu().getOnSaleTime());
           esData.setBrandId( sku.getSpu().getBrandId() );
           esData.setCatId( sku.getSpu().getCat3Id());
           Map specMap = JSON.parseObject(sku.getSpecInfoIdTxt(), Map.class);
           esData.setSpecs(specMap);
           esData.setPrice( sku.getPrice() );
           esData.setStock( sku.getStock() );
           esData.setDescription( sku.getSpu().getDescription() );
           esData.setPackages( sku.getSpu().getPackages() );
           esData.setAftersale( sku.getSpu().getAftersale() );

           //评论数
           Integer count = skuCommontMapper.findNumBySpuId(sku.getSpuId());
           esData.setCommentCount( count );
           esData.setSellerCount( 10 );
           // 3) 将ESData添加集合中
           returnList.add(esData);
       }

       return returnList;
   }

}
