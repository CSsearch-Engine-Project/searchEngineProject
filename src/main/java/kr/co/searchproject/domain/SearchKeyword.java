package kr.co.searchproject.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@NoArgsConstructor
@Document(indexName = "search_keyword")
public class SearchKeyword {
    @Id
    private String id;

    @Field(type = FieldType.Text, analyzer = "standard")
    private String keyword;

    @Field(type = FieldType.Keyword)
    private String topic;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String concept;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String intermediate;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String advanced;

    @Field(type = FieldType.Keyword)
    private List<String> sources;

    @Field(type = FieldType.Integer)
    private Integer searchCount;

    @Field(type = FieldType.Date)
    private Date lastSearchedAt;

    @Builder
    public SearchKeyword(String keyword, String topic, String concept, String intermediate, String advanced,
                        List<String> sources, String content, Integer searchCount) {
        this.id = UUID.randomUUID().toString();
        this.keyword = keyword;
        this.topic = topic;
        this.concept = concept;
        this.intermediate = intermediate;
        this.advanced = advanced;
        this.sources = sources;
        this.searchCount = searchCount != null ? searchCount : 1;
        this.lastSearchedAt = new Date();
    }

    public void incrementSearchCount() {
        if (this.searchCount == null) {
            this.searchCount = 1;
        } else {
            this.searchCount++;
        }
        this.lastSearchedAt = new Date();
    }
}
