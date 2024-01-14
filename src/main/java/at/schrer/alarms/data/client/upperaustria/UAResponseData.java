package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UAResponseData {
    private String title;

    // e.g. Tue, 12 Dec 2023 20:58:07 +0100
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "EEE, dd MMM yyyy HH:mm:ss Z")
    private Date pubDate;

    @JsonProperty("cnt_feuerwehren")
    private Integer numFireBrigades;

    @JsonProperty("cnt_einsaetze")
    private Integer numAlarms;
    private Map<Integer, EinsatzWrapper> einsaetze = new HashMap<>();
}
