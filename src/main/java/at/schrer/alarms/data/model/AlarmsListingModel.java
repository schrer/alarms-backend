package at.schrer.alarms.data.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AlarmsListingModel {
    private Integer numInvolvedBrigades;
    private Integer numAlarms;
    private List<AlarmModel> alarms;
}
