package kr.co.searchproject.controller;


import kr.co.searchproject.domain.SearchKeyword;
import kr.co.searchproject.dto.SearchKeywordSaveRequestDto;
import kr.co.searchproject.service.SearchKeywordService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchKeywordController {
    private final SearchKeywordService searchKeywordService;

    @PostMapping("/api/keywords")
    public void createProduct(@RequestBody SearchKeywordSaveRequestDto keyword) {
        searchKeywordService.save(keyword);
    }

    @GetMapping("/api/search")
    public List<SearchKeyword> search(@RequestParam String keyword) {
        List<SearchKeyword> results = searchKeywordService.findByKeywordContaining(keyword);
        if (results != null && !results.isEmpty()) {
            for (SearchKeyword searchKeyword : results) {
                searchKeywordService.incrementSearchCount(searchKeyword.getId());
            }
        }
        return results;
    }

}
