package at.schrer.alarms.service;

import at.schrer.alarms.data.entity.AlarmEntity;
import at.schrer.alarms.data.entity.AlarmTypeEntity;
import at.schrer.alarms.data.entity.FireBrigadeEntity;
import at.schrer.alarms.data.entity.StateEntity;
import at.schrer.alarms.data.model.*;
import at.schrer.alarms.repository.AlarmRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlarmsService {
    private final AlarmRepository alarmRepository;

    public AlarmsService(AlarmRepository alarmRepository) {
        this.alarmRepository = alarmRepository;
    }

    public AlarmsListingModel getAlarms(Date cutoff, Boolean ongoing) {
        if (ongoing == null && cutoff == null) {
            return toAlarmsListing(alarmRepository.findAll());
        }
        if (ongoing != null && cutoff == null) {
            return toAlarmsListing(alarmRepository.findByOngoing(ongoing));
        }
        if (ongoing == null && cutoff != null) {
            return toAlarmsListing(alarmRepository.findByEndTimeAfterOrOngoingTrue(cutoff));
        }

        return toAlarmsListing(alarmRepository.findByEndTimeAfterAndOngoing(cutoff, ongoing));
    }

    private AlarmsListingModel toAlarmsListing(Iterable<AlarmEntity> source){
        List<AlarmModel> alarms = new ArrayList<>();
        Set<FireBrigadeEntity> uniqueBrigades = new HashSet<>();
        for (AlarmEntity alarmEntity: source) {
            List<FireBrigadeEntity> involvedBrigades = alarmEntity.getFireBrigades();
            uniqueBrigades.addAll(involvedBrigades);
            List<FireBrigadeModel> mappedBrigades = involvedBrigades.stream().map(this::toFireBrigade).toList();

            AlarmModel alarmModel = AlarmModel.builder()
                    .id(alarmEntity.getId())
                    .endTime(alarmEntity.getEndTime())
                    .startTime(alarmEntity.getStartTime())
                    .ongoing(alarmEntity.getOngoing())
                    .fireBrigades(mappedBrigades)
                    .type(toAlarmType(alarmEntity.getType()))
                    .build();
            alarms.add(alarmModel);
        }

        return AlarmsListingModel.builder()
                .numAlarms(alarms.size())
                .numInvolvedBrigades(uniqueBrigades.size())
                .alarms(alarms)
                .build();
    }

    private FireBrigadeModel toFireBrigade(FireBrigadeEntity source){
        return FireBrigadeModel.builder()
                .id(source.getId())
                .name(source.getName())
                .state(toState(source.getState()))
                .build();
    }

    private StateModel toState(StateEntity source){
        return switch (source) {
            case UPPER_AUSTRIA -> StateModel.UPPER_AUSTRIA;
            default -> StateModel.OTHER;
        };
    }

    private AlarmTypeModel toAlarmType(AlarmTypeEntity source){
        return switch (source) {
            case FIRE -> AlarmTypeModel.FIRE;
            case TECHNICAL -> AlarmTypeModel.TECHNICAL;
            default -> AlarmTypeModel.OTHER;
        };
    }

}
