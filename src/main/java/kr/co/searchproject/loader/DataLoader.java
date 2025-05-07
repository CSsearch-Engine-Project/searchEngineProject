package kr.co.searchproject.loader;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.InputStream;
import java.util.List;

import kr.co.searchproject.domain.SearchKeyword;
import kr.co.searchproject.repository.SearchKeywordRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataLoader {

    private final SearchKeywordRepository repo;
    private final ObjectMapper mapper = new ObjectMapper();

    public DataLoader(SearchKeywordRepository repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void load() throws Exception {
        // resources/data/concepts.json 읽기
        InputStream is = getClass().getResourceAsStream("/data/concepts.json");
        if (is == null) {
            throw new IllegalStateException("concepts.json 파일을 찾을 수 없습니다.");
        }

        // JSON → List<SearchKeyword> 매핑
        List<SearchKeyword> list = mapper.readValue(is, new TypeReference<List<SearchKeyword>>() {});

        // Elasticsearch에 일괄 저장
        repo.saveAll(list);
        System.out.println("=== Elasticsearch에 " + list.size() + "건 색인 완료 ===");
    }
}