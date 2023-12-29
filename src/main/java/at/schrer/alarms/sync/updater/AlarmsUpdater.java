package at.schrer.alarms.sync.updater;

import at.schrer.alarms.exception.SynchronizationException;

public interface AlarmsUpdater {
    void synchronize() throws SynchronizationException;
}
