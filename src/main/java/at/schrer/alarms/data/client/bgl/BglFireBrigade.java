package at.schrer.alarms.data.client.bgl;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BglFireBrigade {

    @CsvBindByPosition(position = 0)
    private String name;
    @CsvBindByPosition(position = 1)
    private String street;
    @CsvBindByPosition(position = 2)
    private String postcode;
    @CsvBindByPosition(position = 3)
    private String city;
}
