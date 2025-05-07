package kr.co.searchproject.dto;

import kr.co.searchproject.domain.SearchKeyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeywordSaveRequestDto {

    private String keyword;
    private String topic;
    private String concept;
    private String intermediate;
    private String advanced;
    private List<String> sources;
    private String content;

    public static SearchKeyword of(SearchKeywordSaveRequestDto dto) {
        return SearchKeyword.builder()
                .keyword(dto.getKeyword())
                .topic(dto.getTopic())
                .concept(dto.getConcept())
                .intermediate(dto.getIntermediate())
                .advanced(dto.getAdvanced())
                .sources(dto.getSources())
                .content(dto.getContent())
                .searchCount(0)
                .build();
    }
}
