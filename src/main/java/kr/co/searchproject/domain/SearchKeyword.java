package kr.co.searchproject.domain;

import java.util.Date;
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

    @Field(type = FieldType.Text, analyzer = "standard")
    private String content;

    @Field(type = FieldType.Integer)
    private Integer searchCount;

    @Field(type = FieldType.Date)
    private Date lastSearchedAt;

    @Builder
    public SearchKeyword(String keyword, String content, Integer searchCount) {
        this.id = keyword.toLowerCase().replaceAll("\\s+", "_");
        this.keyword = keyword;
        this.content = content;
        this.searchCount = searchCount;
    }
}
