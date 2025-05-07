package kr.co.searchproject.repository;

import kr.co.searchproject.domain.SearchKeyword;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchKeywordRepository extends ElasticsearchRepository<SearchKeyword, String> {
    List<SearchKeyword> findByKeywordContaining(String keyword);
}
