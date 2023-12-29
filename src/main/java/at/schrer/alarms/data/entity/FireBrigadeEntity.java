package at.schrer.alarms.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity(name = "FireBrigade")
public class FireBrigadeEntity {
    @Id
    private String id;
    private StateEntity state;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FireBrigadeEntity that = (FireBrigadeEntity) o;
        return Objects.equals(id, that.id) && state == that.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, state);
    }
}
