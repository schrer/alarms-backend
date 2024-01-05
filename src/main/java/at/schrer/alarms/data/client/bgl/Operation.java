package at.schrer.alarms.data.client.bgl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;
public class Operation {
    private String district;
    @JsonProperty("fire_services")
    private String fireServices;
    private String code;
    @JsonProperty("place_of_operation")
    private String placeOfOperation;
    private long start;
    private long end;
    @JsonProperty("num_fire_services")
    private int numFireServices;
    @JsonProperty("num_vehicles")
    private int numVehicles;
    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm")
    private Date updatedAt;
    @JsonProperty("fw_locations")
    private List<String> fireServiceLocations;
    private boolean info;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getFireServices() {
        return fireServices;
    }

    public void setFireServices(String fireServices) {
        this.fireServices = fireServices;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPlaceOfOperation() {
        return placeOfOperation;
    }

    public void setPlaceOfOperation(String placeOfOperation) {
        this.placeOfOperation = placeOfOperation;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public int getNumFireServices() {
        return numFireServices;
    }

    public void setNumFireServices(int numFireServices) {
        this.numFireServices = numFireServices;
    }

    public int getNumVehicles() {
        return numVehicles;
    }

    public void setNumVehicles(int numVehicles) {
        this.numVehicles = numVehicles;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<String> getFireServiceLocations() {
        return fireServiceLocations;
    }

    public void setFireServiceLocations(List<String> fireServiceLocations) {
        this.fireServiceLocations = fireServiceLocations;
    }

    public boolean isInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
    }
}
