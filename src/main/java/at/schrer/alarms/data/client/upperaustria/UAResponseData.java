package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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

    public String getTitle() {
        return title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public Integer getNumFireBrigades() {
        return numFireBrigades;
    }

    public Integer getNumAlarms() {
        return numAlarms;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public void setNumFireBrigades(Integer numFireBrigades) {
        this.numFireBrigades = numFireBrigades;
    }

    public void setNumAlarms(Integer numAlarms) {
        this.numAlarms = numAlarms;
    }

    public Map<Integer, EinsatzWrapper> getEinsaetze() {
        return einsaetze;
    }

    public void setEinsaetze(Map<Integer, EinsatzWrapper> einsaetze) {
        this.einsaetze = einsaetze;
    }
}
