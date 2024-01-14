package at.schrer.alarms.data.client.bgl;

import java.util.List;

public class BglFireBrigadeHolder {
    List<BglFireBrigade> brigades;

    public BglFireBrigadeHolder(List<BglFireBrigade> brigades) {
        this.brigades = brigades;
    }

    public List<BglFireBrigade> getBrigades() {
        return brigades;
    }

    public void setBrigades(List<BglFireBrigade> brigades) {
        this.brigades = brigades;
    }
}
