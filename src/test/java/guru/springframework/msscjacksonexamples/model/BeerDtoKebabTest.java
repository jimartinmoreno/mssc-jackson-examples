package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Usamos la estrategia definida en el fichero application-snake.properties
 * 
 * spring.jackson.property-naming-strategy=SNAKE_CASE
 */
@ActiveProfiles("kebab")
@JsonTest
@Slf4j
public class BeerDtoKebabTest extends BaseTest {

    @Test
    void testKebab() throws JsonProcessingException {
        BeerDto dto = getDto();
        String json = objectMapper.writeValueAsString(dto);
        log.info(json);
    }
}
