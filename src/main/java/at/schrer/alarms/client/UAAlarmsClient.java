package at.schrer.alarms.client;

import at.schrer.alarms.data.client.upperaustria.UAResponseData;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UAAlarmsClient extends BaseClient<UAResponseData>{

    private static final String BASE_URL = "https://cf-intranet.ooelfv.at/webext2/rss/";

    public UAAlarmsClient() {
        super();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(List.of(MediaType.TEXT_PLAIN));
        this.setMessageConverter(converter);
    }

    // https://www.ooelfv.at/feuerwehr-intern/edv/alarmierungen-verfuegbare-publikationsformen/

    // offen und nicht älter als 2 Tage, Erstellung jede Minute (5 Minuten bei Starklast)
    public UAResponseData getActiveAlarms() {
        return get(BASE_URL + "json_laufend.txt");
    }

    // 6 stunden: offen oder nicht älter als 6 Stunden, Erstellung jede Minute (5 Minuten bei Starklast)
    public UAResponseData getLast6Hours(){
        return get(BASE_URL + "json_6stunden.txt");
    }

    // taeglich: alle Einsätze des aktuellen Tages, Erstellung jede Minute (5 Minuten bei Starklast)
    public UAResponseData getDailyReport(){
        return get(BASE_URL + "json_taeglich.txt");
    }

    // 2 Tage: Vorgestern bis Heute, Erstellung zu jeder 1/4 Stunde
    public UAResponseData getTwoDayReport(){
        return get(BASE_URL + "json_2tage.txt");
    }
}
