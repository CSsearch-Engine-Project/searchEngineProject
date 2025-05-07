package kr.co.searchproject.dto;

import kr.co.searchproject.domain.SearchKeyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeywordSaveRequestDto {

    private String keyword;
    private String content;

    public static SearchKeyword of(SearchKeywordSaveRequestDto keyword) {
        return SearchKeyword.builder()
                .keyword(keyword.getKeyword())
                .content(keyword.getContent())
                .searchCount(0)
                .build();
    }
}
