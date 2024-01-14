package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
public class Einsatz {

    @JsonProperty("num1")
    private String id;

    @JsonProperty("startzeit")
    private Date startDate;

    // Tue, 12 Dec 2023 19:49:36 +0100
    @JsonProperty("inzeit")
    private Date endDate;

    @JsonProperty("cntfeuerwehren")
    private Integer brigadeCount;

    private String status;

    @JsonProperty("alarmstufe")
    private Integer level;

    @JsonProperty("einsatzart")
    private String type;

    @JsonProperty("wgs84")
    private GeoLocation geoLocation;

    @JsonProperty("feuerwehrenarray")
    private Map<Integer, UAFireBrigade> fireBrigades;

    @JsonProperty("bezirk")
    private District district;
}
