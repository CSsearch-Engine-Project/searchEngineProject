package kr.co.searchproject.loader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.co.searchproject.domain.SearchKeyword;
import kr.co.searchproject.repository.SearchKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final SearchKeywordRepository searchKeywordRepository;
    private final ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        if (searchKeywordRepository.count() == 0) {
            InputStream inputStream = new ClassPathResource("data/concepts.json").getInputStream();
            List<Map<String, Object>> concepts = objectMapper.readValue(
                    inputStream, new TypeReference<List<Map<String, Object>>>() {});

            for (Map<String, Object> concept : concepts) {
                String keyword = (String) concept.get("keyword");
                String topic = (String) concept.get("topic");

                @SuppressWarnings("unchecked")
                Map<String, String> level = (Map<String, String>) concept.get("level");

                @SuppressWarnings("unchecked")
                List<String> sources = (List<String>) concept.get("sources");

                SearchKeyword searchKeyword = SearchKeyword.builder()
                        .keyword(keyword)
                        .topic(topic)
                        .concept(level.get("concept"))
                        .intermediate(level.get("intermediate"))
                        .advanced(level.get("advanced"))
                        .sources(sources)
                        .searchCount(1)
                        .build();

                searchKeywordRepository.save(searchKeyword);
            }

            System.out.println("데이터 로드 완료: " + concepts.size() + "개 항목");
        }
    }
}