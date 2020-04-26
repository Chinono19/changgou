package com.chinono.service;

import com.chinono.mapper.ImpressionMapper;
import com.chinono.mapper.SkuCommontMapper;
import com.chinono.po.Impression;
import com.chinono.po.SkuComment;
import com.chinono.vo.CommentResult;
import com.chinono.vo.PageRequest;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class SkuCommentService  {

    @Resource
    private ImpressionMapper impressionMapper;

    @Resource
    private SkuCommontMapper skuCommontMapper;

    /**
     * 查询指定spu的所有评论
     * @return
     */
    public CommentResult findComments(Integer spuId, PageRequest pageRequest){
        //创建封装对象
        CommentResult commentResult = new CommentResult();
        List<Impression> impList = impressionMapper.findAllBySpuId(spuId);
        commentResult.setImpressions(impList);

        //好评度
        // 1） 好评评论数
        Integer goodsCount = skuCommontMapper.findCommentCountByRatio(spuId, "0");
        // 2） 中评评论数
        Integer commonCount = skuCommontMapper.findCommentCountByRatio(spuId, "1");
        // 3） 差评评论数
        Integer badCount = skuCommontMapper.findCommentCountByRatio(spuId, "2");
        // 所有的评论数
        Integer total = skuCommontMapper.findNumBySpuId(spuId);
        HashMap<String, String> ratioMap = new HashMap<>();
        if (total!=0){
            ratioMap.put("goods",String.format("%.2f",goodsCount*100f /total));
            ratioMap.put("common", String.format("%.2f", commonCount  * 100f  / total ));
            ratioMap.put("bad", String.format("%.2f", badCount  * 100f  / total ));
        }else {
            // 排除没有评论（被0除）
            ratioMap.put("goods","0");
            ratioMap.put("common","0");
            ratioMap.put("bad","0");
        }
        commentResult.setRatio(ratioMap);
        //分页
        List<SkuComment> skuCommentList = impressionMapper.findCommentsBySpuid(spuId);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        PageInfo<SkuComment> info = new PageInfo<>(skuCommentList);
        //封装到commentresult中去
        commentResult.setComments(info.getList());
        commentResult.setCommentCount(info.getTotal());
        return commentResult;
    }
}
