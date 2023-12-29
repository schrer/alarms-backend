package at.schrer.alarms.data.client.upperaustria;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class GeoLocation {
    @JsonProperty("lat")
    private BigDecimal latitude;
    @JsonProperty("lng")
    private BigDecimal longitude;

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
