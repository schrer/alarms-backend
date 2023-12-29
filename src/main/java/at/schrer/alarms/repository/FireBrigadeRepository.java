package at.schrer.alarms.repository;

import at.schrer.alarms.data.entity.FireBrigadeEntity;
import org.springframework.data.repository.CrudRepository;

public interface FireBrigadeRepository extends CrudRepository<FireBrigadeEntity, String> {
}
