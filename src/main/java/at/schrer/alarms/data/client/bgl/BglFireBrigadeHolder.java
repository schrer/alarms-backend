package at.schrer.alarms.data.client.bgl;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BglFireBrigadeHolder {
    List<BglFireBrigade> brigades;

    public BglFireBrigadeHolder(List<BglFireBrigade> brigades) {
        this.brigades = brigades;
    }
}
