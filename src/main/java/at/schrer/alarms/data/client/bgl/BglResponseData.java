package at.schrer.alarms.data.client.bgl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class BglResponseData {
    @JsonProperty("operations_current")
    private List<Operation> currentOperations;
    @JsonProperty("operations_12h")
    private List<Operation> operations12h;
    @JsonProperty("operations_24h")
    private List<Operation> operations24h;
}
