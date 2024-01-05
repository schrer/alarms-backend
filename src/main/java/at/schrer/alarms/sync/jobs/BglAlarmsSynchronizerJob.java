package at.schrer.alarms.sync.jobs;

import at.schrer.alarms.sync.updater.BglUpdater;

public class BglAlarmsSynchronizerJob extends GenericAlarmsSynchronizerJob<BglUpdater> {
    public BglAlarmsSynchronizerJob(BglUpdater updater) {
        super(updater);
    }
}