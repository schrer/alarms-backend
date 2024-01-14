package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class GeoLocation {
    @JsonProperty("lat")
    private BigDecimal latitude;
    @JsonProperty("lng")
    private BigDecimal longitude;
}
