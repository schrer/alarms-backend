package at.schrer.alarms.data.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FireBrigadeModel {
    private String id;
    private String name;
    private StateModel state;
}
