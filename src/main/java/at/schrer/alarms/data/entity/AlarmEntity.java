package at.schrer.alarms.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AlarmEntity {
    @Id
    private String id;
    private Date startTime;
    private Date endTime;
    private Integer level;
    private AlarmTypeEntity type;
    private Boolean ongoing;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private StateEntity state;
    @ManyToMany
    private List<FireBrigadeEntity> fireBrigades;
}
