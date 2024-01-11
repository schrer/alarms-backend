package at.schrer.alarms.sync.updater;

import at.schrer.alarms.client.UAAlarmsClient;
import at.schrer.alarms.data.client.upperaustria.EinsatzWrapper;
import at.schrer.alarms.data.client.upperaustria.UAFireBrigade;
import at.schrer.alarms.data.client.upperaustria.UAResponseData;
import at.schrer.alarms.data.entity.AlarmEntity;
import at.schrer.alarms.data.entity.AlarmTypeEntity;
import at.schrer.alarms.data.entity.FireBrigadeEntity;
import at.schrer.alarms.data.entity.StateEntity;
import at.schrer.alarms.exception.SynchronizationException;
import at.schrer.alarms.repository.AlarmRepository;
import at.schrer.alarms.repository.FireBrigadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class UAUpdater implements Updater {
    private static final Logger LOGGER = LoggerFactory.getLogger(UAUpdater.class);

    private final UAAlarmsClient alarmsClient;
    private final AlarmRepository alarmRepository;
    private final FireBrigadeRepository fireBrigadeRepository;

    public UAUpdater(UAAlarmsClient alarmsClient, AlarmRepository alarmRepository, FireBrigadeRepository fireBrigadeRepository) {
        this.alarmsClient = alarmsClient;
        this.alarmRepository = alarmRepository;
        this.fireBrigadeRepository = fireBrigadeRepository;
    }

    @Override
    public void synchronize() throws SynchronizationException {
        UAResponseData response = alarmsClient.getDailyReport();
        LOGGER.warn("Number of received alarms: {}", response.getNumAlarms());
        List<AlarmEntity> alarmEntities = response.getEinsaetze().values().stream()
                .map(this::toAlarmEntity)
                .toList();
        List<FireBrigadeEntity> involvedBrigades = getInvolvedFireBrigades(alarmEntities);

        fireBrigadeRepository.saveAll(involvedBrigades);
        alarmRepository.saveAll(alarmEntities);

        LOGGER.warn("Save done");
    }

    private AlarmEntity toAlarmEntity(EinsatzWrapper source){
        var unwrapped = source.getEinsatz();
        return AlarmEntity.builder()
                .id(unwrapped.getId())
                .startTime(unwrapped.getStartDate())
                .endTime(unwrapped.getEndDate())
                .fireBrigades(toFireBrigadeEntities(unwrapped.getFireBrigades().values()))
                .ongoing(unwrapped.getEndDate() == null)
                .type(toAlarmType(unwrapped.getType()))
                .level(unwrapped.getLevel())
                .longitude(unwrapped.getGeoLocation().getLongitude())
                .latitude(unwrapped.getGeoLocation().getLatitude())
                .state(StateEntity.UPPER_AUSTRIA)
                .build();
    }

    private List<FireBrigadeEntity> toFireBrigadeEntities(Collection<UAFireBrigade> source){
        return source.stream()
                .map(it -> FireBrigadeEntity.builder()
                        .id(it.getId())
                        .name(it.getName())
                        .state(StateEntity.UPPER_AUSTRIA)
                        .build()
                )
                .toList();
    }

    private AlarmTypeEntity toAlarmType(String source){
        return switch (source){
            case "BRAND" -> AlarmTypeEntity.FIRE;
            case "TEE" -> AlarmTypeEntity.TECHNICAL;
            default -> AlarmTypeEntity.OTHER;
        };
    }

    private List<FireBrigadeEntity> getInvolvedFireBrigades(List<AlarmEntity> alarms){
        return alarms.stream()
                .flatMap(it -> it.getFireBrigades().stream())
                .distinct()
                .toList();
    }
}
