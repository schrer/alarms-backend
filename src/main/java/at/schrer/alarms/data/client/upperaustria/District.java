package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class District {
    private Integer id;
    @JsonProperty("text")
    private String name;
}
