package at.schrer.alarms.sync.jobs;

import at.schrer.alarms.exception.SynchronizationException;
import at.schrer.alarms.sync.updater.UAUpdater;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UAAlarmsSynchronizerJob implements Job {
    private static final Logger LOGGER = LoggerFactory.getLogger(UAAlarmsSynchronizerJob.class);

    private final UAUpdater updater;

    public UAAlarmsSynchronizerJob(UAUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.debug("Running Upper Austria Sync Job");
        try {
            this.updater.synchronize();
        } catch (SynchronizationException e) {
            throw new JobExecutionException(e);
        }
    }
}
