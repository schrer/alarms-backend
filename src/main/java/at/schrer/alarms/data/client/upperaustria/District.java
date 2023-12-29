package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;

public class District {
    private Integer id;
    @JsonProperty("text")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
