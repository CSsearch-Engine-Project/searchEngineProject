package kr.co.searchproject.repository;

import kr.co.searchproject.domain.SearchKeyword;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchKeywordRepository extends ElasticsearchRepository<SearchKeyword, Long> {

}
