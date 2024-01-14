package at.schrer.alarms.sync.jobs;

import at.schrer.alarms.exception.SynchronizationException;
import at.schrer.alarms.sync.updater.Updater;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GenericAlarmsSynchronizerJob<T extends Updater> implements Job {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final T updater;
    private final String targetName;

    protected GenericAlarmsSynchronizerJob(T updater, String targetName) {
        this.updater = updater;
        this.targetName = targetName;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.debug("Running Sync Job for: {}", this.targetName);
        try {
            this.updater.synchronize();
        } catch (SynchronizationException e) {
            throw new JobExecutionException(e);
        }
    }
}
