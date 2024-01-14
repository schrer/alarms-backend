package at.schrer.alarms.sync.updater;

import at.schrer.alarms.client.BglAlarmsClient;
import at.schrer.alarms.data.client.bgl.Operation;
import at.schrer.alarms.data.entity.AlarmEntity;
import at.schrer.alarms.exception.SynchronizationException;
import at.schrer.alarms.repository.AlarmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BglUpdater implements Updater {

    private static final Logger LOGGER = LoggerFactory.getLogger(BglUpdater.class);

    private final BglAlarmsClient alarmsClient;
    private final AlarmRepository alarmRepository;

    public BglUpdater(BglAlarmsClient alarmsClient, AlarmRepository alarmRepository) {
        this.alarmsClient = alarmsClient;
        this.alarmRepository = alarmRepository;
    }

    @Override
    public void synchronize() throws SynchronizationException {
        LOGGER.warn("Running BGL update");
        List<Operation> allOps = alarmsClient.getLast24Hours();
        LOGGER.warn("Number of operations: " + allOps.size());
        // TODO implement

        List<AlarmEntity> alarmEntities = allOps.stream().map(this::toAlarmEntity).toList();
        //alarmRepository.saveAll(alarmEntities);
    }

    private AlarmEntity toAlarmEntity(Operation source){
        return AlarmEntity.builder().build();
    }
}
