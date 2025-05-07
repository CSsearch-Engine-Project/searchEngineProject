package kr.co.searchproject.domain;

import java.util.Date;
import java.util.List;
import java.util.Map;
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

    @Field(type = FieldType.Text, analyzer = "nori")     // 한글 분석 예시
    private String concept;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String intermediate;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String advanced;

    @Field(type = FieldType.Nested)
    private Map<String, String> level;

    @Field(type = FieldType.Keyword)
    private List<String> sources;

    @Field(type = FieldType.Integer)
    private Integer searchCount;

    @Field(type = FieldType.Date)
    private Date lastSearchedAt;

    @Builder
    public SearchKeyword(String keyword, String topic, String concept, String intermediate, String advanced,
                        Map<String, String> level, List<String> sources, Integer searchCount) {
        this.id = keyword.toLowerCase().replaceAll("\\s+", "_");
        this.keyword = keyword;
        this.topic = topic;
        this.concept = concept;
        this.intermediate = intermediate;
        this.advanced = advanced;
        this.level = level;
        this.sources = sources;
        this.searchCount = searchCount != null ? searchCount : 0;
        this.lastSearchedAt = new Date();
    }
}
