package at.schrer.alarms.sync.updater;

import at.schrer.alarms.exception.SynchronizationException;

public interface Updater {
    void synchronize() throws SynchronizationException;
}
