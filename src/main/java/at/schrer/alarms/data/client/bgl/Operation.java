package at.schrer.alarms.data.client.bgl;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Operation {
    @JsonProperty("operation_id")
    private String id;
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
}
