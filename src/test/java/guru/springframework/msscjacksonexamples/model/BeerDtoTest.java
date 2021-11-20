package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import java.io.IOException;

/**
 * @JsonTest Annotation for a JSON test that focuses only on JSON serialization.
 *
 * Using this annotation will disable full auto-configuration and instead apply only configuration relevant to JSON tests
 * (i.e. @JsonComponent, Jackson Module)
 *
 * By default, tests annotated with JsonTest will also initialize JacksonTester, JsonbTester and GsonTester fields.
 * More fine-grained control can be provided via the @AutoConfigureJsonTesters annotation.
 */
@JsonTest
@Slf4j
class BeerDtoTest extends BaseTest{

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();
        String jsonString = objectMapper.writeValueAsString(beerDto);
        log.info(jsonString);
    }

    @Test
    void testDeserialize() throws IOException {
        String json = "{\"id\":\"639c00ff-9993-4ec1-af12-8277c85f93bb\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2021-11-20T19:10:08.827+0100\",\"lastUpdatedDate\":\"2021-11-20T19:10:08.827+0100\"}";
        BeerDto dto = objectMapper.readValue(json, BeerDto.class);
        log.info(dto.toString());
    }
}