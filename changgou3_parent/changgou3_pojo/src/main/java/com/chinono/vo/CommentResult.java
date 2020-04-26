package com.chinono.vo;

import com.chinono.po.Impression;
import com.chinono.po.SkuComment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CommentResult {
    private List<Impression> impressions; // 所有的印象
    private Map<String,String> ratio; //好评度
    private List<SkuComment> comments; //评论列表
    @JsonProperty("comment_count")
    private Long commentCount; //总评论数
}


