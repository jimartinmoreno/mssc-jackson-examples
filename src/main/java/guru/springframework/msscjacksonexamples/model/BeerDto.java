package guru.springframework.msscjacksonexamples.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BeerDto {

    /**
     * @JsonProperty lo utilizamos para indicar el nombre con el que queremos que se serialize la propiedad,
     * sobreescribe lo que se haya especificado en las estrategias
     */
    @JsonProperty(value = "beerId")
    @Null
    private UUID id;

    @NotBlank
    private String beerName;

    @NotBlank
    private String beerStyle;

    @Positive
    private Long upc;

    private BigDecimal price;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdatedDate;
}
