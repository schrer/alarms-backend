package at.schrer.alarms.repository;

import at.schrer.alarms.data.entity.FireBrigadeEntity;
import at.schrer.alarms.data.entity.StateEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FireBrigadeRepository extends MongoRepository<FireBrigadeEntity, String> {
    void deleteAllByState(StateEntity state);
}
