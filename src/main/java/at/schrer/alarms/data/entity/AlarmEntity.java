package at.schrer.alarms.data.entity;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AlarmEntity {
    private @Id String id;
    private Date startTime;
    private Date endTime;
    private Integer level;
    private AlarmTypeEntity type;
    private Boolean ongoing;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private StateEntity state;
    private List<FireBrigadeEntity> fireBrigades;
}
