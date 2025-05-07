package kr.co.searchproject.service;

import kr.co.searchproject.domain.SearchKeyword;
import kr.co.searchproject.dto.SearchKeywordSaveRequestDto;
import kr.co.searchproject.repository.SearchKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchKeywordService {

    private final SearchKeywordRepository searchKeywordRepository;

    public void save(SearchKeywordSaveRequestDto keyword) {
        searchKeywordRepository.save(SearchKeywordSaveRequestDto.of(keyword));
    }

}
