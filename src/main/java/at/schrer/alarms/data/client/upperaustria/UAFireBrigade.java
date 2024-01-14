package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UAFireBrigade {

    @JsonProperty("fwnr")
    private String id;
    @JsonProperty("fwname")
    private String name;
}
