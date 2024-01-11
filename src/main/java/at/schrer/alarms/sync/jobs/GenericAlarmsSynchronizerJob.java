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

    public GenericAlarmsSynchronizerJob(T updater) {
        this.updater = updater;
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.debug("Running Upper Austria Sync Job");
        try {
            this.updater.synchronize();
        } catch (SynchronizationException e) {
            throw new JobExecutionException(e);
        }
    }
}
