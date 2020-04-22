package com.chinono.service;

import com.alibaba.fastjson.JSON;
import com.chinono.mapper.*;
import com.chinono.po.*;
import com.chinono.vo.ESData;
import com.chinono.vo.SearchSku;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SkuService {

    @Resource
    private SkuMapper skuMapper;

    @Resource
    private SkuCommontMapper skuCommontMapper;

    @Resource
    private SpuMapper spuMapper;

    @Resource
    private CategoryMapper categoryMapper;
    @Resource
    private SkuPhotoMapper skuPhotoMapper;
    @Resource
    private SpecificationMapper specificationMapper;

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


    /**
     * 查询详情
     * @return
     */
   public OneSkuResult findSkuById(Integer skuId){
       OneSkuResult oneSkuResult = new OneSkuResult();

       //sku基本信息
       Sku sku = skuMapper.selectByPrimaryKey(skuId);
       oneSkuResult.setSkuid(sku.getId());
       oneSkuResult.setSpuid(sku.getSpuId());
       oneSkuResult.setGoodsName(sku.getSkuName());
       oneSkuResult.setPrice(sku.getPrice());
       oneSkuResult.setStock(sku.getStock());

       //spu 基本信息
       Spu spu = spuMapper.findById(sku.getSpuId());
       oneSkuResult.setOnSaleDate( spu.getOnSaleTime() );
       oneSkuResult.setDescription( spu.getDescription());
       oneSkuResult.setAftersale( spu.getAftersale() );

       // 评论
       Integer commentCount = skuCommontMapper.findNumBySkuId(skuId);
       Double commentLevel = skuCommontMapper.findAvgStarBySkuId(skuId);
       oneSkuResult.setCommentCount( commentCount );
       oneSkuResult.setCommentLevel( commentLevel );

       // 级分类
       Category cat1 = categoryMapper.selectByPrimaryKey(spu.getCat1Id());
       Category cat2 = categoryMapper.selectByPrimaryKey(spu.getCat2Id());
       Category cat3 = categoryMapper.selectByPrimaryKey(spu.getCat3Id());

       oneSkuResult.setCat1Info( cat1 );
       oneSkuResult.setCat2Info( cat2 );
       oneSkuResult.setCat3Info( cat3 );

       //第一张图片 的设置,sm big xbig 代表的是图片的展示大小
       Map<String,String> logoMap = new HashMap<>();
       logoMap.put("smlogo", spu.getLogo() );
       logoMap.put("biglogo", spu.getLogo() );
       logoMap.put("xbiglogo", spu.getLogo() );
       oneSkuResult.setLogo( logoMap );
       //其他图片的设置
       List<SkuPhoto> photoList = skuPhotoMapper.findSkuPhotoBySkuId(skuId);
       ArrayList<Map> photos = new ArrayList<>();
       for (SkuPhoto skuPhoto : photoList) {
           Map<String,String> photoTemp = new HashMap<>();
           photoTemp.put("smimg", skuPhoto.getUrl() );
           photoTemp.put("bigimg", skuPhoto.getUrl() );
           photoTemp.put("xbigimg", skuPhoto.getUrl() );
           photos.add( photoTemp );
       }
       oneSkuResult.setPhotos(photos);

       //spu对应的规格
       List<Specification> allSpec = specificationMapper.findAll(spu.getCat3Id());
       oneSkuResult.setSpecList(allSpec);

       //当前sku对应的规格信息
       HashMap<String, String> specMap = new HashMap<>();
       specMap.put("id_list",sku.getSpecInfoIdList());
       specMap.put("id_txt",sku.getSpecInfoIdTxt());
       oneSkuResult.setSpecInfo( specMap );

       // 所有的sku对应的规格信息
       List<Sku> allSku = skuMapper.findSkuBySpuId(sku.getSpuId());
       ArrayList<Map<String,String>> skuList = new ArrayList<>();
       for (Sku tempSku : allSku) {
           Map<String,String> tempMap = new HashMap<>();
           tempMap.put("skuid",tempSku.getId() + "");
           tempMap.put("id_list",tempSku.getSpecInfoIdList());
           skuList.add(tempMap);
       }
       oneSkuResult.setSkuList( skuList );

       return oneSkuResult;
   }


}
