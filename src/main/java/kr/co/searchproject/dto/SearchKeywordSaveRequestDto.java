package kr.co.searchproject.dto;

import kr.co.searchproject.domain.SearchKeyword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SearchKeywordSaveRequestDto {

    private String keyword;
    private String topic;
    private String concept;
    private String intermediate;
    private String advanced;
    private Map<String, String> level;
    private List<String> sources;

    public static SearchKeyword of(SearchKeywordSaveRequestDto dto) {
        return SearchKeyword.builder()
                .keyword(dto.getKeyword())
                .topic(dto.getTopic())
                .concept(dto.getConcept())
                .intermediate(dto.getIntermediate())
                .advanced(dto.getAdvanced())
                .level(dto.getLevel())
                .sources(dto.getSources())
                .searchCount(0)
                .build();
    }
}
