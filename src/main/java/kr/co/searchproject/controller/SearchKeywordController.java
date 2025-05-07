package kr.co.searchproject.controller;


import kr.co.searchproject.dto.SearchKeywordSaveRequestDto;
import kr.co.searchproject.service.SearchKeywordService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchKeywordController {
    private final SearchKeywordService searchKeywordService;

    @PostMapping("/api/keywords")
    public void createProduct(@RequestBody SearchKeywordSaveRequestDto keyword) {
        searchKeywordService.save(keyword);
    }

}
