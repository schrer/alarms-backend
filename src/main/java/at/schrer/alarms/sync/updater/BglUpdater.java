package at.schrer.alarms.sync.updater;

import at.schrer.alarms.client.BglAlarmsClient;
import at.schrer.alarms.data.client.bgl.Operation;
import at.schrer.alarms.exception.SynchronizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BglUpdater implements Updater {

    private static final Logger LOGGER = LoggerFactory.getLogger(BglUpdater.class);

    private final BglAlarmsClient alarmsClient;

    public BglUpdater(BglAlarmsClient alarmsClient) {
        this.alarmsClient = alarmsClient;
    }

    @Override
    public void synchronize() throws SynchronizationException {
        LOGGER.warn("Running BGL update");
        List<Operation> allOps = alarmsClient.getLast24Hours();
        LOGGER.warn("Number of operations: " + allOps.size());
        // TODO implement
    }
}
