package at.schrer.alarms.client;

import at.schrer.alarms.client.converter.BglBrigadeCsvMessageConverter;
import at.schrer.alarms.data.client.bgl.BglFireBrigade;
import at.schrer.alarms.data.client.bgl.BglFireBrigadeHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Repository
public class BglBrigadesListingClient {
    private static final String DATA_URL = "https://data.bgld.gv.at/files/Abt8/Auflistung-Feuerwehren-Burgenland.csv";
    private static final String META_DATA_URL = "https://www.data.gv.at/katalog/api/3/action/package_show?id=4f1ab1ac-cdfe-42fb-a578-32c7a6e76ed7";

    private final RestTemplate restTemplate;

    public BglBrigadesListingClient(){
        this.restTemplate = new RestTemplate();
        BglBrigadeCsvMessageConverter converter = new BglBrigadeCsvMessageConverter();
        this.restTemplate.setMessageConverters(List.of(converter));
    }

    public List<BglFireBrigade> getAllBrigades(){
        ResponseEntity<BglFireBrigadeHolder> response = restTemplate.getForEntity(DATA_URL, BglFireBrigadeHolder.class);
        BglFireBrigadeHolder body = response.getBody();
        if (body == null || body.getBrigades() == null) {
            return List.of();
        }
        return response.getBody().getBrigades();
    }
}
