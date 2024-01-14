package at.schrer.alarms.sync.updater;

import at.schrer.alarms.client.BglBrigadesListingClient;
import at.schrer.alarms.data.client.bgl.BglFireBrigade;
import at.schrer.alarms.data.entity.FireBrigadeEntity;
import at.schrer.alarms.data.entity.StateEntity;
import at.schrer.alarms.exception.SynchronizationException;
import at.schrer.alarms.repository.FireBrigadeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BglBrigadesUpdater implements Updater {
    private static final Logger LOGGER = LoggerFactory.getLogger(BglBrigadesUpdater.class);

    private final BglBrigadesListingClient brigadesListingClient;
    private final FireBrigadeRepository brigadesRepository;

    public BglBrigadesUpdater(BglBrigadesListingClient brigadesListingClient, FireBrigadeRepository brigadesRepository) {
        this.brigadesListingClient = brigadesListingClient;
        this.brigadesRepository = brigadesRepository;
    }

    @Override
    public void synchronize() throws SynchronizationException {
        List<FireBrigadeEntity> fireBrigades = brigadesListingClient.getAllBrigades().stream()
                .map(this::toFireBrigadeEntity)
                .toList();

        if(fireBrigades.isEmpty()) {
            LOGGER.error("List of fire brigades in Burgenland retrieved from API is empty. Working with data already existing in database.");
            throw new SynchronizationException("List of fire brigades in Burgenland retrieved from API is empty.");
        }

        brigadesRepository.deleteAllByState(StateEntity.BURGENLAND);
        brigadesRepository.saveAll(fireBrigades);
        LOGGER.warn("Updated list of fire brigades in Burgenland.");
    }

    private FireBrigadeEntity toFireBrigadeEntity(BglFireBrigade source){
        String id = StateEntity.BURGENLAND.name() + source.getName().toLowerCase();
        return FireBrigadeEntity.builder()
                .id(id)
                .name(source.getName())
                .state(StateEntity.BURGENLAND)
                .postcode(source.getPostcode())
                .city(source.getCity())
                .street(source.getStreet())
                .build();
    }
}
