package at.schrer.alarms.client;

import at.schrer.alarms.data.client.bgl.BglResponseData;
import at.schrer.alarms.data.client.bgl.Operation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BglAlarmsClient extends BaseClient<BglResponseData>{

    private static final String BASE_URL = "https://www.lsz-b.at/fileadmin/fw_apps/api/";

    public BglAlarmsClient() {
        super();
    }

    public List<Operation> getActiveAlarms(){
        return get(BASE_URL).getCurrentOperations();
    }

    public List<Operation> getLast12Hours(){
        return get(BASE_URL).getOperations12h();
    }

    public List<Operation> getLast24Hours(){
        return get(BASE_URL).getOperations24h();
    }
}
