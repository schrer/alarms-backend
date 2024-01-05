package at.schrer.alarms.data.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
public class AlarmModel {
    private String id;
    private Date startTime;
    private Date endTime;
    private String status;
    private Integer level;
    private AlarmTypeModel type;
    private Boolean ongoing;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private List<FireBrigadeModel> fireBrigades;
}
