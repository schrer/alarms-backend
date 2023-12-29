package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getBrigadeCount() {
        return brigadeCount;
    }

    public void setBrigadeCount(Integer brigadeCount) {
        this.brigadeCount = brigadeCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }

    public Map<Integer, UAFireBrigade> getFireBrigades() {
        return fireBrigades;
    }

    public void setFireBrigades(Map<Integer, UAFireBrigade> fireBrigades) {
        this.fireBrigades = fireBrigades;
    }
}
