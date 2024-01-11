package at.schrer.alarms.client;

import at.schrer.alarms.client.converter.CsvMessageConverter;
import at.schrer.alarms.data.client.bgl.BglFireBrigade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BglBrigadesListingClient extends BaseClient<List<BglFireBrigade>>{
    private static final String DATA_URL = "https://data.bgld.gv.at/files/Abt8/Auflistung-Feuerwehren-Burgenland.csv";
    private static final String META_DATA_URL = "https://www.data.gv.at/katalog/api/3/action/package_show?id=4f1ab1ac-cdfe-42fb-a578-32c7a6e76ed7";

    public BglBrigadesListingClient(){
        super();
        CsvMessageConverter<BglFireBrigade> converter = new CsvMessageConverter<>();
        this.setMessageConverter(converter);
    }

    public List<BglFireBrigade> getAllBrigades(){
        return get(DATA_URL);
    }
}
