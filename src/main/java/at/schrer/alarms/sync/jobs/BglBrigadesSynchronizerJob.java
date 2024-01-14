package at.schrer.alarms.sync.jobs;

import at.schrer.alarms.sync.updater.BglBrigadesUpdater;

public class BglBrigadesSynchronizerJob extends GenericAlarmsSynchronizerJob<BglBrigadesUpdater> {
    public BglBrigadesSynchronizerJob(BglBrigadesUpdater updater) {
        super(updater, "Burgenland fire brigades");
    }
}
