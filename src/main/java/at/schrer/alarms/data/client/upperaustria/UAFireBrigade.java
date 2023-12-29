package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UAFireBrigade {

    @JsonProperty("fwnr")
    private String id;
    @JsonProperty("fwname")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
