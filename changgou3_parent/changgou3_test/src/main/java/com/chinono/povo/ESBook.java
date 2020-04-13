package com.chinono.povo;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Document(indexName = "czxy78_2",type = "book",shards = 4,replicas = 2)
@Data
public class ESBook {
    @Id
    private Long id;

    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    @Field(type = FieldType.Keyword,index = true)
    private String images;

    @Field(type = FieldType.Float)
    private Float price;

    public ESBook(Long id, String title, String images, Float price) {
        this.id = id;
        this.title = title;
        this.images = images;
        this.price = price;
    }

    public ESBook() {
    }
}
