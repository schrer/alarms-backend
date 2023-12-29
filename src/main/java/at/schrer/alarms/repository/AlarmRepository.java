package at.schrer.alarms.repository;

import at.schrer.alarms.data.entity.AlarmEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface AlarmRepository extends CrudRepository<AlarmEntity, String> {
    Iterable<AlarmEntity> findByOngoing(boolean ongoing);
    Iterable<AlarmEntity> findByEndTimeAfterOrOngoingTrue(Date cutoff);
    Iterable<AlarmEntity> findByEndTimeAfterAndOngoing(Date cutoff, boolean ongoing);
}
