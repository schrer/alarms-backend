package at.schrer.alarms.sync.jobs;

import at.schrer.alarms.sync.updater.UAUpdater;
import org.springframework.stereotype.Component;

@Component
public class UAAlarmsSynchronizerJob extends GenericAlarmsSynchronizerJob<UAUpdater> {
    public UAAlarmsSynchronizerJob(UAUpdater updater) {
        super(updater);
    }
}
