package at.schrer.alarms.data.client.bgl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BglResponseData {
    @JsonProperty("operations_current")
    private List<Operation> currentOperations;
    @JsonProperty("operations_12h")
    private List<Operation> operations12h;
    @JsonProperty("operations_24h")
    private List<Operation> operations24h;

    public List<Operation> getCurrentOperations() {
        return currentOperations;
    }

    public void setCurrentOperations(List<Operation> currentOperations) {
        this.currentOperations = currentOperations;
    }

    public List<Operation> getOperations12h() {
        return operations12h;
    }

    public void setOperations12h(List<Operation> operations12h) {
        this.operations12h = operations12h;
    }

    public List<Operation> getOperations24h() {
        return operations24h;
    }

    public void setOperations24h(List<Operation> operations24h) {
        this.operations24h = operations24h;
    }
}
