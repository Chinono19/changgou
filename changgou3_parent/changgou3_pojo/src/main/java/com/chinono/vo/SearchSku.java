package com.chinono.vo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.Map;
/** SearchSku 类与 pojo/vo/ESData 成员相同
 *  没有使用ESData，作为封装对象
 *  SearchSku和 ES 有对应关系（SearchSku最终需要存放到Elasticsearch）
 * Created by liangtong.
 */
@Data
@Document(indexName = "changgou78", type="sku")
public class SearchSku {

    @Id
    private Integer id; // skuId
    @Field(type = FieldType.Text)
    private String logo;//图片地址
    @Field(type = FieldType.Text)
    private String skuName;//sku名字
    @Field(type = FieldType.Text ,analyzer = "ik_max_word")
    private String all; // 所有需要被搜索的信息，包含标题，分类，甚至品牌
    @Field(type = FieldType.Date)
    private Date onSaleTime;//商家时间
    //品牌编号
    @Field(type = FieldType.Integer)
    private Integer brandId;
    // 分类id
    @Field(type = FieldType.Integer)
    private Integer catId;

    //规格列表
    //@IndexDynamicSettings
    private Map<String, Object> specs;// 可搜索的规格参数，key是参数名，值是参数值
    @Field(type = FieldType.Double)
    private Double price;// 价格
    @Field(type = FieldType.Text)
    private String spuName;
    @Field(type = FieldType.Integer)
    private Integer stock;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Text)
    private String packages;//规格与包装
    @Field(type = FieldType.Text)
    private String aftersale;//售后保障
    @Field(type = FieldType.Text)
    private String midlogo;
    //评价数
    @Field(type = FieldType.Integer)
    private Integer commentCount;
    // 销量
    @Field(type = FieldType.Integer)
    private Integer sellerCount;

}